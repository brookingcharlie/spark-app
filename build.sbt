name := "Spark App"

version := "1.0"

scalaVersion := "2.10.6"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.0"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "1.6.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.6.0"
libraryDependencies += "com.databricks" %% "spark-csv" % "1.4.0"

// Resolve dependency conflicts
libraryDependencies += "org.scala-lang" %% "scala-compiler" % "2.10.6"
libraryDependencies += "org.scala-lang" %% "scala-reflect" % "2.10.6"

EclipseKeys.withSource := true
