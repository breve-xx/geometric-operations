# geometric-operations

This is a simple Java/Maven application that models a [Line](https://en.wikipedia.org/wiki/Line_(geometry)), by its linear equation, and some of its properties:

- Parallelism
- Perpendicularity
- Incidence

NOTE: The application doesn't have a proper CLI, all the logic are unit tested: look @ them.

## Maven

As usual you can run the JUnit using
```
mvn clean test
```
and build&run a JAR file using
```
mvn clean package
java -jar target/geometric-operations-1.0-SNAPSHOT-jar-with-dependencies.jar
```
## Gradle

In the repository there's a branch called `gradle-migration` where I tried to migrate from Maven to Gradle starting from [this awesome post](http://www.rationaljava.com/2016/02/moving-from-maven-to-gradle-in-under-5.html), but as you can expect, I had to tweak it a bit.

If you checkout it you can run the JUnit using
```
gradle clean test
```
and build&run a JAR file using
```
gradle clean fatJar
java -jar build/libs/geometric-operations-all-1.0-SNAPSHOT.jar
```
give it a try!
