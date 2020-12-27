import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ2576 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))

        var sum = 0
        var min = 0
        for(i in 1..7){
            val st = StringTokenizer(br.readLine())
            val a = st.nextToken().toInt()
            if(a % 2 != 0) {
                sum += a
                if(min == 0 || min > a) min = a
            }
        }
        if(sum == 0) println(-1)
        else {
            println(sum)
            println(min)
        }
    }
}