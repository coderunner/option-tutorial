package test.scala.edu

import org.scalatest.FunSuite
import main.scala.edu._
import main.scala.edu.UserRecord

class TestUser extends FunSuite {
  val UserRecord = new UserRecord(12, "joe", 32)
  val MissingUserStoreOps = new FakeUserStoreOperations(Map())
  val AvailableUserStoreOps = new FakeUserStoreOperations(Map(12l -> UserRecord))

  test("fetch user record from store and uppercase its name") {

    def upperCaseName(userRecord: UserRecord): UserRecord = userRecord.copy(name = userRecord.name.toUpperCase)

    val user = User.load(FullConnectionPool, AvailableUserStoreOps, 12, upperCaseName)
    println(user.name)
  }
}

object TestConnection extends Connection {
  def execute(query: String) = {new Object}
}

object FullConnectionPool extends ConnectionPool {
  def getConnection = TestConnection
}

object EmptyConnectionPool extends ConnectionPool {
  def getConnection = null
}
