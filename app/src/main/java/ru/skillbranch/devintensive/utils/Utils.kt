package ru.skillbranch.devintensive.utils

import java.util.*

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {


        val parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)


        if (firstName.isNullOrBlank()) {
            firstName = null
            lastName = null
        } else if (lastName.isNullOrBlank()) {
            lastName = null
        }
        return firstName to lastName
    }


    fun transliteration(payload: String, devider: String = " "): String {
      /*  var state = ""
        for (i in payload) {
            state += when (i.toString().toLowerCase(Locale.getDefault())) {
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
        var fin=""

        var parts: List<String>? = state.split(" ")
        var firstName = parts!!.getOrNull(0)?.capitalize()
     //   parts.first() = parts.first().capitalize()
       // var lastName = parts?.last()

        /* state = firstName!!.capitalize() + devider + lastName!!.capitalize() */
        var count=0
for(i in parts){
    if(count!=0&&count!=parts?.last())
}
       return parts?.joinToString(separator = devider) {  }.toString()
        //return state*/
         var state = ""
            for (i in payload) {
                state += when (i.toString().toLowerCase(Locale.getDefault())) {
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
            var fin=""

            var parts: List<String>? = state.split(" ")
         //   var firstName = parts!!.getOrNull(0)?.capitalize()
         //   parts.first() = parts.first().capitalize()
           // var lastName = parts?.last()

            /* state = firstName!!.capitalize() + devider + lastName!!.capitalize() */


           return parts?.joinToString(separator = devider).toString()
            //return state

    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        return if (!firstName.isNullOrBlank() && !lastName.isNullOrBlank())
            firstName[0].toString().toUpperCase() + lastName[0].toString().toUpperCase()
        else if (firstName.isNullOrBlank() && !lastName.isNullOrBlank()) lastName?.get(0)?.toString().toUpperCase()
        else if (!firstName.isNullOrBlank() && lastName.isNullOrBlank()) firstName?.get(0)?.toString().toUpperCase()
        else null


    }
}
