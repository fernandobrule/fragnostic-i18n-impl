package com.fragnostic.i18n

import com.fragnostic.i18n.support.SingleMessageI18n

class SingleMessageLocaleNullTest extends SingleMessageI18n {

  describe("Single Message Locale Null Test") {

    it("Can Get String With Locale Null") {

      assertResult(getString(locale = null, key = "service.hello"))("oi")

    }

  }

}
