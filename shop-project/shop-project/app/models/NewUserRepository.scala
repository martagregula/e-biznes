package models

import com.mohiva.play.silhouette.api.LoginInfo
import com.mohiva.play.silhouette.api.services.IdentityService
import com.mohiva.play.silhouette.api.util.PasswordInfo
import javax.inject.{Inject, Singleton}
import models.NewUser
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}
import scala.reflect.ClassTag

@Singleton
class NewUserRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext, implicit val classTag: ClassTag[PasswordInfo]) extends IdentityService[NewUser] {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  case class NewUserDto(id: Long, providerId: String, providerKey: String, email: String)

  class NewUserTable(tag: Tag) extends Table[NewUserDto](tag, "newUser") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def providerId = column[String]("providerId")

    def providerKey = column[String]("providerKey")

    def email = column[String]("email")

    def * = (id, providerId, providerKey, email) <> ((NewUserDto.apply _).tupled, NewUserDto.unapply)
  }

  val newUser = TableQuery[NewUserTable]

  override def retrieve(loginInfo: LoginInfo): Future[Option[NewUser]] = db.run {
    newUser.filter(_.providerId === loginInfo.providerID)
      .filter(_.providerKey === loginInfo.providerKey)
      .result
      .headOption
  }.map(_.map(dto => toModel(dto)))

  def create(providerId: String, providerKey: String, email: String): Future[NewUser] = db.run {
    (newUser.map(c => (c.providerId, c.providerKey, c.email))
      returning newUser.map(_.id)
      into { case ((providerId, providerKey, email), id) => NewUserDto(id, providerId, providerKey, email) }
      ) += (providerId, providerKey, email)
  }.map(dto => toModel(dto))

  def getAll: Future[Seq[NewUser]] = db.run {
    newUser.result
  }.map(_.map(dto => toModel(dto)))

  def getByIdOption(id: Long): Future[Option[NewUser]] = db.run {
    newUser.filter(_.id === id).result.headOption
  }.map(_.map(dto => toModel(dto)))

  def getById(id: Long): Future[NewUser] = db.run {
    newUser.filter(_.id === id).result.head
  }.map(dto => toModel(dto))

  def update(id: Long, newNewUser: NewUser): Future[NewUser] = {
    val newUserToUpdate = newNewUser.copy(id)
    db.run {
      newUser.filter(_.id === id)
        .update(toDto(newUserToUpdate))
        .map(_ => newUserToUpdate)
    }
  }

  def delete(id: Long): Future[Unit] =
    db.run {
      newUser.filter(_.id === id)
        .delete
        .map(_ => ())
    }

  private def toModel(dto: NewUserDto): NewUser =
    NewUser(dto.id, LoginInfo(dto.providerId, dto.providerKey), dto.email)

  private def toDto(model: NewUser): NewUserDto =
    NewUserDto(model.id, model.loginInfo.providerID, model.loginInfo.providerKey, model.email)
}