package controllers

import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class CartItemController @Inject()(cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def addCartItem(): Action[AnyContent] = Action {
    NoContent
  }

  def getCartItems: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def getCartItem(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deleteCartItem(id: Long): Action[AnyContent] = Action {
    NoContent
  }

  def updateCartItem(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    Future {
      Ok("")
    }
  }
}