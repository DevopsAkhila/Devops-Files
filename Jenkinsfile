pipeline {
    agent any

    tools {
        maven 'mymaven'   // Jenkins → Global Tool Configuration
    }

    environment {
        MAVEN_OPTS = '-Xmx1024m'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
                echo "Building Java branch: ${env.BRANCH_NAME}"
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
    }

    post {
        success {
            echo "Java Build SUCCESS for ${env.BRANCH_NAME}"
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
        }
        failure {
            echo "Java Build FAILED for ${env.BRANCH_NAME}"
        }
        always {
            cleanWs()
        }
    }
}
