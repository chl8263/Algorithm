package BOJ.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ15656 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val N = st.nextToken().toInt()
        val M = st.nextToken().toInt()

        val st2 = StringTokenizer(br.readLine())

        val inputArr = Array(N){0}
        for(i in 0 until N){
            inputArr[i] = st2.nextToken().toInt()
        }
        inputArr.sort()

        val arr = Array(10){0}
        val isUsed = Array(10){false}

        fun func1(k: Int){
            if(k == M){
                for(i in 0 until k){
                    bw.write("${inputArr[arr[i]]} ")
                }
                bw.write("\n")
                return
            }

            for(i in 0 until N){
                if(!isUsed[i]) {
                    arr[k] = i
                    func1(k + 1)
                }
            }
        }

        func1(0)

        bw.flush()
        bw.close()
    }
}