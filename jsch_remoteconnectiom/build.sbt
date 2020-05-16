name := "Scala practice"
organization:="com.nitendragautam"
version := "1.0"

scalaVersion := "2.12.8"

libraryDependencies ++={
  val akkaV ="2.4.12"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "commons-io" % "commons-io" % "2.5",
    "com.jcraft" % "jsch" % "0.1.54",
    "org.slf4j" % "slf4j-api" % "1.7.30"

  )
}