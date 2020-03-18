package ru.skillbranch.devintensive.models


import ru.skillbranch.devintensive.utils.Utils.transliteration

data class Profile(
  // val nickName: String,
   // val rank: String= "Junior Android Developer",
    val firstName: String,
    val lastName: String,
    val about: String,
    val repository: String,
    val rating: Int =0,
    val respect: Int = 0
) {
    val rank: String= "Junior Android Developer"
   // val nickName: String = transliteration(("$firstName $lastName"),"_")
    fun toMap() :Map<String, Any> = mapOf(
        "nickName" to transliteration(("$firstName $lastName"),"_"),
        "rank" to rank,
        "firstName" to firstName,
        "lastName" to lastName,
        "about" to about,
        "repository" to repository,
        "rating" to rating,
        "respect" to respect
    )




}