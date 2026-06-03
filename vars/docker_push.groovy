def call(String Project,String ImageTag,String dockerhubuser){
   echo "This is Pusing the image to Docker Hub"
   withCredentials([usernamePassword('credentialsId':"dockerHubCred",passwordVariable:"dockerHubPass",usernameVariable:"dockerHubUser")]){
                sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
}
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
