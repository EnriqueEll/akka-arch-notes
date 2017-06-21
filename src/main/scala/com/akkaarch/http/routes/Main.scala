package com.akkaarch.http.routes

import akka.http.scaladsl.server.Directives
import org.webjars.WebJarAssetLocator
import akka.http.scaladsl.server.PathMatcher

case class Main() extends Directives {
  val routes = {
    get {
      path("") {
        getFromResource("web/index.html")
      } ~
        path("webjar" / Remaining) {// webjar really simple
          path =>
            {
              var locator = new WebJarAssetLocator()
              var fullPathToBootstrap = locator.getFullPath(path)
              getFromResource(fullPathToBootstrap)
            }
        }
    }
  }
}