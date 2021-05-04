package models
import play.api.libs.json.Json


case class Currency(id: Long, price: Double)

object Currency {
  implicit val userFormat = Json.format[Currency]
}