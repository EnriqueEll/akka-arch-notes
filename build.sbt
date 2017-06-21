import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.akkaarch",
      scalaVersion := "2.12.1",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "AkkaArch",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += scala,
    libraryDependencies ++= webJars,
    libraryDependencies ++= akka
  )
