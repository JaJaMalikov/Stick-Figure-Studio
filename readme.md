Android app that allows a user to create stick figure animations similar to pivot on desktop.

## Desktop Version

A new `desktop` module has been added that builds a Java application using the same
animation code. It relies on the Processing core library and bundles the shared
`Util` and `drawableObjects` packages from the Android project.

To build the desktop application using the system Gradle:

```bash
# from the repository root
gradle -c desktop/settings.gradle -p desktop build
```

The runnable JAR will be located in `desktop/build/libs/`.
