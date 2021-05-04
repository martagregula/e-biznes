package daos

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import models.ProductRating
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class ProductRatingDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  class ProductRatingTable(tag: Tag) extends Table[ProductRating](tag, "PRODUCTRATING") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def productId = column[Long]("PRODUCT_ID")
    def itemScore = column[Double]("ITEM_SCORE")
    def * = (id, productId, itemScore) <> ((ProductRating.apply _).tupled, ProductRating.unapply)
  }

  private val ProductRatings = TableQuery[ProductRatingTable]

  def all(): Future[Seq[ProductRating]] = db.run(ProductRatings.result)

  def delete(id: Long): Future[Unit] = db.run(ProductRatings.filter(_.id ===id).delete).map(_ => ())

  def getById(id: Long): Future[ProductRating] = db.run{
    ProductRatings.filter(_.id === id).result.head
  }

  def update(id: Long, productRating: ProductRating): Future[Unit] = db.run(ProductRatings.filter(_.id === id).update(productRating)).map(_ => ())

  def insert(productRating: ProductRating): Future[Unit] = db.run(ProductRatings += productRating).map(_ => ())
}