node {
    def WORKSPACE = "/var/lib/jenkins/workspace/project_git_maven_docker"
    def dockerImageTag = "springboot-deploy${env.BUILD_NUMBER}"

try{
     notifyBuild('STARTED')
     stage('Clone Repo') {
        // for display purposes
        // Get some code from a GitHub repository
        git url: 'https://github.com/alassanele/editor.git '
            branch: 'master'
     }
      stage('Build docker') {
             dockerImage = docker.build("springboot-deploy:${env.BUILD_NUMBER}")
      }

      stage('Deploy docker'){
              echo "Docker Image Tag Name: ${dockerImageTag}"
              sh "docker stop springboot-deploy || true && docker rm springboot-deploy || true"
              sh "docker run --name springboot-deploy -d -p 8081:8081 springboot-deploy:${env.BUILD_NUMBER}"
      }
}catch(e){
    currentBuild.result = "FAILED"
    throw e
}finally{
    notifyBuild(currentBuild.result)
 }
}

}
