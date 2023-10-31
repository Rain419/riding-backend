echo "start building"
cd ride-hailing-main
cd ride-hailing-main
ls
pwd


export MY_IP=$(hostname -I | awk '{print $1}')
echo "MY_IP=$(hostname -I | awk '{print $1}')"
# Create a .env file and set the MY_IP environment variable
echo "MY_IP=$MY_IP" > .env

sudo docker-compose down

if [ $? -eq 0 ]; then
    # 获取所有 Docker 镜像的 ID
    image_ids=$(docker images -q)

    # 循环遍历并删除每个镜像
    for id in $image_ids; do
      docker rmi -f $id
    done
else
  echo "Failed to delete images"
fi


mvn clean package -Dmaven.test.skip=true

if [ $? -eq 0 ]; then
  sudo nohup docker-compose up > /logs/custom.log &
  sleep 30  # 等待 30 秒
else
  echo "Failed to stop services with 'docker-compose down'"
fi


echo "end building"
