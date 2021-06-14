package utils

import com.mohiva.play.silhouette.api.Env
import com.mohiva.play.silhouette.impl.authenticators.CookieAuthenticator
import models.NewUser

trait DefaultEnv extends Env {
  type I = NewUser
  type A = CookieAuthenticator
}