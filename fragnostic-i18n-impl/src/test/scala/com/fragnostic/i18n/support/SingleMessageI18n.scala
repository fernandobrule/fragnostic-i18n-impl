package com.fragnostic.i18n.support

import com.fragnostic.i18n.impl.AbstractSingleMessageI18n
import org.scalatest.funspec.AnyFunSpec

trait SingleMessageI18n extends AnyFunSpec with AbstractSingleMessageI18n {

  override def baseDir: String = "TEST_FRAGNOSTIC_SERVICE_I18N_BASE_DIR"

  override def baseName: String = "TEST_FRAGNOSTIC_SERVICE_I18N_BASE_NAME"

}
