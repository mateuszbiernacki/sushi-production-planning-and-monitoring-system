pipeline {
    agent any
    tools {
        maven "Maven 3.9.5"
    }
    stages {
        stage("Build"){
            steps {
                sh "cd web-server/sushifactory-webserver/sushifactory-webserver"
                sh "mvn -version"
                sh "mvn clean install"
            }
            
        }
    }


    post {
        always {
            cleanWs()
        }
    }





}