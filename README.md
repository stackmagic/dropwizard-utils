dropwizard-util
===============

Miscellaneous dropwizard utilities. I try to keep the version number in sync
with the [dropwizard](http://dropwizard.io) version.

[ ![TravicCI](https://travis-ci.org/stackmagic/dropwizard-util.svg?branch=master) ](https://travis-ci.org/stackmagic/dropwizard-util)
[ ![Download](https://api.bintray.com/packages/stackmagic/maven/dropwizard-util/images/download.svg) ](https://bintray.com/stackmagic/maven/dropwizard-util/_latestVersion)

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
