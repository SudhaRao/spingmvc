pipeline {

    agent any
    stages {
        stage ('Build'){
            steps {
                withMaven(maven: 'maven_4.0.0') {
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
        }
    }
}