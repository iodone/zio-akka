
organization := "com.quasigroup.inc"

name := "zio-akka"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies ++= webStack ++ stackGlue

lazy val webStack = akka ++ http ++ circe ++ sttp ++ jwt
lazy val stackGlue = zio ++ cats

lazy val cats = {
  Seq(
    "org.typelevel" %% "kittens",
    "org.typelevel" %% "cats-effect",
    "org.typelevel" %% "cats-core",
    "org.typelevel" %% "cats-free"
  ).map(_ % "2.2.0")
}

lazy val zio = {
  val version = "1.0.1"
  Seq(
    "dev.zio" %% "zio" % version,
    "dev.zio" %% "zio-interop-cats" % "2.2.0.1",
    "dev.zio" %% "zio-config" % "1.0.0-RC29", 
    "dev.zio" %% "zio-config-magnolia" % "1.0.0-RC29" 
  )
}


lazy val akka = {
  val akkaVersion = "2.6.10"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    //    "com.typesafe.akka" %% "akka-cluster-sharding" % akkaVersion,
    //    "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
    //    "com.typesafe.akka" %% "akka-cluster-tools" % akkaVersion,
    //    "com.typesafe.akka" %% "akka-persistence" % akkaVersion excludeAll (ExclusionRule(
    //      "io.netty"
    //    )),
    //    "com.typesafe.akka" %% "akka-persistence-query" % akkaVersion,
    //    "com.typesafe.akka" %% "akka-distributed-data" % akkaVersion,
    //    "com.typesafe.akka" %% "akka-multi-node-testkit" % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
    "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test
  )
}

lazy val http = {
  val akkaHttpVersion = "10.2.0"
  Seq(
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion,
    "de.heikoseeberger" %% "akka-http-circe" % "1.28.0",
    "ch.megard" %% "akka-http-cors" % "0.4.3",
  )
}

lazy val sttp = {
  Seq(
    "com.softwaremill.sttp.tapir" %% "tapir-json-circe",
    "com.softwaremill.sttp.tapir" %% "tapir-core",
    "com.softwaremill.sttp.tapir" %% "tapir-zio",
    "com.softwaremill.sttp.tapir" %% "tapir-akka-http-server",
  ).map( _ % "0.16.15" ) ++
    Seq(
      "com.softwaremill.sttp.client" %% "core" % "2.2.5",
      "com.softwaremill.sttp.model" %% "core" % "1.1.4"
    )
}

lazy val circe = {
  val circeVersion = "0.13.0"
  Seq(
    "io.circe" %% "circe-core",
    "io.circe" %% "circe-generic",
    "io.circe" %% "circe-parser"
  ).map(_ % circeVersion)
}

lazy val jwt = {
  Seq(
    "com.pauldijou" %% "jwt-circe" % "4.2.0"
  )
}
