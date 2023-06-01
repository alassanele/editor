pipeline {
    //def WORKSPACE = "/var/lib/jenkins/workspace/project_git_maven_docker"

    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub')
    }
    stages{
        stage('Clone Repo') {
             steps{
                // for display purposes
                // Get some code from a GitHub repository
                git branch: 'feat/test_dockerhub', url: 'https://github.com/alassanele/editor.git'

             }
        }
        stage('Build docker') {
            steps{
                sh 'docker build -t azonelka/editor:latest .'
            }
        }
        /*
        stage('Login') {
             steps {
               sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
             }
        }
        stage('Push') {
             steps {
               sh 'docker push azonelka/editor:latest'
             }
        }*/
        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: "dockerhub", url: "https://index.docker.io/v1/"]) {
                    sh "docker push azonelka/editor:latest"
                }
            }
        }
        /*
        stage('Deploy Artifacts to Production') {
            steps {
                sh "kubectl apply -f deployment.yaml\""
                sh "kubectl apply -f service.yaml\""
            }
       }*/
    }
}
