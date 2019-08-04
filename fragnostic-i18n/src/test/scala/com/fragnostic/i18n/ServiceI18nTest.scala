package com.fragnostic.i18n

import java.util.Locale

import org.scalatest.{ FunSpec, Matchers }

class ServiceI18nTest extends FunSpec with Matchers with AbstractSingleMessageI18n {

  override def baseName: String = "com.fragnostic.i18n.fragnostic-service-mensajes"

  override def baseDir: String = "TEST_FRAGNOSTIC_SERVICE_I18N_BASE_DIR"

  describe("Service I18n Test") {

    it("Can Get String en_US") {

      val language = "en"
      val region = "US"

      val locale: Locale = new Locale.Builder()
        .setLanguage(language)
        .setRegion(region)
        .build()

      getString(locale, "service.hello") should be("hello")

    }

    it("Can Get String es_CL") {

      val language = new String("es")
      val region = new String("CL")
      val locale: Locale = new Locale(language, region)

      getString(locale, "service.hello") should be("hola")

    }

    it("Can Get String pt_BR") {

      val language = "pt"
      val region = "BR"

      val locale: Locale = new Locale.Builder()
        .setLanguage(language)
        .setRegion(region)
        .build()

      getString(locale, "service.hello") should be("oi")

    }

  }

}
