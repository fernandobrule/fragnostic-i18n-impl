package com.fragnostic.i18n

import com.fragnostic.i18n.support.SingleMessageI18n

import java.util.Locale

class SingleMessageTest extends SingleMessageI18n {

  describe("Single Message Test") {

    it("Can Get String en_US") {

      val language = "en"
      val region = "US"

      val locale: Locale = new Locale.Builder()
        .setLanguage(language)
        .setRegion(region)
        .build()

      assertResult(getString(locale, "service.hello"))("hello")

    }

    it("Can Get String es_CL") {

      val language = new String("es")
      val region = new String("CL")
      val locale: Locale = new Locale(language, region)

      assertResult(getString(locale, "service.hello"))("hola")

    }

    it("Can Get String pt_BR") {

      val language = "pt"
      val region = "BR"

      val locale: Locale = new Locale.Builder()
        .setLanguage(language)
        .setRegion(region)
        .build()

      assertResult(getString(locale, "service.hello"))("oi")

    }

  }

}
