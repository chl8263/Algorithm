package BOJ.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ1941 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))

        val arr = Array(5){Array(5){'x'}}
        for(i in 0 until 5){
            val st = br.readLine()
            for(j in 0 until 5){
                arr[i][j] = st[j]
            }
        }

        fun fun1(s: Int){

        }


        bw.flush()
        bw.close()
    }
}