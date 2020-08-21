package BOJ.recursion

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ16505 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        val mod = {i: Int ->
            var t = 1
            for(j in 0 until i){
                t *= 2
            }
            t
        }

        val num2 = mod(num)

        val arr = Array(num2){Array(num2){' '}}

        fun func1 (n: Int, y: Int, x: Int){
            if(n == 0) {
                arr[y][x] = '*'
                return
            }

            val n2 = mod(n)/2

            func1(n-1, y, x)
            func1(n-1, y+n2, x)
            func1(n-1, y, x+n2)
        }

        func1(num, 0,0)

        for(i in arr){
            var str = ""
            var cnt = 0
            for((index, j) in i.withIndex()){
                if(j == '*'){
                    cnt = index
                }
                str += j
                //bw.write("$j")
            }

            bw.write(str.substring(0, cnt+1))
            bw.write("\n")
        }

        bw.flush()
        bw.close()
    }
}