pipeline {
    agent none
    tools {
        maven "maven-3.9.5"
        jdk "21"
    }
    stages {
        stage("Maven"){
            agent { 
                label 'docker-slave'
            }
            stages{
                stage("Build jar file"){
                    steps {
                        sh 'whoami'
                        sh 'java --version'
                        sh "cd web-server/sushifactory-webserver/sushifactory-webserver; mvn -B -DskipTests clean package"
                    }
                }
            }
            
            
        }
        stage("Build dockerfile"){
            agent { 
                label 'docker-slave'
            }
            steps {
                sh 'ls -al ./web-server/sushifactory-webserver/sushifactory-webserver/target/'
            }
        }
    }


    post {
        always {
            cleanWs()
        }
    }





}
