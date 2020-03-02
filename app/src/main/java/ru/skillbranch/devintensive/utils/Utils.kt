package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {

        val parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)
        if (firstName != null) {
            if (firstName.isBlank()) {
                firstName = null
                lastName = null
            }
        }

        return firstName to lastName
    }

    fun transliteration(payload: String, devider: String = " "): String {
        var state = ""
        for (i in payload) {
            state += when (i.toString().toLowerCase()) {
                "а" -> "a"

                "б" -> "b"

                "в" -> "v"

                "г" -> "g"

                "д" -> "d"

                "е" -> "e"

                "ё" -> "e"

                "ж" -> "zh"

                "з" -> "z"

                "и" -> "i"

                "й" -> "i"

                "к" -> "k"

                "л" -> "l"

                "м" -> "m"

                "н" -> "n"

                "о" -> "o"

                "п" -> "p"

                "р" -> "r"

                "с" -> "s"

                "т" -> "t"

                "у" -> "u"

                "ф" -> "f"

                "х" -> "h"

                "ц" -> "c"

                "ч" -> "ch"

                "ш" -> "sh"

                "щ" -> "sh"

                "ъ" -> ""

                "ы" -> "i"

                "ь" -> ""

                "э" -> "e"

                "ю" -> "yu"

                "я" -> "ya"
                else -> i
            }
        }
        val parts: List<String>? = state?.split(" ")
        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)
        firstName = firstName?.capitalize()
        lastName = lastName?.capitalize()
        state = "$firstName $lastName"
        return state
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var initials = ""
        if (firstName != null && lastName != null) initials =
            firstName[0].toString() + lastName[0].toString()
        else if (firstName != null && lastName == null) initials = firstName[0].toString()
        else initials = null.toString()


        return initials
    }
}
