# springbootDocker

**springboot+thymeleaf+bootstrap+docker demo for window10**

**已安装的环境：window10,jdk8,docker(window版)**

## 在window 10 下docker 部署 springboot 项目

### 1、springboot 官网生成springboot project
   
   https://start.spring.io/
   
### 2、springboot+bootstrap+thymeleaf集成
   
#### 2.1 springboot+thymeleaf集成
      
##### a、在pom.xml 添加thymeleaf引用
```
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
##### b、在application.properties添加配置
```
   spring.thymeleaf.cache=false
   spring.thymeleaf.prefix=classpath:/html/
   spring.thymeleaf.check-template-location=true
   spring.thymeleaf.suffix=.html
   spring.thymeleaf.encoding=UTF-8
   spring.thymeleaf.mode=HTML5
```
##### c、在resources目录下new html目录和 health.xml

##### d、new CheckHealthController.java 
```
   @Controller
   public class CheckHealthController {

       @RequestMapping(value = "/health")
       public String health()
       {
           return "health/health";
       }

   }
```
#### 2.2 springboot+bootstrap集成

##### a、在resources目录下new static 目录和static下lib目录

##### b、在lib目录下分别new css、js、image目录

##### c、把boostrap的css、js分别放到css、js目录
```
   bootstrap.min.css
   bootstrap-table.min.css

   bootstrap.min.js
   bootstrap-table.min.js
   bootstrap-table-zh-CN.min.js
   jquery-2.1.1.min.js
```
#### d、在application.properties添加static resource
```
   spring.resources.static-locations=classpath:/static/
```

#### e、编写health.xml
```
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" >
<html lang="en">
   <head>
       <meta content="text/html;charset=UTF-8"/>
       <meta name="viewport" content="width=device-width,initial-scale=1"/>
       <link href="/lib/css/bootstrap.min.css" rel="stylesheet" />
       <link href="/lib/css/bootstrap-table.min.css" rel="stylesheet">
       <title>demo</title>
   </head>
   <body>
      <br/>
      <div class="panel panel-primary">
          <div class="panel-heading">
              <h3 class="panel-title">check health</h3>
          </div>
          <div class="panel-body">
              <div style="padding: 100px 100px 10px;">
                  <form class="bs-example bs-example-form" role="form">
                          <img src="/lib/images/health.png"/>
                      <br>
                  </form>
              </div>
          </div>

      </div>
      <!--使用bootstrap插件必须使用引入jquery,因为bootstrap是基于jquery开发的-->
      <script src="/lib/js/jquery-2.1.1.min.js"></script>
      <!--bootstrap插件-->
      <script src="/lib/js/bootstrap.min.js"></script>
      <script src="/lib/js/bootstrap-table.min.js"></script>
      <script src="/lib/js/bootstrap-table-zh-CN.min.js"></script>
      <script th:inline="javascript">

      </script>
   </body>
  </html>
```
#### 2.3 启动springboot,DemoApplication.java run

#### 2.4 浏览器输入地址：127.0.0.1：8080/health
     出现health.html的内容就说明springboot+bootstrap+thymeleaf集成成功
     

### 3、springboot+docker集成
#### 3.1在pom.xml中的<properties></properties> add docker image的前缀
```
   <properties>
		<java.version>1.8</java.version>
		<!--properties 节点中设置docker 镜像的前缀 "springboot" -->
		<docker.image.prefix>springboot</docker.image.prefix>
	</properties>
```
#### 3.1在pom.xml中的<plugins></plugins> add plugin
```
     <plugin>
         <groupId>com.spotify</groupId>
         <artifactId>docker-maven-plugin</artifactId>
         <version>0.4.13</version>
         <configuration>
            <imageName>${docker.image.prefix}/${project.artifactId}</imageName>
                 <dockerDirectory>src/main/docker</dockerDirectory>
            <resources>
               <resource>
                  <targetPath>/</targetPath>
                  <directory>${project.build.directory}</directory>
                  <include>${project.build.finalName}.jar</include>
               </resource>
            </resources>
         </configuration>
      </plugin>
```

#### 3.2 在目录 src/main/docker 下创建 Dockerfile 文件，Dockerfile 文件用来说明如何来构建镜像
```
   FROM openjdk:8-jdk-alpine
   VOLUME /tmp
   ADD demo-0.0.1-SNAPSHOT.jar app.jar
   ENTRYPOINT ["java","-jar","/app.jar"]
```
### 4 start docker
![docker]()

### 5 mvn package springboot projecet
####  5.1 打开cmd 到项目目录下 mvn package
####  5.2 部署上docker
    mvn package docker:build
####  5.3 查看docker images
    docker images
####  5.4 运行镜像
    docker run -p 8080:8080 -t -i springboot/demo   
####  5.4 查看启动的docker
    docker ps
#### 5.5 查看结果在
     浏览器输入：http://127.0.0.1:8080/health
