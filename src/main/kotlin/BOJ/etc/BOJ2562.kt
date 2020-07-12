import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ2562 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        var temp = 0
        var cnt = 0
        for(i in 1..9){
            val st = StringTokenizer(br.readLine())
            val a = st.nextToken().toInt()
            if(a > temp) {
                temp = a
                cnt = i
            }
        }

        println(temp)
        println(cnt)
    }
}