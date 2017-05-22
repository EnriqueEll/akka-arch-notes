package com.akkaarch.http.routes

import scala.concurrent.ExecutionContextExecutor
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.HttpEntity
import akka.http.scaladsl.model.ContentTypes
import scala.concurrent.impl.Future
import scala.concurrent.Future

case class FileUploadRoute(implicit val executionContext: ExecutionContextExecutor) {

  def routes =
    extractRequestContext { ctx =>
      implicit val materializer = ctx.materializer
      fileUpload("txt") {

        case (metadata, byteSource) =>
          val buffer: Future[String] =
            byteSource.mapConcat(x => x.utf8String).
              map(_.toChar)
              .runFold("")((acc, c) => acc + c)

          onSuccess(buffer) {
            str => complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, str))
          }
      }
    } ~
      get {
        path("test") {
          complete(HttpEntity(ContentTypes.`text/xml(UTF-8)`, <h1>Say hello to akka-http</h1>.toString))
        }
      } ~
      get {
        path("ohh") {
          complete("Ohhhhh !!")
        }
      }
}