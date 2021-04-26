name := """shop-project"""
organization := "uj.edu.pl"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"
sbtVersion := "1.5.0"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies += "com.typesafe.play" %% "play-slick" % "4.0.0"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "4.0.0"
libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.30.1"

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
