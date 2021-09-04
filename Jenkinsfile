def gv

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
        stage ('Groovy init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
         stage('Build Docker Image') {
            steps {
                script {
                    gv.buildImage()
                    }
                }
            }
        }
         stage('Deploy App') {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
