import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ1929 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val one = st.nextToken().toInt()
        val two = st.nextToken().toInt()

        for(i in one..two){
            if(i % 2 != 0) {
                var cnt = 0
                for (j in 1..i) {
                    if (i % j == 0) cnt++
                    if(cnt > 2) break
                }
                if (cnt == 2) println(i)
            }
        }
    }
}