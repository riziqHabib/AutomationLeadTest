pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('pull code') {
            steps {
                git 'https://github.com/riziqHabib/AutomationLeadTest.git'

            }
        }
        stage('build code') {
            steps {
                sh 'mvn clean kotlin:compile compile install -DskipTests'
            }
        }
        stage('Run  Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }
    post {
        always {

            echo 'This will always run'
            sh 'cat target/surefire-reports/TestSuite.txt'
        }

        success {
            echo 'This Build run successfully'
        }
        failure {
            wrap([$class: 'BuildUser']) {
                emailext body: 'Check console output at $BUILD_URL',
                        to: "${BUILD_USER_EMAIL}",
                        subject: 'Build failed in Jenkins'
            }
        }
    }
}