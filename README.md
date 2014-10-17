dropwizard-util
===============

Miscellaneous dropwizard utilities. Usually built against the latest version of dropwizard.

[ ![TravicCI](https://travis-ci.org/stackmagic/dropwizard-util.svg?branch=master) ](https://travis-ci.org/stackmagic/dropwizard-util)
[ ![Download](https://api.bintray.com/packages/stackmagic/maven/dropwizard-util/images/download.svg) ](https://bintray.com/stackmagic/maven/dropwizard-util/_latestVersion)

related work
============

* [dropwizard](http://dropwizard.io): Dropwizard itself, obviously
* [gradle-dropwizard](https://github.com/stackmagic/gradle-dropwizard): Launch DW from gradle, builds your fatJar, can also locally start/stop DW for your int/acc tests

downloading
===========

gradle
------

the [jcenter() shortcut requires at least gradle 1.7](http://www.gradle.org/docs/1.7/release-notes#jcenter-repository-support)

```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'net.swisstech:dropwizard-util:+'
}
```

maven
-----

```xml
<repository>
    <id>jcenter</id>
    <url>https://jcenter.bintray.com/</url>
</repository>
```

```xml
<dependency>
    <groupId>net.swisstech</groupId>
    <artifactId>dropwizard-util</artifactId>
    <version>...</version>
</dependency>
```

VersionBundle
=============

This registers a servlet with the admin context that will return the value of
the system property `SERVER_VERSION` via `/version`

Simply add this to your project in the main class (this shows only the relevant
bits, this is not a complete dropwizard application class):

```java
import net.swisstech.dropwizard.util.VersionBundle;

public class MyApp extends Application<MyConfig> {

    @Override
    public void initialize(Bootstrap<MyConfig> bootstrap) {
        bootstrap.addBundle(new VersionBundle());
    }

}
```

Then change the way you start your dropwizard application to include the
`SERVER_VERSION` system property which would look something like this:

```bash
java -jar my-project.jar -DSERVER_VERSION=0.4.2 server config.yml
```

And now you can check what version of your app is running. Personally, I use
this to check whether the new version of a daemon is already up after a
deployment so we can then run smoke tests against the new version.

```bash
curl --silent http://localhost:7001/version
```
