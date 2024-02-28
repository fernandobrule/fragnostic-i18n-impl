#!/bin/bash

export TEST_FRAGNOSTIC_WEB_I18N_BASE_DIR=./fragnostic-i18n-impl/src/test/resources/i18n/web
export TEST_FRAGNOSTIC_WEB_I18N_BASE_NAME="com.fragnostic.i18n.fragnostic-web-mensajes"

export TEST_FRAGNOSTIC_SERVICE_I18N_BASE_DIR=./fragnostic-i18n-impl/src/test/resources/i18n/service
export TEST_FRAGNOSTIC_SERVICE_I18N_BASE_NAME="com.fragnostic.i18n.fragnostic-service-mensajes"

export LOCALE_DEFAULT_LANG=pt
export LOCALE_DEFAULT_RGN=BR

./sbt -v -213
