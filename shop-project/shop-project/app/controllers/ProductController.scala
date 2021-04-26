package controllers

import play.api.data.Form
import play.api.data.Forms.{bigDecimal, longNumber, mapping, nonEmptyText, _}
import play.api.data.format.Formats._
import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

@Singleton
class ProductController @Inject()(cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def addProduct(): Action[AnyContent] = Action {
    NoContent
  }

  def getProducts: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def getProduct(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deleteProduct(id: Long): Action[AnyContent] = Action {
    NoContent
  }

  def updateProduct(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    Future {
      Ok("")
    }
  }

}