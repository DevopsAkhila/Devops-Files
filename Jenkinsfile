pipeline {
    agent any

    stages {
        stage('Bootstrap pip & Run') {
            steps {
                sh '''
                    # Download pip bootstrapper
                    curl -sS https://bootstrap.pypa.io/get-pip.py -o get-pip.py

                    # Install pip for Jenkins user
                    python3 get-pip.py --user

                    # Add local pip to PATH
                    export PATH=$HOME/.local/bin:$PATH

                    # Verify pip
                    pip --version

                    # Install dependencies
                    pip install -r requirements.txt

                    # Run app
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
