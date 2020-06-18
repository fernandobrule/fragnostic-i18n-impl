package com.fragnostic.i18n

import java.util.Locale

import org.scalatest.{ FunSpec, Matchers }

class WebI18nTest extends FunSpec with Matchers with AbstractSingleMessageI18n {

  override def baseDir: String = "TEST_FRAGNOSTIC_WEB_I18N_BASE_DIR"

  override def baseName: String = "TEST_FRAGNOSTIC_WEB_I18N_BASE_NAME"

  describe("Web I18n Test") {

    it("Can Get String en_US") {

      val language = "en"
      val region = "US"

      val locale: Locale = new Locale.Builder()
        .setLanguage(language)
        .setRegion(region)
        .build()

      getString(locale, "web.hello") should be("hello")

    }

    it("Can Get String es_CL") {

      val language = "es"
      val region = "CL"

      val locale: Locale = new Locale.Builder()
        .setLanguage(language)
        .setRegion(region)
        .build()

      getString(locale, "web.hello") should be("hola")
    }

    it("Can Get String pt_BR") {

      val language = "pt"
      val region = "BR"

      val locale: Locale = new Locale.Builder()
        .setLanguage(language)
        .setRegion(region)
        .build()

      getString(locale, "web.hello") should be("oi")

    }

  }

}
