pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/IvanGit25/AutomationFramework26'

                // Run the build on a Unix agent. You must have Maven installed.
                bat 'mvn -Dmaven.test.failure.ignore=true clean package'

                // To run Maven on a Windows agent, use
                // bat 'mvn -Dmaven.test.failure.ignore=true clean package'
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, icon: '', keepAll: false, reportDir: 'target/surefire-reports', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: '', useWrapperFileDirectly: true])
                    testNG()
                }
            }
        }
    }
}