package com.fragnostic.i18n.impl

import com.fragnostic.i18n.api.ResourceI18n
import com.fragnostic.support.StringSupport
import org.slf4j.{ Logger, LoggerFactory }

import java.io.File
import java.net.{ URL, URLClassLoader }
import java.util.{ Locale, MissingResourceException, ResourceBundle }

trait AbstractSingleMessageI18n extends ResourceI18n with StringSupport {

  private[this] val logger: Logger = LoggerFactory.getLogger(getClass.getName)

  private def getEnvProp(name: String): Option[String] = {
    Option(System.getenv(name))
  }

  private def getConf(envConf: String): Either[String, String] = {
    getEnvProp(envConf) map (value => Right(value)) getOrElse {
      logger.warn(s"getConf() - value na for envConf:$envConf, remember that envConf is an environment variable which have as a value...")
      Left("get.conf.error")
    }
  }

  def baseDir: String

  def baseName: String

  def getResourceBundle(classLoader: ClassLoader, baseName: String): Option[ResourceBundle] = {

    val lang = getEnvProp(name = "LOCALE_DEFAULT_LANG") getOrElse ("es")
    val rgn = getEnvProp(name = "LOCALE_DEFAULT_RGN") getOrElse ("CL")

    logger.warn(s"getResourceBundle() - there is not Locale, we will fall back in values from environment vars LOCALE_DEFAULT_LANG[$lang], LOCALE_DEFAULT_RGN[$rgn]")

    val locale = new Locale.Builder().setLanguage(lang).setRegion(rgn).build()
    Option(ResourceBundle.getBundle(baseName, locale, classLoader))
  }

  def getResourceBundle(localeOpt: Option[Locale]): Option[ResourceBundle] = {
    getConf(baseDir) fold (
      error => None,
      baseDir => getConf(baseName) fold (
        error => None,
        baseName => try {

          val file: File = new File(baseDir)
          val urls: Array[URL] = Array(file.toURI.toURL)
          val classLoader: ClassLoader = new URLClassLoader(urls)

          localeOpt map (locale => Option(ResourceBundle.getBundle(baseName, locale, classLoader))) getOrElse {
            getResourceBundle(classLoader, baseName)
          }

        } catch {
          case e: MissingResourceException =>
            logger.warn(s"getResourceBundle() - baseDir[$baseDir], baseName[$baseName], MissingResourceException : $e")
            None
          case e: Throwable =>
            logger.warn(s"getResourceBundle() - baseDir[$baseDir], baseName[$baseName], Throwable : $e")
            None
        } //
      ) //
    )
  }

  def getString(locale: Locale, key: String): String =
    getResourceBundle(Option(locale)) map (
      resourceBundle =>
        try {
          Option(key) map (
            key => resourceBundle.getString(key) //
          ) getOrElse (key)
        } catch {
          case e: MissingResourceException =>
            logger.warn(s"getString() - ${locale.getLanguage}-${locale.getCountry}/$key, $e")
            key
          case e: Throwable =>
            logger.warn(s"getString() - ${locale.getLanguage}-${locale.getCountry}/$key, $e")
            key
        }) getOrElse {
        logger.warn(s"getString() - ooops, something wrong happens")
        key
      }

  def getFormattedString(locale: Locale, key: String, arguments: List[String]): String = {
    format(getString(locale, key), arguments)
  }

}
