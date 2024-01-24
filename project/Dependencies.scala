import sbt._

object Dependencies {

  lazy val fragnosticI18nApi       = "com.fragnostic"  % "fragnostic-i18n-api_2.13" % "0.1.4-SNAPSHOT"
  lazy val fragnosticSupport       = "com.fragnostic"  % "fragnostic-support_2.13"  % "0.1.19-SNAPSHOT"

  lazy val logbackClassic             = "ch.qos.logback"             % "logback-classic"                     % "1.3.0-alpha16"
  //lazy val slf4jApi                = "org.slf4j"       % "slf4j-api"                % "2.0.0-alpha5"
  lazy val scalatestFunSpec        = "org.scalatest"   % "scalatest-funspec_2.13"   % "3.3.0-SNAP3" % Test

}
