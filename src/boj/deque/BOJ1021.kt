package boj.deque

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ1021 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        var result = 0

        val deque: Deque<Int> = LinkedList()
        for(i in 1..num){
            deque.add(i)
        }

        val st2 = StringTokenizer(br.readLine())
        for(i in 1..st.nextToken().toInt()) {
            val value = st2.nextToken().toInt()

            while (deque.first != value) {
                var half = deque.size / 2
                if (deque.size % 2 == 0) {
                    if (deque.indexOf(value) >= half) {
                        deque.addFirst(deque.pollLast())
                    } else deque.addLast(deque.pollFirst())
                    result++
                } else {
                    if (deque.indexOf(value) > half) {
                        deque.addFirst(deque.pollLast())
                    } else deque.addLast(deque.pollFirst())
                    result++
                }
            }
            deque.pollFirst()
        }
        bw.write("$result")

        bw.flush()
        bw.close()
    }
}