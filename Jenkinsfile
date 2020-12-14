pipeline {

    agent any

    stages {
        stage ('Build'){
            steps {
                git url: 'https://github.com/SudhaRao/spingmvc.git'
                    sh 'mvn clean package'

            }
        }
        stage ('Test'){
            steps {
                    sh 'mvn test'

            }
        }
        stage ('Deploy'){
            steps {
                    sh 'mvn deploy'

            }
        }
    }
}