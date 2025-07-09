pipeline {
    agent any

    triggers {
        cron('H 10 * * 1-5')
    }

    tools {
        maven 'Maven 3.9'
        jdk 'jdk24.0.1'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Run tests') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/**', allowEmptyArchive: true
        }
    }
}