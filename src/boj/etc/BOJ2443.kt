package boj.etc

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ2443 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))

        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        for(i in num downTo 1){
            for(j in num-i downTo 1)
                bw.write(" ")
            for(j in 1..((2*(i-1))+1))
                bw.write("*")
            bw.write("\n")
        }

        bw.flush()
        bw.close()
    }
}