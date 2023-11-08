pipline {
    agent any

    stages {
        stage("Build"){
            sh "cd web-server/sushifactory-webserver/sushifactory-webserver"
            sh "mvn -version"
            sh "mvn clean install"
        }
    }


    post {
        always {
            cleanWs()
        }
    }





}