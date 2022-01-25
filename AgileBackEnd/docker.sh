#!/bin/bash
#maven打包
mvn clean package
echo 'package ok!'
echo 'build start!'
cd ./AgileBackEnd
service_name='AgileBackEnd'
service_port=8888
#查看镜像id
IID=$(docker images | grep "$service_name" | awk '{print $3}')
echo "IID $IID"
if [ -n "$IID" ]
then
  echo "exist $service_name image,IID=$IID"
  #删除镜像
  docker rmi -f $service_name
  echo "delete $service_name image"
  #构建
  docker build -t $service_name .
  echo "build $service_name image"
else
  echo "no exist $service_name image,build docker"
  #构建
  docker build -t $service_name .
  echo "build $service_name image"
fi
#查看容器id
CID=$(docker ps | grep "$service_name" | awk '{print $1}')
echo "CID $CID"
if [ -n "$CID" ]
then
  echo "exist $service_name container,CID=$CID"
  #停止
  docker stop $service_name
  #删除容器
  docker rm $service_name
else
  echo "no exist $service_name container"
fi
#启动
docker run -d --name $service_name --net=host -p $service_port:$service_port $service_name
#查看启动日志
#docker logs -f $service_name
