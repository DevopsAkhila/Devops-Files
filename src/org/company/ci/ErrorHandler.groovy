package org.company.ci

class ErrorHandler implements Serializable {
    def steps

    ErrorHandler(steps) {
        this.steps = steps
    }

    def handle(Exception e) {
        steps.echo "Handled error: ${e.message}"
    }
}
