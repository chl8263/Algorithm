import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ10869 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val one = st.nextToken().toInt()
        val two = st.nextToken().toInt()

        println(one + two)
        println(one - two)
        println(one * two)
        println(one / two)
        println(one % two)
    }
}