pipeline {
    agent any

    environment {
        PATH_WORKSPACE = "${env.WORKSPACE}"
        PATH_REPORTS = "${env.WORKSPACE}/reports"
    }

    parameters {
        string(
            defaultValue: 'sofidinonno@gmail.com',
            description: 'Email to:',
            name: 'SEND_EMAIL_TO'
        )
        choice(
            name: 'TAG_TO_EXECUTE',
            choices:["@regression", "@ui", "@api", "@sampleApp", "@progressBar"],
            description: "Tags to execute"
        )
        string(
            defaultValue: 'develop',
            description: 'Branch:',
            name: 'BRANCH'
        )
    }

    stages{
        stage('Git') {
            steps {
                checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/${BRANCH}']],
                        extensions: [[$class: 'LocalBranch', localBranch: '${BRANCH}']],
                        url: 'https://github.com/sdinonno/spriteCloud-interview/'
                ])
            }
        }

        stage('Execution') {
            steps {
                catchError(buildResult: 'Success', stageResult: 'FAILURE'){
                    bat 'mvn clean test -Dcucumber.filter.tags=${TAG_TO_EXECUTE]'
                }
            }
        }
    }

    post {
        always {
            dir(PATH_REPORTS) {
                emailext body: "Please go to ${BUILD_URL} and verify the build." ,
                    subject: "Pipeline '${JOB_NAME}' (${BUILD_NUMBER})",
                    to: '${SEND_EMAIL_TO}',
                    attachmentsPattern: "report.html"
            }

            cleanWs()
        }
    }
}