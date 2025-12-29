pipeline{
    agent{
        docker{
            image 'python:3.12-slim'
        }
    }
    environment{
        VENV = '.venv' //virtual environment variable
        PYTHONPATH = '.' //python environment/container to be created in the current directory
    }
    stages{
        stage('Clone the repo'){
            steps{
                git branch: 'Calculator-python-app', url: 'https://github.com/DevopsAkhila/Devops-Files.git'
            }
        }
        stage('Set up python environment and install dependencies'){
            steps{
                sh '''
                # Create the environment
                python -m venv ${VENV}
                # Activating the python environment
                . ${VENV}/bin/activate
                # Upgrade pip
                pip install --upgrade pip
                # Install the dependencies
                pip install -r requirements.txt
                '''
            }
        }
        stage('Review the code'){
            steps{
                sh '''
                # Activate the environment
                . ${VENV}/bin/activate
                # Run the code review tool
                flake8 app/ tests/
                '''
            }
        }
        stage('Run Tests on Application'){
            steps{
                sh '''
                # Activate the environment
                . ${VENV}/bin/activate
                # Run the tests
                pytest --junitxml=reports/results.xml --cov=calculator --cov-report=xml
                '''
            }
        }
    }


}
