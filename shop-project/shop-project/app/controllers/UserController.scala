package controllers

import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserController @Inject()(cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def addUser(): Action[AnyContent] = Action {
    NoContent
  }

  def getUsers: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def getUser(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deleteUser(id: Long): Action[AnyContent] = Action {
    NoContent
  }

  def updateUser(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    Future {
      Ok("")
    }
  }
}