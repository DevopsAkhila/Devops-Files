package org.company.ci

class BuildUtils implements Serializable {
    def steps

    BuildUtils(steps) {
        this.steps = steps
    }

    def printJavaVersion() {
        steps.sh 'java -version || true'
    }
}
