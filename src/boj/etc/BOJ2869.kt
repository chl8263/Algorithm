import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ2869 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val go = st.nextToken().toInt()
        val stop = st.nextToken().toInt()
        val purpose = st.nextToken().toInt()

        var result = if((purpose-stop)%(go-stop) == 0) (purpose-stop)/(go-stop) else (purpose-stop)/(go-stop) +1

        println(result)
    }
}