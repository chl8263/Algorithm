import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

object BOJ1475 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val arr = Array(10){0}
        st.nextToken().forEach {
            arr[it-'0']++
        }

        var cnt = 0
        for(i in 0..9){
            if(i != 6 && i != 9)
                cnt = max(cnt, arr[i])
        }

        bw.write("${max(cnt, ((arr[6] + arr[9] +1) /2))}")

        bw.flush()
        bw.close()
    }
}