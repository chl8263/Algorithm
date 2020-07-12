package BOJ.stack

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ10828 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        val arr = Array(10000){0}
        var cursor = -1

        for(i in 1..num){
            val st2 = StringTokenizer(br.readLine())
            val command = st2.nextToken()

            when (command){
                "push" -> {
                    val value = st2.nextToken().toInt()
                    arr[++cursor] = value
                }
                "pop" -> {
                    if(cursor == -1) bw.write("-1\n")
                    else if(cursor > -1) bw.write("${arr[cursor--]}\n")
                }
                "size" -> {
                    bw.write("${cursor+1}\n")
                }
                "empty" -> {
                    if(cursor == -1) bw.write("1\n")
                    else if(cursor > -1) bw.write("0\n")
                }
                "top" -> {
                    if(cursor == -1) bw.write("-1\n")
                    else if(cursor > -1) bw.write("${arr[cursor]}\n")
                }
            }
        }

        bw.flush()
        bw.close()
    }
}