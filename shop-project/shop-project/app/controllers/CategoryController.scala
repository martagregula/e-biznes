package controllers

import play.api.mvc._

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class CategoryController @Inject()(cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {


  def addCategory(): Action[AnyContent] = Action {
    NoContent
  }

  def getCategories: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def getCategory(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deleteCategory(id: Long): Action[AnyContent] = Action {
    NoContent
  }

  def updateCategory(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    Future {
      Ok("")
    }
  }
}