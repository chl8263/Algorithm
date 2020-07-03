import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ10871 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val n = st.nextToken().toInt()
        val x = st.nextToken().toInt()

        val st2 = StringTokenizer(br.readLine())

        for(i in 0 until n){
            val t = st2.nextToken().toInt()
            if(t < x) print("$t ")
        }
    }
}