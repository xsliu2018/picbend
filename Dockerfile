###指定java8环境镜像
FROM java:8

WORKDIR /usr/local/picbend

### 复制 jar (docker-springboot-0.0.1.jar) 到容器中并命名为 app-springboot.jar
ADD picbend-0.0.1.jar picbend-0.0.1.jar
ADD pic_bend.setting pic_bend.setting



###声明启动端口号
EXPOSE 9999

###配置容器启动后执行的命令
ENTRYPOINT ["java","-jar","picbend-0.0.1.jar"]