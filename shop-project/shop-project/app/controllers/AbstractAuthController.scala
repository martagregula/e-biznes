package controllers

import com.mohiva.play.silhouette.api.services.AuthenticatorResult
import models.NewUser
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

abstract class AbstractAuthController(scc: DefaultSilhouetteControllerComponents)(implicit ex: ExecutionContext) extends SilhouetteController(scc) {

  protected def authenticateUser(newUser: NewUser)(implicit request: RequestHeader): Future[AuthenticatorResult] = {
    authenticatorService.create(newUser.loginInfo)
      .flatMap { authenticator =>
        authenticatorService.init(authenticator).flatMap { v =>
          authenticatorService.embed(v, Ok("Authenticated"))
        }
      }
  }
}