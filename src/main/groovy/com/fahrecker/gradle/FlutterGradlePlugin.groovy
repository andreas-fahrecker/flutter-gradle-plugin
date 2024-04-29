package com.fahrecker.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class FlutterGradlePlugin implements Plugin<Project> {
    void apply(Project project) {
        FlutterExtension extension = project.extensions.create("flutter", FlutterExtension, project)
        
        project.task("flutterDoctor") {
            group = "flutter"
            doLast {
                project.exec {
                    commandLine flutterCommand("doctor")
                }
            }
        }

        project.task("flutterVersion") {
            group = "flutter"
            doLast {
                project.exec {
                    commandLine flutterCommand("--version")
                }
            }
        }

        project.task("dartBuildRunner") {
            group = "flutter"
            doLast {
                project.exec {
                    commandLine dartCommand("run", "build_runner", "build", "--delete-conflicting-outputs")
                }
            }
        }

        project.task("flutterBuildApk") {
            group = "flutter"
            doLast {
                project.exec {
                    commandLine flutterCommand("build", "apk")
                }
            }
        }

        project.task("flutterBuildWeb") {
            group = "flutter"
            doLast {
                project.exec {
                    commandLine flutterCommand("build", "web")
                }
            }
        }

        project.task("flutterBuildWindows") {
            group = "flutter"
            doLast {
                project.exec {
                    commandLine flutterCommand("build", "windows")
                }
            }
        }

        project.task("flutterRunChrome") {
            group = "flutter"
            doLast {
                project.exec {
                    commandLine flutterCommand("run", "-d", "chrome")
                }
            }
        }

        project.task("flutterRunWindows") {
            group = "flutter"
            doLast {
                project.exec {
                    commandLine flutterCommand("run", "-d", "windows")
                }
            }
        }
    }

    List<String> dartCommand(String... args) {
        if (System.getProperty('os.name').toLowerCase().contains('windows')) {
            return ['cmd', '/c', 'dart'] + args.toList()
        } else {
            return ['dart'] + args.toList()
        }
    }

    List<String> flutterCommand(String... args) {
        if (System.getProperty('os.name').toLowerCase().contains('windows')) {
            return ['cmd', '/c', 'flutter'] + args.toList()
        } else {
            return ['flutter'] + args.toList()
        }
    }
}