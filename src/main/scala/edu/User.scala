package main.scala.edu

object User {

  def load(connectionPool: ConnectionPool,
           userStoreOps: UserStoreOperations,
           id: Long,
           transform: UserRecord => UserRecord): UserRecord = {
    val connection = connectionPool.getConnection
    val user = userStoreOps.getUserRecord(connection, id)
    transform(user)
  }
}

trait UserStoreOperations {
  def getUserRecord(connection: Connection, id: Long): UserRecord
}

class FakeUserStoreOperations(users: Map[Long, UserRecord]) extends UserStoreOperations{

  def getUserRecord(connection: Connection, id: Long): UserRecord = {
    connection.execute("boo")
    users(id)
  }
}

case class UserRecord(id: Long, name: String, age: Int)
