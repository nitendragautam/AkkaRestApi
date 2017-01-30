
organization := "Nitendra Gautam"

version := "1.0"

scalaVersion := "2.11.8"
scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")
mainClass in assembly := Some("com.nitendragautam.kafkarestapi.main.main.Boot")
assemblyJarName in assembly := "kafkarestapiapp.jar"
resolvers += Resolver.bintrayRepo("cakesolutions", "maven")
libraryDependencies ++= {
  val akkaV       = "2.4.11"
  val kafkaV       ="0.10.1.0"
  val scalaV="2.11.8"

  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaV,
    "org.slf4j" % "slf4j-log4j12" % "1.7.21",
    "log4j" % "log4j" % "1.2.17",
    "org.json" % "json" % "20160810",
    "net.cakesolutions" %% "scala-kafka-client" % "0.10.1.1",
    "net.cakesolutions" %% "scala-kafka-client-akka" % "0.10.1.1",
    "org.apache.kafka" % "kafka_2.11" % "0.9.0.1"


  )
}

