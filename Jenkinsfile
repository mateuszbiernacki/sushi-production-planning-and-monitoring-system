pipeline {
    agent {label "ubuntu"}
    // tools {
    //     maven "maven-3.9.5"
    //     jdk "21"
    // }
    stages {
        stage("Build maven"){
            steps {
                sh 'whoami'
                sh 'ps -p $$'
                sh 'java --version'
                // sh 'export JAVA_HOME=$(/usr/bin)'
                sh "cd web-server/sushifactory-webserver/sushifactory-webserver; mvn -B -DskipTests clean package"
                stash includes: 'web-server/**/target/*.jar', name: 'jarfile'
            }
            
        }
        stage("Build webserver dockerfile"){
            steps {
                unstash 'jarfile'
                sh 'whoami'
                sh 'docker --version'
                sh 'ls -al web-server/sushifactory-webserver/sushifactory-webserver/target'
                sh '''
                    docker ps
                    cd web-server/sushifactory-webserver/sushifactory-webserver/
                    docker build -t fratris/sushi-webserver:test-release .
                    docker push fratris/sushi-webserver:test-release
                '''
            }
        }

        stage("Build parser dockerfile"){
            steps {
                sh 'whoami'
                sh 'ps -p $$'
                sh 'docker --version'
                sh '''
                    docker ps
                    cd parser
                    docker build -t fratris/sushi-parser:test-release .
                    docker push fratris/sushi-parser:test-release
                '''
            }
        }

        stage("Build frontend dockerfile"){
            steps {
                sh 'whoami'
                sh 'ps -p $$'
                sh 'docker --version'
                sh '''
                    docker ps
                    cd frontend
                    docker build -t fratris/sushi-frontend:test-release .
                    docker push fratris/sushi-frontend:test-release
                '''
            }
        }

        stage("Deploy k8s"){
            steps {
                sh 'whoami'
                sh 'ps -p $$'
                sh 'docker --version'
                sh 'kubectl get nodes'
            }
        }
    }


    post {
        always {
            cleanWs()
        }
    }





}
