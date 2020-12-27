package boj.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ15666 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val N = st.nextToken().toInt()
        val M = st.nextToken().toInt()

        val arr = Array(10){-1}
        val inputArr = Array(N){0}

        val st2 = StringTokenizer(br.readLine())

        for(i in 0 until N){
            inputArr[i] = st2.nextToken().toInt()
        }

        inputArr.sort()

        fun func1(k: Int, b: Int){
            if(k == M){
                for(i in 0 until k) {
                    bw.write("${arr[i]} ")
                }
                bw.write("\n")
                return
            }

            val check = Array(10000){false}
            for(i in 0 until N){
                if(!check[inputArr[i]] && b <= inputArr[i]){
                    check[inputArr[i]] = true
                    arr[k] = inputArr[i]
                    func1(k+1, arr[k])
                }
            }
        }

        func1(0, 0)

        bw.flush()
        bw.close()
    }
}