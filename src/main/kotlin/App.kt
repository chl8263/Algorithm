import java.time.format.DateTimeFormatter
import java.util.*

object App {
    @JvmStatic
    fun main(args: Array<String>){
        val s = Scanner(System.`in`)
        val given = mutableListOf<Int>()
        for(i in 1..9){
            given.add(s.nextInt())
        }
    }
}