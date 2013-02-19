package main.scala.edu

class Store(userByName: Map[String, UserRecord], userProfiles: Map[Long, UserProfile]) {

  //java style
  def getUserByName(name: String) = {
    if (userByName.contains(name)) {
      userByName(name)
    } else {
      null
    }
  }

  //java style
  def getUserProfile(id: Long) = {
    if (userProfiles.contains(id)) {
      userProfiles(id)
    } else {
      null
    }
  }

  def retrieveUserInterests(name: String): List[String] = {
    var userInterests = List[String]()
    val userRecord = getUserByName(name)
    if (userRecord != null) {
      val profile = getUserProfile(userRecord.id)
      if (profile != null) {
        val interests = profile.interests
        if (interests != null) {
          userInterests = interests
        }
      }
    }
    userInterests
  }
}

case class UserRecord(id: Long, name: String, age: Int)
case class UserProfile(id: Long, interests: List[String])
