package daos

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import models.Payment
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class PaymentDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  class PaymentTable(tag: Tag) extends Table[Payment](tag, "PAYMENT") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def orderId = column[Long]("ORDER_ID")
    def isPayed = column[Boolean]("IS_PAYED")
    def amount = column[Double]("AMOUNT")
    def * = (id, orderId, isPayed, amount) <> ((Payment.apply _).tupled, Payment.unapply)
  }

  private val Payments = TableQuery[PaymentTable]

  def all(): Future[Seq[Payment]] = db.run(Payments.result)

  def delete(id: Long): Future[Unit] = db.run(Payments.filter(_.id === id).delete).map(_ => ())

  def getById(id: Long): Future[Payment] = db.run{
    Payments.filter(_.id === id).result.head
  }

  def update(id: Long, payment: Payment): Future[Unit] = db.run(Payments.filter(_.id === id).update(payment)).map(_ => ())

  def insert(payment: Payment): Future[Unit] = db.run(Payments += payment).map(_ => ())
}