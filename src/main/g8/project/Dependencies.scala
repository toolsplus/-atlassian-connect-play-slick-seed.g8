import sbt._

object Dependencies {
  val app = Seq(
    Library.atlassianConnectPlayCore,
    Library.atlassianConnectPlaySlick,
    Library.playSlickEvolutions,
    Library.h2,
    Library.scalaTestPlusPlay % Test
  )
}

object Version {
  val atlassianConnectPlay = "0.1.10"
  val atlassianConnectPlaySlick = "0.1.3"
  val playSlick = "3.0.1"
  val h2 = "1.4.196"
  val scalaTestPlusPlay = "3.1.2"
}

object Library {
  val atlassianConnectPlayApi = "io.toolsplus" %% "atlassian-connect-play-api" % Version.atlassianConnectPlay
  val atlassianConnectPlayCore = "io.toolsplus" %% "atlassian-connect-play-core" % Version.atlassianConnectPlay
  val atlassianConnectPlaySlick = "io.toolsplus" %% "atlassian-connect-play-slick" % Version.atlassianConnectPlaySlick
  val playSlickEvolutions = "com.typesafe.play" %% "play-slick-evolutions" % Version.playSlick
  val h2 = "com.h2database" % "h2" % Version.h2
  val scalaTestPlusPlay = "org.scalatestplus.play" %% "scalatestplus-play" % Version.scalaTestPlusPlay
}
