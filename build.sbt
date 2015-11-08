name := "backend"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)

libraryDependencies += "org.postgresql" % "postgresql" % "9.3-1101-jdbc4"


play.Project.playJavaSettings
