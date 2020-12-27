import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ1978 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        val st2 = StringTokenizer(br.readLine())

        var result = 0
        for(i in 0 until num){
            val x = st2.nextToken().toInt()
            var subResult = 0
            for(j in 1..x){
                if(x % j == 0)
                    subResult++
            }
            if(subResult == 2) result++
        }
        println(result)
    }
}