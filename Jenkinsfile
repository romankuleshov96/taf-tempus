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
                    -H "Authorization: Bearer xoxb-8485856722691-9157535580039-5nDYWbp35U7fdIS0tfjXQyPh" \\
                    -H "Content-type: application/json" \\
                    --data '{
                      "channel": "U08E82WPX7F",
                      "text": "✅ Jenkins: Сборка ${BUILD_URL} завершена со статусом: ${currentBuild.currentResult}"
                    }'
                """
                junit 'target/surefire-reports/*.xml'
                archiveArtifacts artifacts: 'target/**', allowEmptyArchive: true
            }
        }
}