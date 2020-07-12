package BOJ.bruteForceSearch

import java.util.*

object BOJ2231 {
    @JvmStatic
    fun main(args: Array<String>){

        val s = Scanner(System.`in`)
        var given= s.nextInt()

        val length = given.toString().length

        var result = 0

        for (i in 1..(length * 9)) {
            var saved = given - i
            var temp = saved.toString()
            temp.forEach { saved += it-'0' }

            if(given == saved) result = temp.toInt()
        }
        println(result)
    }
}