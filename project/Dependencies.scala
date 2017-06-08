import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1"
  
  lazy val akka = Seq("com.typesafe.akka" %% "akka-http-spray-json" % "10.0.6"
  ,"com.typesafe.akka" %% "akka-http" % "10.0.6"
  ,"com.typesafe.akka" %% "akka-http-core" % "10.0.6")

  lazy val scala = "org.scala-lang.modules" %% "scala-xml" % "1.0.6"
}