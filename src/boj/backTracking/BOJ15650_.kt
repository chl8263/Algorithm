package boj.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ15650_ {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val N = st.nextToken().toInt()
        val M = st.nextToken().toInt()

        val arr = Array(10){0}
        val isUsed = Array(10){false}

        fun func1(k: Int, start: Int){
            if(k == M){
                for(i in 0 until k)
                    bw.write("${arr[i]} ")
                bw.write("\n")
                return
            }

            for(i in start..N){
                if(!isUsed[i]){
                    arr[k] = i
                    isUsed[i] = true
                    func1(k + 1, i + 1)
                    isUsed[i] = false
                }
            }
        }

        func1(0, 1)

        bw.flush()
        bw.close()
    }
}