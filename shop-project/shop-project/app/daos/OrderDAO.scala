package daos

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import models.Order
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class OrderDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  class OrderTable(tag: Tag) extends Table[Order](tag, "ORDER") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def cartId = column[Long]("CART_ID")
    def * = (id, cartId) <> ((Order.apply _).tupled, Order.unapply)
  }

  private val Orders = TableQuery[OrderTable]

  def all(): Future[Seq[Order]] = db.run(Orders.result)

  def delete(id: Long): Future[Unit] = db.run(Orders.filter(_.id ===id).delete).map(_ => ())

  def getById(id: Long): Future[Order] = db.run{
    Orders.filter(_.id===id).result.head
  }

  def update(id: Long, order: Order): Future[Unit] = db.run(Orders.filter(_.id === id).update(order)).map(_ => ())

  def insert(order: Order): Future[Unit] = db.run(Orders += order).map(_ => ())
}