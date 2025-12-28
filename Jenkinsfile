pipeline {
    agent any

    tools {
        maven 'mymaven'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
            cleanWs()
        }

        success {
            echo 'Java Build SUCCESS'
        }

        failure {
            echo 'Java Build FAILED'
        }
    }
}
