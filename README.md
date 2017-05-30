# akka-arch-notes
Initial idea of this project is to study Akka

# Packages 
Start with Akka HTTP and Akka Core.

Static Content: 
- resources/web/ - Static content E.g: index.html
  - Checking how to work with WebJars and Others modern way to work with JavaScript Libraries

Main Server Class:
- com/akkaarch/http/WebSever.scala

Routes:
- com/akkaarch/http/routes/
  - FileUploadRoute.scala - FileUpload Route
  - JsonRoute.scala - Example of JSON Marshalling and Unmarshalling
  - Main.scala - Resposable for Generic Routes - like retrieve the Static Content

   
