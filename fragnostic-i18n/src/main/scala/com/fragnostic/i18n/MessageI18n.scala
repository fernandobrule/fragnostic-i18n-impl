package com.fragnostic.i18n

import java.util.Locale

import com.fragnostic.support.StringSupport

trait MessageI18n extends StringSupport {

  def getString(locale: Locale, code: String): String

  def getFormattedString(
    locale: Locale,
    code: String,
    arguments: List[String]): String

}
