def call(Closure body) {

    // Use Jenkins-managed Maven
    def mvnHome = tool 'MAVEN-3.9'

    try {
        echo "Starting Maven build"
        sh "${mvnHome}/bin/mvn clean package"
        body()
    } catch (err) {
        notifySlack("Build failed", "ERROR")
        throw err
    } finally {
        archiveArtifacts artifacts: 'target/*.jar',
                        fingerprint: true,
                        allowEmptyArchive: true
    }
}
