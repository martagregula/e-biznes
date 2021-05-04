package models
import play.api.libs.json.Json


case class Product(id: Long, name: String, price: Double, description: String)

object Product {
  implicit val productFormat = Json.format[Product]
}