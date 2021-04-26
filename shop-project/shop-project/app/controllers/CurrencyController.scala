package controllers

import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class CurrencyController @Inject()(cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def addCurrency(): Action[AnyContent] = Action {
    NoContent
  }

  def getCurrencies: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def getCurrency(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deleteCurrency(id: Long): Action[AnyContent] = Action {
    NoContent
  }

  def updateCurrency(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    Future {
      Ok("")
    }
  }
}