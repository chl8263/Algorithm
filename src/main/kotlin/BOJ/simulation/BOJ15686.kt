package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ15686 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var n = 0
    var m = 0

    lateinit var arr : Array<Array<Int>>


    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        n = st.nextToken().toInt()
        m = st.nextToken().toInt()

        arr = Array(n+1){Array(n+1){0}}

        for(i in 1..n){
            val st2 = StringTokenizer(br.readLine())
            for(j in 1..n){
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        bw.flush()
        bw.close()
    }
}