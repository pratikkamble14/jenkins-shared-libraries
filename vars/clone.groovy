def call(String url,String branch){
  echo "This is Clonning the code"
  git url:"${url}" ,branch:"${branch}"
  echo "This is clone code successfull"
}
