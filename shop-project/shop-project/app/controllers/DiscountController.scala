package controllers

import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class DiscountController @Inject()(cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def addDiscount(): Action[AnyContent] = Action {
    NoContent
  }

  def getDiscounts: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def getDiscount(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deleteDiscount(id: Long): Action[AnyContent] = Action {
    NoContent
  }

  def updateDiscount(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    Future {
      Ok("")
    }
  }
}