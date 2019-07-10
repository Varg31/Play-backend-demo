name := """play-java-hello-world-web"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)
//lazy val myProject = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.13.0"

libraryDependencies ++= Seq(
  guice,
  javaJdbc,
  javaWs,
  javaJpa,
  javaCore,
  "org.hibernate" % "hibernate-core" % "5.4.3.Final",
  "org.hibernate" % "hibernate-entitymanager" % "5.4.3.Final"
)

libraryDependencies += "org.hibernate.javax.persistence" % "hibernate-jpa-2.1-api" % "1.0.2.Final"

//libraryDependencies += "com.typesafe.play" %% "play-java-jpa" % "2.8.0-M2"

libraryDependencies += "org.postgresql" % "postgresql" % "42.2.5"

//PlayKeys.externalizeResourcesExcludes += baseDirectory.value /"conf"/"META-INF"/"persistence.xml"

libraryDependencies += "org.projectlombok" % "lombok" % "1.18.8" % "provided"