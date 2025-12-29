def call(Closure body) {
    try {
        echo "Starting Maven build"
        sh 'mvn clean package'
        body()
    } catch (err) {
        notifySlack("Build failed", "ERROR")
        throw err
    } finally {
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
    }
}
