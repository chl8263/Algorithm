import java.io.BufferedReader
import java.io.InputStreamReader
import java.time.format.DateTimeFormatter
import java.util.*

object BOJ1712 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        val result = if((c - b) <= 0) -1 else (a / (c-b)) + 1

        println(result)
    }
}