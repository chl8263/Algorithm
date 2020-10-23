package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ14890 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        val num = st.nextToken().toInt()
        val L = st.nextToken().toInt()

        val arr = Array(num){Array(num){0}}

        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until num){
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        for(i in 0 until num){

        }

        for(i in 0 until num){

        }

        bw.flush()
        bw.close()
    }
}