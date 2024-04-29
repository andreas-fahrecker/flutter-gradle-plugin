package com.fahrecker.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property

class FlutterGradlePlugin implements Plugin<Project> {
    void apply(Project project) {
        FlutterExtension extension = project.extensions.create("flutter", FlutterExtension, project)
        
        project.task("flutterDoctor") {
            doLast {
                project.exec {
                    commandLine flutterCommand("doctor")
                }
            }
        }

        project.task("flutterVersion") {
            doLast {
                project.exec {
                    commandLine flutterCommand("--version")
                }
            }
        }

        project.task("flutterBuildApk") {
            doLast {
                project.exec {
                    commandLine flutterCommand("build", "apk")
                }
            }
        }
    }

    List<String> flutterCommand(String... args) {
        if (System.getProperty('os.name').toLowerCase().contains('windows')) {
            return ['cmd', '/c', 'flutter'] + args
        } else {
            return ['flutter'] + args
        }
    }
}