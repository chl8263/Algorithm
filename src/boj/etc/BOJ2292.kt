import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.pow

object BOJ2292 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val given = st.nextToken().toInt()

        var value = 1
        var cnt = 1

        while (true){
            if(given == 1) break
            if(given < value+1) break
            value += 6 * cnt++
        }
        println(cnt)
    }
}