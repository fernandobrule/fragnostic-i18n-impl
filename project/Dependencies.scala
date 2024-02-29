import sbt.*

object Dependencies {

  lazy val fragnosticI18nApi       = "com.fragnostic"        % "fragnostic-i18n-api_2.13"  % "0.1.4"
  lazy val fragnosticSupport       = "com.fragnostic"        % "fragnostic-support_2.13"   % "0.1.19"
  lazy val logbackClassic          = "ch.qos.logback"        % "logback-classic"           % "1.5.0" % "runtime"
  lazy val scalatestFunSpec        = "org.scalatest"        %% "scalatest-funspec"         % "3.2.18" % Test
  lazy val slf4jApi                = "org.slf4j"             % "slf4j-api"                 % "2.0.0-alpha5"

}
