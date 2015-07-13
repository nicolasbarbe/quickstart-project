eval $(boot2docker shellinit)
docker build  -t nicolasbarbe/quickstart-project .
docker push nicolasbarbe/quickstart-project
