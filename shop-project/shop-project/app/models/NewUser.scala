package models

import com.mohiva.play.silhouette.api.{Identity, LoginInfo}
import play.api.libs.json.{Json, OFormat}

case class NewUser(id: Long, loginInfo: LoginInfo, email: String) extends Identity

object NewUser {
  implicit val loginInfoFormat: OFormat[LoginInfo] = Json.format[LoginInfo]
  implicit val userFormat: OFormat[NewUser] = Json.format[NewUser]
}