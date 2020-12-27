package boj.recursion

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ5904 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val num = st.nextToken().toInt()

        fun func1(n: Int): String{
            if(n == 0) return "moo"

            val sb = StringBuilder()
            val x = func1(n-1)
            if(x.length > num) return x

            sb.append("m")
            for(i in 1..n+2){
                sb.append("o")
            }

            return x + sb.toString() + x
        }

        val result = func1(num)

        bw.write("${result[num-1]}")

        bw.flush()
        bw.close()
    }
}