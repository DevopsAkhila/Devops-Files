pipeline {
    agent any

    stages {
        stage('Python Setup') {
            steps {
                sh '''
                    echo "Python Application"
                    python3 --version

                    # Install pip if missing
                    python3 -m ensurepip --upgrade

                    python3 -m pip --version
                    python3 -m pip install --upgrade pip
                '''
            }
        }

        stage('Install Dependencies') {
            steps {
                sh '''
                    python3 -m pip install -r requirements.txt
                '''
            }
        }
    }

    post {
        failure {
            echo "Build FAILED for python"
        }
    }
}
