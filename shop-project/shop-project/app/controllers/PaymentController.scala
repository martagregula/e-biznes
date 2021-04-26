package controllers

import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class PaymentController @Inject()(cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def addPayment(): Action[AnyContent] = Action {
    NoContent
  }

  def getPayments: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def getPayment(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deletePayment(id: Long): Action[AnyContent] = Action {
    NoContent
  }

  def updatePayment(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    Future {
      Ok("")
    }
  }
}