pipeline {

    agent any
    tools {
            maven 'maven_3_9_3'
        }
    stages {
        stage ('Build'){
            steps {
                git url: 'https://github.com/SudhaRao/spingmvc.git'
                withMaven(maven: 'maven_3_9_3') {
                    sh 'mvn clean package'
                }
            }
        }
        stage ('Test'){
            steps {
                withMaven(maven: 'maven_3_9_3' {
                    sh 'mvn test'
                }
            }
        }
        stage ('Deploy')(maven: 'maven_3_9_3'{
            steps {
                withMaven {
                    sh 'mvn deploy'
                }
            }
        }
    }
}