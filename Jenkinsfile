pipeline {
    agent { 
        any { image 'docker-slave' } 
    }
    tools {
        maven "maven-3.9.5"
        jdk "21"
    }
    stages {
        stage("Build maven"){
            steps {
                sh 'whoami'
                sh 'java --version'
                sh "cd web-server/sushifactory-webserver/sushifactory-webserver; mvn -B -DskipTests clean package"
            }
            
        }
        stage("Build dockerfile"){
            agent {label "master"}
            steps {
                sh 'whoami'
                sh 'sudo docker --version'
            }
        }
    }


    post {
        always {
            cleanWs()
        }
    }





}
