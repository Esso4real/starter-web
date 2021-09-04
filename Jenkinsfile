pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    echo "Building Docker Image...."
                    withCredentials([usernamePassword(credentialsId: 'hub-docker', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){
                        sh 'docker build -t esso4real/myhtmlapp:v3.0 .'
                        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                        sh 'docker push esso4real/myhtmlapp:v2.0'
                    }

            }
        }
      stage('Test') {
            steps {
                echo 'Testing the app'
            }
        }
      stage('Deploy') {
            steps {
                echo 'Deploying the app'
            }
        }
    }
}
