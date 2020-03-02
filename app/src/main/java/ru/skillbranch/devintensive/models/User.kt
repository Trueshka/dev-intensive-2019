package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User (
    val id:String,
    var firstName:String?,
    var lastName:String?,
    var avatar:String?,
    var rating:Int = 0,
    var respect:Int = 0,
    var lastVisit: Date?=null,
    val isOnline:Boolean = false

    ) {


    constructor(id:String,firstName:String?,lastName:String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )
    constructor(id:String) : this(id, "John", "Doe $id")
    init {

        println(
            "Its Alive \n ${if (lastName === "Doe") "His name id $firstName $lastName" else "and his name $firstName $lastName!"}\n"
        
        )

    }
    companion object Factory{
        private var lastId: Int = -1


            fun makeUser(fullName: String?): User{
                lastId++

                val parts: List<String>? = fullName?.split(" ")
                val (firstName, lastName) = Utils.parseFullName(fullName)




            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }



    }


}


