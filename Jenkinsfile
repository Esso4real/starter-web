pipeline {
    agent any
    
 //  maven "maven"
    
    stages {
 /*   
        stage('Build jar file') {
            steps {
                script {
                    echo "Building jar file"
                    sh "mvn clean package"
                }
            }
        } */
         stage('Build Docker Image') {
            steps {
                script {
                    echo "Building Docker Image"
                    withCredentials([usernamePassword(credentialsId: 'hub-docker', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
                        sh "docker build -t esso4real/myhtmlapp:Tek-Experts-1.0 ."
                        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                        sh "docker push esso4real/myhtmlapp:Tek-Experts-1.0"
                    }
                }
            }
        }
         stage('Deploy App') {
            steps {
                script {
                    echo "Deploying App"
                }
            }
        }
    }
}
