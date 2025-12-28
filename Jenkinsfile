pipeline {
    agent any

    stages {
        stage('Python Install & Run') {
            steps {
                sh '''
                    # Upgrade pip for the Jenkins user
                    python3 -m pip install --user --upgrade pip

                    # Install dependencies under ~/.local
                    python3 -m pip install --user -r requirements.txt

                    # Run your application
                    python3 app.py
                '''
            }
        }
    }

    post {
        success { echo 'Build SUCCESS for Python' }
        failure { echo 'Build FAILED for Python' }
    }
}
