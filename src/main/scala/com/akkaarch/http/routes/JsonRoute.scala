package com.akkaarch.http.routes
import akka.http.scaladsl.server.Directives
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport

import spray.json._

final case class Product(id: Int, name: String)
final case class Order(product: List[Product])

case class JsonRoute() extends Directives with SprayJsonSupport with DefaultJsonProtocol {

  implicit val productJSON = jsonFormat2(Product) //2 because Constructor class has 2 arguments
  implicit val orderJSON = jsonFormat1(Order) //1 because Constructor class has 1 arguments

  val routes = {
    get {
      path("order") {//get Param
        complete(Order(List(Product(1, "Glasses Oculos"), Product(2, "Nice Hat"))))
      }
    }
    // build a unmarshaller Post here
  }
}