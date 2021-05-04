package models
import play.api.libs.json.Json


case class Cart(id: Long, userId: Long)

object Cart {
  implicit val cartFormat = Json.format[Cart]
}