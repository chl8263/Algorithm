package boj.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ1697_ {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val arr = Array(100001){-1}
        val q: Queue<Int> = LinkedList()

        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        arr[a] = 0
        q.add(a)

        val validate = arrayOf(-1, 1, 2)
        var result = 0
        loop@while(q.isNotEmpty()){
            val peek = q.poll()

            for(i in validate.indices){
                val dx = if(i == 2) peek * validate[i]
                else peek + validate[i]
                if(dx in 0..100000 && arr[dx] == -1){
                    if(dx == b) {
                        result = arr[peek] + 1
                        break@loop
                    }
                    arr[dx] = arr[peek] + 1
                    q.add(dx)
                }
            }
        }

        bw.write("$result")

        bw.flush()
        bw.close()
    }
}