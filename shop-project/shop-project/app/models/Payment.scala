package models
import play.api.libs.json.Json


case class Payment(id: Long, orderId: Long, isPayed: Boolean, amount: Double)

object Payment{
  implicit val paymentFormat = Json.format[Payment]
}
