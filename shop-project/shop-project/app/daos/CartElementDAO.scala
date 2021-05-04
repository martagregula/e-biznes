package daos

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import models.CartElement
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class CartElementDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._
  import dbConfig._

  class CartElementTable(tag: Tag) extends Table[CartElement](tag, "CARTELEMENT") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def cardId = column[Long]("CARD_ID")
    def productId = column[Long]("PRODUCT_ID")
    def quantity = column[Int]("QUANTITY")
    def * = (id, cardId, productId, quantity) <> ((CartElement.apply _).tupled, CartElement.unapply)
  }

  private val CartElements = TableQuery[CartElementTable]

  def all(): Future[Seq[CartElement]] = db.run(CartElements.result)

  def delete(id: Long): Future[Unit] = db.run(CartElements.filter(_.id === id).delete).map(_ => ())

  def getById(id: Long): Future[CartElement] = db.run{
    CartElements.filter(_.id === id).result.head
  }

  def update(id: Long, cartElement: CartElement): Future[Unit] = db.run(CartElements.filter(_.id === id).update(cartElement)).map(_ => ())

  def insert(cartElement: CartElement): Future[Unit] = db.run(CartElements += cartElement).map(_ => ())
}