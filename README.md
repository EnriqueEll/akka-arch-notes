# akka-arch-notes
Initial idea of this project is to study Akka

# How to get start:
TBD

## Gradle
---Will be removed---

## Sbt
Run AkkaAch 

`sbt run`

### Dependecies
[Dependencies.scala](project/Dependencies.scala) - Contains all dependencies library.


## Packages 
Start with Akka HTTP and Akka Core.

#Main Server Class:
- com/akkaarch/http/WebSever.scala

#Static Content: 
- resources/web/ - Static content E.g: index.html
- Using the org.webjar core library we can retrieve the WebJar content 

#Routes:
- [com/akkaarch/http/routes/](src/main/scala/com/akkaarch/http/routes/)
  - [FileUploadRoute.scala](src/main/scala/com/akkaarch/http/routes/FileUploadRoute.scala) - FileUpload Route
  - [JsonRoute.scala](src/main/scala/com/akkaarch/http/routes/JsonRoute.scala) - Example of JSON Marshalling and Unmarshalling
  - [Main.scala](src/main/scala/com/akkaarch/http/routes/Main.scala) - Responsible for Generic Routes - like retrieve the Static Content and WebJars

   
