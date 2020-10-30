package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ15684 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        val N = st.nextToken().toInt()
        val M = st.nextToken().toInt()
        val H = st.nextToken().toInt()

        val arr = Array(H+1){Array(N){0}}
        val lineList = Array(H){Array(N-1){false}}

        for(i in 0 until M){
            val st2 = StringTokenizer(br.readLine())
            val y = st2.nextToken().toInt() - 1
            val x = st2.nextToken().toInt() - 1
            lineList[y][x] = true
        }

        for(i in 0 until H){
            for(j in 0 until N-1){
                print("${lineList[i][j]} ")
            }
            println()
        }



        bw.flush()
        bw.close()
    }
}