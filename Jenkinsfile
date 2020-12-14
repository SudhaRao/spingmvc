pipeline {

    agent any
    tools {
            maven 'maven_4_0_0'
        }
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
                withMaven(maven : 'maven_4_0_0') {
                    sh 'mvn test'
                }
            }
        }
        stage ('Deploy'){
            steps {
                withMaven(maven : 'maven_4_0_0') {
                    sh 'mvn deploy'
                }
            }
        }
    }
}