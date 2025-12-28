pipeline {
    agent any

    stages {

        stage('Python Setup & Run') {
            steps {
                sh '''
                    # Create venv (install python3-venv on agent if missing)
                    python3 -m venv venv || echo 'venv exists'

                    # Activate venv
                    . venv/bin/activate

                    # Upgrade pip and install dependencies
                    pip install --upgrade pip
                    pip install -r requirements.txt

                    # Run your application
                    python app.py
                '''
            }
        }
    }

    post {
        success { echo 'Build SUCCESS for Python' }
        failure { echo 'Build FAILED for Python' }
    }
}
