package BOJ.recursion

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ1074 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val N = st.nextToken().toInt()
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        val mod = {x: Int ->
            var result = 2
            for(i in 0 until x-1){
                result *= 2
            }
            result
        }

        val num = mod(N)
        val arr = Array(num){Array(num){-1}}



        bw.write("$num")

        bw.flush()
        bw.close()
    }

    fun func1(i: Int, y: Int, x: Int) {
        if(i == 0) {

            return
        }
    }
}