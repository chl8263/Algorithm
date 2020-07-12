import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

object BOJ1919 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val st2 = StringTokenizer(br.readLine())

        val arr = Array(26){0}
        val arr2 = Array(26){0}
        val a = st.nextToken()
        val b = st2.nextToken()

        a.forEach { arr[it-'a']++ }

        b.forEach { arr2[it-'a']++ }

        var cnt = 0
        for(i in 0..25){
            if(arr[i] != arr2[i])
                cnt += abs(arr[i] - arr2[i])
        }

        bw.write("$cnt")

        bw.flush()
        bw.close()
    }
}