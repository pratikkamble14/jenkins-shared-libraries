def call(){
  echo "This is Deploying Stage"
  sh "docker compose down && docker compose up -d --build"
}
