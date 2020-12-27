package boj.etc

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ2439 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))

        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        for(i in 1..num){
            for(j in 1..num-i)
                bw.write(" ")
            for(j in 1..i)
                bw.write("*")
            bw.write("\n")
        }

        bw.flush()
        bw.close()
    }
}