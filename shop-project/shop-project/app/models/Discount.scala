package models
import play.api.libs.json.Json


case class Discount(id: Long, productId: Long, amount: Double)

object Discount{
  implicit val discountFormat = Json.format[Discount]
}