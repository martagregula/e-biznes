package controllers

import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class CartElementController @Inject()(cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def addCartElement(): Action[AnyContent] = Action {
    NoContent
  }

  def getCartElement: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def getCartElement(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deleteCartElement(id: Long): Action[AnyContent] = Action {
    NoContent
  }

  def updateCartElement(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    Future {
      Ok("")
    }
  }
}