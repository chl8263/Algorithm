package BOJ.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet

object BOJ15663 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val N = st.nextToken().toInt()
        val M = st.nextToken().toInt()

        val arr = Array(10){0}
        val isUsed = Array(10){false}

        val inputArr = Array(N){0}
        val st2 = StringTokenizer(br.readLine())

        for(i in 0 until N){
            val t = st2.nextToken().toInt()
            inputArr[i] = t
        }

        inputArr.sort()

        fun func1(k: Int){
            if(k == M){
                //val sb = StringBuilder()
                for(i in 0 until k){
                    //sb.append("${inputArr[arr[i]]} ")
                    bw.write("${inputArr[arr[i]]} ")
                }
                bw.write("\n")
                return
            }

            val check = Array(100000){false}
            for(i in 0 until N){
                if(!isUsed[i] && !check[inputArr[i]]){
                    check[inputArr[i]] = true
                    arr[k] = i
                    isUsed[i] = true
                    func1(k+1)
                    isUsed[i] = false
                }
            }
        }

        func1(0)

        bw.flush()
        bw.close()
    }
}