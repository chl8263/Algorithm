package BOJ.queue

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ2164 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        val queue: Queue<Int> = LinkedList()

        for(i in 1..num){
            queue.add(i)
        }

        while (queue.size > 1){
            queue.poll()
            val t = queue.poll()
            queue.add(t)
        }
        bw.write("${queue.poll()}")

        bw.flush()
        bw.close()
    }
}