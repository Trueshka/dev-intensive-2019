package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_intense() {

        val user2 = User("3", "John", "Cena")
    }

        @Test
        fun test_factory(){
            val user = User.makeUser("John Wick")
            val user2=user.copy(id="2", lastName = "Cena", lastVisit = Date())
  print("$user\n $user2")
        }

    @Test
    fun test_decomposition() {
        val user = User.makeUser(" ")
fun getUserInfo()= user
        val (id,firstName, lastName) = getUserInfo()
   // println("${user.component1()} $firstName $lastName")
       // println(Utils.toInitials(" ", ""))
        println(Utils.transliteration("Amazing Петр","_"))
      //print( Date().add(-3, TimeUnits.HOUR).humanizeDiff())

    }
    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        val user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastName = "Cena",lastVisit = Date().add(2,TimeUnits.SECOND))
        var user4 = user.copy(lastName = "Cena",lastVisit = Date().add(2,TimeUnits.HOUR))
println("""
    ${user.lastVisit?.format()} 
    ${user2.lastVisit?.format()} 
    ${user3.lastVisit?.format()} 
    
""".trimIndent()
)

    }
    @Test
    fun test_data_mapping() {
        val user = User.makeUser("Иван ")
        val userView = user.toUserView()
        userView.printMe()
    }
    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("John Wick")
        val txtMessage= BaseMessage.makeMessage(user, Chat("0"),payload = "any text message",type="text")
        val imgMessage= BaseMessage.makeMessage(user, Chat("0"),payload = "any url ",type="image")
     println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }
    }


