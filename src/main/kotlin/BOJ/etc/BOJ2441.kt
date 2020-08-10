package BOJ.etc

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ2441 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))

        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        for(i in num downTo 1){
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