package BOJ.linkedList

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*

object BOJ1158 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        val k = st.nextToken().toInt()
        val list = arrayListOf<Int>()

        var cursor = 0
        for (i in 1..n) list.add(i)

        val sb = StringBuilder()
        sb.append("<")

        while (list.isNotEmpty()){
            cursor = (cursor+(k-1)) % list.size
            if(list.size > 1){
                sb.append("${list[cursor]}, ")
            }else {
                sb.append("${list[cursor]}>")
            }
            list.removeAt(cursor)
        }

        bw.write(sb.toString())

        bw.flush()
        bw.close()
    }
}