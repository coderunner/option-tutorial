package main.scala.edu


trait Connection {
  def execute(query: String): AnyRef
}

trait ConnectionPool {
  def getConnection: Connection
}
