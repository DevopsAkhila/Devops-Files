pipeline {
    agent any

    environment {
        VENV_DIR = 'venv'
    }

    stages {

        stage('Python Application Info') {
            steps {
                echo 'Python Application'
                sh 'python3 --version'
            }
        }

        stage('Setup Python Environment') {
            steps {
                echo 'Creating virtual environment'
                // Create virtual environment
                sh """
                    python3 -m venv ${VENV_DIR} || echo 'venv exists'
                    source ${VENV_DIR}/bin/activate
                    pip install --upgrade pip
                """
            }
        }

        stage('Install Dependencies') {
            steps {
                echo 'Installing Python dependencies'
                sh """
                    source ${VENV_DIR}/bin/activate
                    pip install -r requirements.txt
                """
            }
        }

        stage('Run Application') {
            steps {
                echo 'Running Python application'
                sh """
                    source ${VENV_DIR}/bin/activate
                    python your_app.py
                """
            }
        }
    }

    post {
        success {
            echo 'Build SUCCESS for Python'
        }
        failure {
            echo 'Build FAILED for Python'
        }
    }
}
