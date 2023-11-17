pipeline {
    agent { 
        any { image 'docker-slave' } 
    }
    tools {
        maven "maven-3.9.5"
    }
    stages {
        stage("Build"){
            steps {
                sh 'java --version'
                sh '''
                    apt install wget -y
                    wget https://download.java.net/java/early_access/jdk21/28/GPL/openjdk-21-ea+xx_linux-aarch64_bin.tar.gz
                    wget https://download.java.net/java/early_access/jdk21/28/GPL/openjdk-21-ea+xx_linux-x64_bin.tar.gz
                    tar -xvf openjdk-21-ea+28_linux-x64_bin.tar.gz
                    cd jdk-21
                    mkdir -p /usr/local/jdk-21
                    mv * /usr/local/jdk-21
                    export JAVA_HOME=/usr/local/jdk-21
                    export PATH=$JAVA_HOME/bin:$PATH
                    source ~/.bashrc
                    echo 'export JAVA_HOME=/usr/local/jdk-21' >> ~/.bashrc
                    echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.bashrc
                    source ~/.bashrc
                    java --version
                    echo $JAVA_HOME
                '''
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
