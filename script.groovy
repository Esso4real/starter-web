/* def buildJar() {
  
} */

def buildImage() {
  echo "Building Docker Image"
  withCredentials([usernamePassword(credentialsId: 'hub-docker', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
      sh "docker build -t esso4real/myhtmlapp:Tek-Experts-1.1 ."
      sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
      sh "docker push esso4real/myhtmlapp:Tek-Experts-1.1"
    }
}

def deployApp() {
def dockerCmd = "docker push esso4real/myhtmlapp:Tek-Experts-1.0"
    sshagent(['ec2-jenkins-ssh']) {
    sh "ssh -o StrictHostKeyChecking=no ec2-user@54.211.242.205 ${dockerCmd}"
    }
}

return this
