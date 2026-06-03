def call(String ProjectName,String ImageTag,String DockerHubUser){
   echo "This is Building Stage"
  sh "docker build -t ${DockerHubUser}/${ProjectName}:${ImageTag} ."
}
