package com.fragnostic.i18n

import com.fragnostic.i18n.impl.AbstractSingleMessageI18n
import org.scalatest.funspec._

import java.util.Locale

class WebI18nTest extends AnyFunSpecLike with AbstractSingleMessageI18n {

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

      assertResult(getString(locale, "web.hello"))("hello")

    }

    it("Can Get String es_CL") {

      val language = "es"
      val region = "CL"

      val locale: Locale = new Locale.Builder()
        .setLanguage(language)
        .setRegion(region)
        .build()

      assertResult(getString(locale, "web.hello"))("hola")
    }

    it("Can Get String pt_BR") {

      val language = "pt"
      val region = "BR"

      val locale: Locale = new Locale.Builder()
        .setLanguage(language)
        .setRegion(region)
        .build()

      assertResult(getString(locale, "web.hello"))("oi")

    }

  }

}
