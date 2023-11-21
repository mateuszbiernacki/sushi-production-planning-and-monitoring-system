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
                stash includes: 'web-server/**/target/*.jar', name: 'jarfile'
            }
            
        }
        stage("Build dockerfile"){
            agent {label "master"}
            steps {
                unstash 'jarfile'
                sh 'whoami'
                sh 'docker --version'
                sh 'ls -al web-server/sushifactory-webserver/sushifactory-webserver/target'
                sh '''
                    cd web-server/sushifactory-webserver/sushifactory-webserver/
                    cat Dockerfile
                '''
            }
        }
    }


    post {
        always {
            cleanWs()
        }
    }





}
