# Jenkins Shared Library

Production-grade shared library for Jenkins pipelines.

## Features
- Slack notifications
- Standard Maven build wrapper
- Centralized error handling

## Usage

```groovy
@Library('shared@1.0') _

pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        logEnvironment()
        withMavenBuild {
          notifySlack("Build completed", "SUCCESS")
        }
      }
    }
  }
}
