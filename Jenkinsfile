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
                echo 'Testing..'
            }
        }
        stage ('Deploy'){
            steps {
                echo 'Testing..'
            }
        }
    }
}