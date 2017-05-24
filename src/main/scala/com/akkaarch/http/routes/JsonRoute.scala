package com.akkaarch.http.routes
import akka.http.scaladsl.server.Directives
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._

final case class Product(id: Int, name: String)
final case class Order(product: List[Product])

object OrderDB {
  var list: List[Order] = List()
  
  def add(order: Order) = {
    list = order :: list
  }
}

case class JsonRoute() extends Directives with SprayJsonSupport with DefaultJsonProtocol {

  implicit val productJSON = jsonFormat2(Product) //2 because Constructor class has 2 arguments
  implicit val orderJSON = jsonFormat1(Order) //1 because Constructor class has 1 arguments

  val routes = {
    get {
      path("order" / IntNumber) { //This is really awesome
        int => //get Param
        complete(Order(List(Product(int, "Glasses Oculos"), Product(int+2, "Nice Hat"))))
      }
    } ~
    post{
      path("order-create") {// {"product":[{"id":123423413,"name":"Glasses Oculos"},{"id":123423415,"name":"Nice Hat"}]}
        entity(as[Order]) {
          order =>  OrderDB.add(order) //Yeah this is blocking and it is just a test
          complete("Order Add")
        }
      }
    }
  }
}