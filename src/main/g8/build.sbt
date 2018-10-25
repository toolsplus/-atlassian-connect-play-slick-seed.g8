
name := """$name$"""
organization := "$organization$"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .settings(libraryDependencies ++= Dependencies.app ++ Seq(guice, ws))
  .settings(TwirlKeys.templateFormats += ("json" -> "play.twirl.api.TxtFormat"))

scalaVersion := "2.12.6"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "$organization$.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "$organization$.binders._"
