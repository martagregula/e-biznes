package controllers

import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class OrderController @Inject()(cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def addOrder(): Action[AnyContent] = Action {
    NoContent
  }

  def getOrders: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def getOrder(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deleteOrder(id: Long): Action[AnyContent] = Action {
    NoContent
  }

  def updateOrder(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    Future {
      Ok("")
    }
  }
}