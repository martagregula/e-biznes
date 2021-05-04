package daos

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import models.Product
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class ProductDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  class ProductTable(tag: Tag) extends Table[Product](tag, "PRODUCT") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def name = column[String]("NAME")
    def price = column[Double]("PRICE")
    def description = column[String]("DESCRIPTION")
    def * = (id, name, price, description) <> ((Product.apply _).tupled, Product.unapply)
  }

  private val Products = TableQuery[ProductTable]

  def all(): Future[Seq[Product]] = db.run(Products.result)

  def delete(id: Long): Future[Unit] = db.run(Products.filter(_.id ===id).delete).map(_ => ())

  def getById(id: Long): Future[Product] = db.run{
    Products.filter(_.id===id).result.head
  }

  def update(id: Long, product: Product): Future[Unit] = db.run(Products.filter(_.id === id).update(product)).map(_ => ())

  def insert(product: Product): Future[Unit] = db.run(Products += product).map(_ => ())
}