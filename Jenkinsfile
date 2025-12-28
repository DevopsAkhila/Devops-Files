pipeline {
    agent any
        stages {
        stage('Check Python') {
            steps {
                sh 'python --version'
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'pip install -r requirements.txt'
            }
        }

        stage('Run Application') {
            steps {
                sh 'python app.py'
            }

    post {
        success {
            echo 'Python build SUCCESS'
        }
        failure {
            echo 'Python build FAILED'
        }
    }
}
        }
