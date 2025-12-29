def call(String message, String status = 'INFO') {
    echo "[Slack] ${status}: ${message}"

    if (env.SLACK_ENABLED == 'true') {
        slackSend(
            channel: '#ci-cd',
            message: "[${status}] ${env.JOB_NAME} #${env.BUILD_NUMBER} - ${message}"
        )
    }
}
