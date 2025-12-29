package org.company.ci

class SlackHelper implements Serializable {
    def steps

    SlackHelper(steps) {
        this.steps = steps
    }

    def send(String msg) {
        steps.echo "Sending Slack message: ${msg}"
    }
}
