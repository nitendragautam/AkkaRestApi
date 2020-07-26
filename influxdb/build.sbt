name := "Scala practice"
organization:="com.nitendratech"
version := "1.0"

scalaVersion := "2.12.8"

libraryDependencies ++={
  val akkaV ="2.4.12"
  Seq(
    "org.influxdb" % "influxdb-java" % "2.6"

  )
}