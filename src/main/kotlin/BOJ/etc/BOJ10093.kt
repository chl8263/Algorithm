import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ10093 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        var a = st.nextToken().toLong()
        var b = st.nextToken().toLong()

        if(b < a) {
            val t = b
            b = a
            a = t
        }

        if(a != b) {
            println(b-a-1)
            for (i in a + 1 until b) {
                print("$i ")
            }
        }else {
            println(0)
        }
    }
}