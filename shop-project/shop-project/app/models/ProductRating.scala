package models
import play.api.libs.json.Json


case class ProductRating(id: Long, productId: Long, itemScore: Double)

object ProductRating{
  implicit val productRatingFormat = Json.format[ProductRating]
}
