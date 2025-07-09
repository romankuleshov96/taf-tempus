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
                sh """
                    curl -X POST https://slack.com/api/chat.postMessage \\
                    -H "Authorization: Bearer ${SLACK_TOKEN}" \\
                    -H "Content-type: application/json" \\
                    --data '{
                      "channel": "${SLACK_USER_ID}",
                      "text": "✅ Jenkins: Сборка ${BUILD_URL} завершена со статусом: ${currentBuild.currentResult}"
                    }'
                """
                junit 'target/surefire-reports/*.xml'
                archiveArtifacts artifacts: 'target/**', allowEmptyArchive: true
            }
        }
}