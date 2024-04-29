# Flutter Gradle Plugin

This is a Gradle plugin that provides tasks for building and running Flutter applications.

## Tasks

The plugin provides the following tasks:

- `flutterDoctor`: Runs the `flutter doctor` command.
- `flutterVersion`: Runs the `flutter --version` command.
- `dartBuildRunner`: Runs the `dart run build_runner build --delete-conflicting-outputs` command.
- `flutterBuildApk`: Runs the `flutter build apk` command.
- `flutterBuildWeb`: Runs the `flutter build web` command.
- `flutterBuildWindows`: Runs the `flutter build windows` command.
- `flutterRunChrome`: Runs the `flutter run -d chrome` command.
- `flutterRunWindows`: Runs the `flutter run -d windows` command.

## Usage

### With buildscript

To use the plugin, add it to the `buildscript` dependencies in your `build.gradle` file:

```groovy
buildscript {
    repositories {
        maven {
            url = uri("https://gitea.fahrecker.com/api/packages/andreas-personal/maven")
        }
    }
    dependencies {
        classpath 'com.fahrecker:com.fahrecker.flutterGradlePlugin:0.0.7-SNAPSHOT'
    }
}

apply plugin: 'com.fahrecker.flutterGradlePlugin'
```

### Without buildscript

To use the plugin without the buildscript block, add it to the plugins block and the repositories block in your build.gradle file:

```groovy
plugins {
    id 'com.fahrecker.flutterGradlePlugin' version '0.0.7-SNAPSHOT'
}

repositories {
    maven {
        url = uri("https://gitea.fahrecker.com/api/packages/andreas-personal/maven")
    }
    // Other repositories...
}
```

## Running Tasks

You can run the tasks with the gradlew command. For example, to run the flutterDoctor task, use:

```sh
./gradlew flutterDoctor
```

## Source Code

The source code for this project is available on [Gitea](https://gitea.fahrecker.com/andreas-personal/flutter-gradle-plugin) and mirrored on [GitHub](https://github.com/andreas-fahrecker/flutter-gradle-plugin).