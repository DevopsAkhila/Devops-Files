pipeline {
    agent any

    tools {
        maven 'mymaven'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
                echo "Building branch: ${env.BRANCH_NAME}"
            }
        }

        stage('Java Compile') {
            when {
                branch 'java'
            }
            steps {
                sh 'mvn compile'
            }
        }

        stage('Java Package') {
            when {
                branch 'java'
            }
            steps {
                sh 'mvn package'
            }
        }

        stage('Python App') {
            when {
                branch 'python'
            }
            steps {
                sh '''
                echo "Python Application"
                python3 --version
                pip3 install -r requirements.txt
                python3 app.py
                '''
            }
        }
    }

    post {
        success {
            echo "Build SUCCESS for ${env.BRANCH_NAME}"
        }
        failure {
            echo "Build FAILED for ${env.BRANCH_NAME}"
        }
    }
}
