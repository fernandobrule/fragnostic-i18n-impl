package com.fragnostic.i18n

import com.fragnostic.i18n.support.SingleMessageI18n

import java.util.Locale

class LoadTest extends SingleMessageI18n {

  val localeEnUs = new Locale("en", "US")
  val localeEsCl = new Locale("es", "CL")
  val localePtBr = new Locale("pt", "BR")

  describe("*** LoadTest ***") {

    ignore("Can Get String") {
      1 to 10000 foreach (num => {
        assertResult(getString(localeEnUs, "service.hello"))("hello")
        assertResult(getString(localeEsCl, "service.hello"))("hola")
        assertResult(getString(localePtBr, "service.hello"))("oi")
      })
    }

  }

}
