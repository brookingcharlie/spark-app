# Spark Application

Simple Scala application to get started with Apache Spark.

Based on the official Apache Spark guides:
[Quick Start](http://spark.apache.org/docs/1.6.0/quick-start.html) and
[Submitting Applications](http://spark.apache.org/docs/1.6.0/submitting-applications.html).

## Editing code

The main program file is located at `src/main/scala/App.scala`.

You can edit the code using an ordinary text editor.

Alternatively, you can use the [sbteclipse](https://github.com/typesafehub/sbteclipse) plugin
to generate Eclipse project files. Run the command below then open Eclipse and select
*File > Import... > Existing Projects into Workspace*.

```
sbt eclipse 
```

API references:

* http://spark.apache.org/docs/1.6.0/api/scala/index.html
* http://www.scala-lang.org/api/2.10.6/index.html

## Packaging the application

Use the following command to package your Spark application as a JAR file.

```
sbt package
```

## Running using a short-lived Spark cluster

Use the following command to run a Spark cluster where `local[N]` indicates the number of
worker threads.

```
/opt/spark/bin/spark-submit --class App --master local[2] target/scala-2.10/*.jar
```

## Running using a standalone Spark cluster

To create a local Spark cluster with a single slave:

```
/opt/spark/sbin/start-master.sh -h 192.168.50.4
/opt/spark/sbin/start-slave.sh -h 192.168.50.4 -m 1G spark://192.168.50.4:7077
```

To submit a job to the Spark cluster:

```
/opt/spark/bin/spark-submit --class App --master spark://192.168.50.4:7077 target/scala-2.10/*.jar
```

To create a local Spark cluster with two slaves:

```
/opt/spark/sbin/start-master.sh -h 192.168.50.4
/opt/spark/bin/spark-class org.apache.spark.deploy.worker.Worker -h 192.168.50.4 -m 1G spark://192.168.50.4:7077 &
/opt/spark/bin/spark-class org.apache.spark.deploy.worker.Worker -h 192.168.50.4 -m 1G spark://192.168.50.4:7077 &
```
