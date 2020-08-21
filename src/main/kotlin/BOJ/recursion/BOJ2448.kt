package BOJ.recursion

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ2448 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()
        val arr = Array(num){Array(num*2-1){'#'}}

        fun func1 (n: Int, y: Int, x: Int){
            if(n == 3){
                arr[y][x] = '*'
                return
            }

            val cN = n / 2
            func1(cN, y, n-1)
            func1(cN, y+cN, n-1-(cN))
            func1(cN, y+cN, n-1+(cN))
        }

        func1(num, 0, 0)

        for(i in arr){
            for(j in i){
                bw.write("$j")
            }
            bw.write("\n")
        }

        bw.flush()
        bw.close()
    }
}