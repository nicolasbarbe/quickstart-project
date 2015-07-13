eval $(boot2docker shellinit)
docker build  -t nicolasbarbe/quickstart-project:ansible .
docker push nicolasbarbe/quickstart-project:ansible
