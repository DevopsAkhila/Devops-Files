pipeline {
    agent any

    stages {

        stage('Check Python') {
            steps {
                sh 'python3 --version'
            }
        }

        stage('Install Dependencies') {
            steps {
                sh '''
                    python3 -m pip install -r requirements.txt || echo "pip not available"
                '''
            }
        }

        stage('Run Application') {
            steps {
                sh 'python3 app.py'
            }
        }
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
