name := "log-processor"

scalaVersion := "2.11.7"

libraryDependencies ++= {
  Seq(
    "junit" % "junit" % "4.11" % "test",
    "org.apache.hadoop" % "hadoop-core" % "1.1.1"
  )
}
