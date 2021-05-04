package daos

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import models.Discount
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class DiscountDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._
  import dbConfig._

  class DiscountTable(tag: Tag) extends Table[Discount](tag, "DISCOUNT") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def productId = column[Integer]("PRODUCT_ID")
    def amount = column[Double]("AMOUNT")
    def * = (id, productId, amount) <> ((Discount.apply _).tupled, Discount.unapply)
  }

  private val Discounts = TableQuery[DiscountTable]

  def all(): Future[Seq[Discount]] = db.run(Discounts.result)

  def delete(id: Long): Future[Unit] = db.run(Discounts.filter(_.id === id).delete).map(_ => ())

  def getById(id: Long): Future[Discount] = db.run{
    Discounts.filter(_.id === id).result.head
  }

  def update(id: Long, discount: Discount): Future[Unit] = db.run(Discounts.filter(_.id === id).update(discount)).map(_ => ())

  def insert(discount: Discount): Future[Unit] = db.run(Discounts += discount).map(_ => ())
}