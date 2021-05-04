package daos

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import models.Cart
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class CartDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._
  import dbConfig._

  class CartTable(tag: Tag) extends Table[Cart](tag, "CART") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def userId = column[Long]("USER_ID")
    def * = (id, userId) <> ((Cart.apply _).tupled, Cart.unapply)
  }

  private val Carts = TableQuery[CartTable]

  def all(): Future[Seq[Cart]] = db.run(Carts.result)

  def delete(id: Long): Future[Unit] = db.run(Carts.filter(_.id === id).delete).map(_ => ())

  def getById(id: Long): Future[Cart] = db.run{
    Carts.filter(_.id === id).result.head
  }

  def update(id: Long, cart: Cart): Future[Unit] = db.run(Carts.filter(_.id === id).update(cart)).map(_ => ())

  def insert(cart: Cart): Future[Unit] = db.run(Carts += cart).map(_ => ())
}