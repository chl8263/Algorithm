package sample

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object App {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val R = st.nextToken().toInt()
        val C = st.nextToken().toInt()
        val arr = Array(R){Array(C){""}}

        for(i in 0 until R){
            for(j in 0 until C){
                arr[i][j] = "[$i, $j]"
            }
            println()
        }
        println()
        for(i in 0 until R){
            for(j in 0 until C){
                print(arr[i][j])
            }
            println()
        }

        bw.flush()
        bw.close()
    }
}