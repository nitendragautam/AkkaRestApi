name := "Scala practice"
organization:="com.nitendratech"
version := "1.0"

scalaVersion := "2.12.8"

libraryDependencies ++={
  val akkaV ="2.4.12"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream-kafka" % "2.0.3",
    "com.google.code.gson" % "gson" % "2.8.1",
    "com.lightbend.akka" %% "akka-stream-alpakka-file" % "0.6"
  )
}