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
        }
        
  */
      
         stage('Build Docker Image') {
            steps {
                script {
                    echo "Building Docker Image"
                    withCredentials([usernamePassword(credentialsId: 'hub-docker', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
                        sh "docker build -t esso4real/myhtmlapp:Tek-Experts-1.3 ."
                        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                        sh "docker push esso4real/myhtmlapp:Tek-Experts-1.3"
                            }
                        }
                    }
                }
        
         stage('Deploy App') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'hub-docker', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
                        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                    def dockerCmd = "docker push esso4real/myhtmlapp:Tek-Experts-1.0"
                        sshagent(['ec2-jenkins-ssh']) {
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@54.211.242.205 ${dockerCmd}"
                        }
                    }
                }
            }
        }
    }
}
