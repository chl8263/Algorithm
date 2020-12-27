package boj.recursion

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ1992 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()
        val arr = Array(num){Array(num){'x'}}

        for(i in 0 until num){
            val st2 = br.readLine()
            for(j in 0 until num){
                arr[i][j] = st2[j]
            }
        }

        fun func1(n: Int, y: Int, x: Int): String{
            if(n == 1) return arr[y][x].toString()

            val half = n/2
            val x1 = func1(half, y, x)
            val x2 = func1(half, y, x + half)
            val x3 = func1(half, y + half, x)
            val x4 = func1(half, y + half, x + half)

            val sb = StringBuilder()

            if(x1.length == 1 && x1 == x2 && x1 == x3 && x1 == x4){
                sb.append(x1)
            }else {
                sb.append("(")
                sb.append(x1)
                sb.append(x2)
                sb.append(x3)
                sb.append(x4)
                sb.append(")")
            }

            return sb.toString()
        }

        val result = func1(num, 0, 0)

        bw.write("$result")

        bw.flush()
        bw.close()
    }
}