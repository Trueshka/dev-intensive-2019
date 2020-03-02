package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?): Pair<String?,String?>{

        val parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)
        if (firstName != null) {
            if(firstName.isBlank()){firstName=null
                lastName=null}
        }

        return firstName to lastName
    }

    fun transliteration(payload: String,devider:String = " "): String {
        TODO("123")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
TODO("123")
    }
}