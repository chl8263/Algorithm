package BOJ.deque

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ10866_ {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val deque: Deque<Int> = LinkedList()

        val num = st.nextToken().toInt()

        for(i in 1..num){
            val st2 = StringTokenizer(br.readLine())
            when(st2.nextToken()){
                "push_front" -> {
                    val value = st2.nextToken().toInt()
                    deque.offerFirst(value)
                }
                "push_back " -> {
                    val value = st2.nextToken().toInt()
                    deque.offerLast(value)

                }
                "pop_front" -> {
                    if(deque.isEmpty()){
                        bw.write("-1\n")
                    }else {
                        bw.write("${deque.pollFirst()}\n")
                    }
                }
                "pop_back" -> {
                    if(deque.isEmpty()){
                        bw.write("-1\n")
                    }else {
                        bw.write("${deque.pollLast()}\n")
                    }
                }
                "size" -> {
                    bw.write("${deque.size}\n")
                }
                "empty" -> {
                    if(deque.isEmpty()){
                        bw.write("1\n")
                    }else {
                        bw.write("0\n")
                    }
                }
                "front" -> {
                    if(deque.isEmpty()){
                        bw.write("-1\n")
                    }else {
                        bw.write("${deque.first}\n")
                    }
                }
                "back" -> {
                    if(deque.isEmpty()){
                        bw.write("-1\n")
                    }else {
                        bw.write("${deque.last}\n")
                    }
                }
            }
        }

        bw.flush()
        bw.close()
    }
}