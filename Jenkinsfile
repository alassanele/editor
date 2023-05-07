pipeline {
    //def WORKSPACE = "/var/lib/jenkins/workspace/project_git_maven_docker"

    agent {label, 'linux'}

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub')
    }
    stages{
        stage('Clone Repo') {
             steps{
                // for display purposes
                // Get some code from a GitHub repository
                git url: 'https://github.com/alassanele/editor.git' branch: 'feat/test_dockerhub'
             }
        }
        stage('Build docker') {
            steps{
                 dockerImage = docker.build("editor:latest")
            }
        }
        stage('Login') {
             steps {
               sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
             }
        }
        stage('Push') {
             steps {
               sh "docker push editor:latest"
             }
        }
    }
}
