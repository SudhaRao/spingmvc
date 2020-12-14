pipeline {

    agent any
    stages {
        stage ('Build'){
            steps {
                git url: 'https://github.com/SudhaRao/spingmvc.git'
                withMaven(maven: 'maven_4_0_0'){
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
                echo 'Deploying..'
            }
        }
    }
}