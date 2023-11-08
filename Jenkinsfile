pipeline {
    agent { docker { image 'maven:3.9.5' } }
    tools {
        maven "maven-3.9.5"
    }
    stages {
        stage("Build"){
            steps {
                sh "cd web-server/sushifactory-webserver/sushifactory-webserver; mvn -B -DskipTests clean package"
            }
            
        }
    }


    post {
        always {
            cleanWs()
        }
    }





}