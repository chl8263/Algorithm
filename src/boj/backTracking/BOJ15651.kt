package boj.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ15651 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val N = st.nextToken().toInt()
        val M =  st.nextToken().toInt()

        val arr = Array(10){0}
        val isUSed = Array(10){false}

        fun func1(k: Int){
            if(k == M){
                for(i in 0 until M){
                    bw.write("${arr[i]} ")
                }
                bw.write("\n")
                return
            }

            for(i in 1..N){
                if(!isUSed[i]) {
                    arr[k] = i
                    func1(k+1)
                }
            }

        }

        func1(0)

        bw.flush()
        bw.close()
    }
}