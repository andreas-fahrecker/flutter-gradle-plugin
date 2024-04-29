package com.fahrecker.gradle

class FlutterExtension {
    final Property<String> flutterVersion
    final Property<String> flutterChannel
    final Property<String> flutterSdkPath

    FlutterExtension(Project project) {
        flutterVersion = project.objects.property(String)
        flutterChannel = project.objects.property(String)
        flutterSdkPath = project.objects.property(String)
    }

    void setFlutterVersion(String version) {
        flutterVersion.set(version)
    }

    void setFlutterChannel(String channel) {
        flutterChannel.set(channel)
    }

    void setFlutterSdkPath(String path) {
        flutterSdkPath.set(path)
    }
}