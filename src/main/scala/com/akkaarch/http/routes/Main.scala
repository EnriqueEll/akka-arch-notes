package com.akkaarch.http.routes

import akka.http.scaladsl.server.Directives

case class Main() extends Directives{
  val routes = {
    get {
      path(""){
        getFromResource("web/index.html")
      }
    }
  }
}