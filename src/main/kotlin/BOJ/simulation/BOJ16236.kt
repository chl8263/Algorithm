package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ16236 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var N = 0
    var arr = Array(N){Array(N){0}}
    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())
        N = st.nextToken().toInt()
        arr = Array(N){Array(N){0}}

        for(i in 0 until N){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until N){
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        bw.flush()
        bw.close()
    }
}