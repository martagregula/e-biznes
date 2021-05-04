package daos

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import models.User
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class UserDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._
  import dbConfig._

  class UserTable(tag: Tag) extends Table[User](tag, "USER") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def username = column[String]("USERNAME")
    def email = column[String]("EMAIL")
    def password = column[String]("PASSWORD")
    def * = (id, username, email, password) <> ((User.apply _).tupled, User.unapply)
  }

  private val Users = TableQuery[UserTable]

  def all(): Future[Seq[User]] = db.run(Users.result)

  def delete(id: Long): Future[Unit] = db.run(Users.filter(_.id === id).delete).map(_ => ())

  def getById(id: Long): Future[User] = db.run{
    Users.filter(_.id === id).result.head
  }

  def update(id: Long, user: User): Future[Unit] = db.run(Users.filter(_.id === id).update(user)).map(_ => ())

  def insert(user: User): Future[Unit] = db.run(Users += user).map(_ => ())
}