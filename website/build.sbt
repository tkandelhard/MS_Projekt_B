name := """website"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.glassfish.jersey.core" % "jersey-client" % "2.8",
  "info.movito" % "themoviedbapi" % "1.1"
)

