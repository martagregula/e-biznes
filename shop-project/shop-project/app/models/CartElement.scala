package models
import play.api.libs.json.Json


case class CartElement(id: Long, cardId: Long, productId: Long, quantity: Int)

object CartElement {
  implicit val cartElementFormat = Json.format[CartElement]
}