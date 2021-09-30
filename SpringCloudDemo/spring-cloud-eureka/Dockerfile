#docker build -t eureka:v1.0 -f Dockerfile .
#FROM：指定基础镜像，必须为第一个命令
FROM openjdk:8-jdk-slim
#MAINTAINER: 维护者信息
#LABEL：用于为镜像添加元数据
LABEL maintainer=liuwei
#ENV：设置环境变量
#RUN：构建镜像时执行的命令
#ADD：将本地文件添加到容器中，tar类型文件会自动解压(网络压缩资源不会被解压)，可以访问网络资源，类似wget
#COPY：功能类似ADD，但是是不会自动解压文件，也不能访问网络资源
COPY target/*.jar /opt/eureka.jar
#CMD：构建容器后调用，也就是在容器启动时才进行调用。
#ENTRYPOINT：配置容器，使其可执行化。配合CMD可省去"application"，只使用参数。
ENTRYPOINT ["java","-jar","/opt/eureka.jar"]