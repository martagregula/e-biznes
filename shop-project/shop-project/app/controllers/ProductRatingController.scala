package controllers

import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ProductRatingController @Inject()(cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def addProductRating(id: Long, rating: Long): Action[AnyContent] = Action {
    NoContent
  }

  def getProductRating(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deleteProductRating(id: Long): Action[AnyContent] = Action {
    NoContent
  }

  def updateProductRating(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    Future {
      Ok("")
    }
  }

}