pipeline {

    agent any

    stages {
        stage ('Build'){
            steps {
                git url: 'https://github.com/SudhaRao/spingmvc.git'
                withMaven{
                    sh 'mvn clean package'
                }
            }
        }
        stage ('Test'){
            steps {
                withMaven {
                    sh 'mvn test'
                }
            }
        }
        stage ('Deploy'){
            steps {
                withMaven {
                    sh 'mvn deploy'
                }
            }
        }
    }
}