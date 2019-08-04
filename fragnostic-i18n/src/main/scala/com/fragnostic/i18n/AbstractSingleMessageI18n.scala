package com.fragnostic.i18n

import java.io.File
import java.net.{ URL, URLClassLoader }
import java.util.{ Locale, MissingResourceException, ResourceBundle }

import com.fragnostic.conf.service.CakeServiceConf
import org.slf4j.{ Logger, LoggerFactory }

trait AbstractSingleMessageI18n extends MessageI18n {

  private def logger: Logger = LoggerFactory.getLogger(getClass.getName)

  def baseDir: String

  def baseName: String

  def getResourceBundle(locale: Locale): Option[ResourceBundle] =
    CakeServiceConf.confService.getConf(baseDir) fold (
      error => None,
      basePath => try {

        if (logger.isInfoEnabled) logger.info(s"\n\t- basePath:\n\t$basePath")

        val file: File = new File(basePath)
        if (logger.isInfoEnabled) logger.info(s"\n\t- file:\n\t$file")

        val urls: Array[URL] = Array(file.toURI.toURL)
        if (logger.isInfoEnabled) logger.info(s"\n\t- file.toURI.toURL:\n\t${file.toURI.toURL}")

        val classLoader: ClassLoader = new URLClassLoader(urls)

        if (logger.isInfoEnabled) logger.info(s"\n\t- locale:\n\t$locale")

        val resourceBundle: ResourceBundle = ResourceBundle.getBundle(baseName, locale, classLoader)

        Some(resourceBundle)

      } catch {
        case e: MissingResourceException =>
          logger.error(s"getResourceBundle() - MissingResourceException : $e")
          None
        case e: Throwable =>
          logger.error(s"getResourceBundle() - Throwable : $e")
          None
      })

  def getString(locale: Locale, key: String): String =
    getResourceBundle(locale) map (
      resourceBundle =>
        try {
          if (logger.isInfoEnabled) logger.info(s"getString() -\n\t- key : $key\n\t- locale.country : ${locale.getCountry}\n\t- locale.language : ${locale.getLanguage}\n\t- rb.locale.country : ${resourceBundle.getLocale.getCountry}\n\t- rb.locale.language : ${resourceBundle.getLocale.getLanguage}")
          resourceBundle.getString(key)
        } catch {
          case e: MissingResourceException =>
            key
          case e: Throwable =>
            key
        }) getOrElse key

  def getFormattedString(
    locale: Locale,
    key: String,
    arguments: List[String]): String =
    format(getString(locale, key), arguments)

}
