import scala.reflect.io.File

name := "scala-utils"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"

coverageMinimum := 80
coverageFailOnMinimum := true
coverageEnabled := true

Test / unmanagedResources / includeFilter := "*.txt"
