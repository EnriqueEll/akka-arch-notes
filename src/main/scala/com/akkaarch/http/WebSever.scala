package com.primeduc.http

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.io.StdIn
import java.io.PrintWriter
import java.io.File
import akka.http.scaladsl.marshalling.ToResponseMarshallable.apply
import akka.http.scaladsl.server.Directive.addByNameNullaryApply
import akka.http.scaladsl.server.Directive.addDirectiveApply
import akka.http.scaladsl.server.RouteResult.route2HandlerFlow

object WebServer {
  def main(args: Array[String]) {

    implicit val system = ActorSystem("my-system")
    implicit val materializer = ActorMaterializer()

    implicit val executionContext = system.dispatcher

    val route =
      extractRequestContext { ctx =>
        implicit val materializer = ctx.materializer
        fileUpload("txt") {
          case (metadata, byteSource) =>
            val printFile = new PrintWriter(new File("text.txt"))
            byteSource.mapConcat(x => x).
              runForeach(x => printFile.write(x))
              .onComplete {
                case (done) =>
                  printFile.close()
              }
            //*
            complete(s"Sum: Test")
        }
      } ~
        get {
          path("test")
          complete(HttpEntity(ContentTypes.`text/xml(UTF-8)`, <h1>Say hello to akka-http</h1>.toString))
        }

    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}