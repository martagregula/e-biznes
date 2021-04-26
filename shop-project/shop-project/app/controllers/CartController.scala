package controllers

import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class CartController @Inject()(cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def addCart(): Action[AnyContent] = Action {
    NoContent
  }

  def getCart(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deleteCart(id: Long): Action[AnyContent] = Action {
    NoContent
  }

  def updateCart(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    Future {
      Ok("")
    }
  }
}