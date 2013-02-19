package test.scala.edu

import org.scalatest.FunSuite
import main.scala.edu.{Store, UserProfile, UserRecord}

class TestStore extends FunSuite {

  val userRecordMap = Map("joe" -> UserRecord(1, "joe", 33))
  val profileRecordMap = Map(1l -> UserProfile(1, List("Victoria Secret", "Fruit of the Loom")))
  val store = new Store(userRecordMap, profileRecordMap)

  test("should return user interests") {
    assert(2 === store.retrieveUserInterests("joe").size)
  }

  test("should return empty list for unknown user") {
    assert(store.retrieveUserInterests("bob").isEmpty)
  }

  test("should return empty list for missing profile") {
    val store = new Store(userRecordMap, Map())
    assert(store.retrieveUserInterests("joe").isEmpty)
  }
}
