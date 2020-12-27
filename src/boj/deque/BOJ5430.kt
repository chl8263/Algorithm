package BOJ.deque

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*

object BOJ5430 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        for(i in 1..num){
            var result = StringBuilder()
            val st2 = StringTokenizer(br.readLine())
            val command = st2.nextToken()
            val st3 = StringTokenizer(br.readLine())
            val arrSize = st3.nextToken().toInt()
            val st4 = StringTokenizer(br.readLine())

            val arr = st4.nextToken().replace("[", "").replace("]", "").split(",")

            val deque: Deque<Int> = LinkedList()
            for(x in arr) {
                if(x != "")
                    deque.add(x.toInt())
            }
            var head = true

            //println(deque)
            for(i in command.indices){
                //println(command[i])
                if(command[i] == 'R'){
                    head = !head
                }else if(command[i] == 'D'){
                    if(deque.isEmpty()){
                        result.append("error\n")
                        break
                    }else {
                        if(head)
                            deque.pollFirst()
                        else
                            deque.pollLast()
                    }
                }
            }

            if(result.toString() != "error\n") {
                result.append("[")
                while (deque.isNotEmpty()) {
                    if (head) {
                        result.append(deque.pollFirst())
                        result.append(",")
                    } else {
                        result.append(deque.pollLast())
                        result.append(",")
                    }
                }
                if (result.toString().length > 1)
                    result.deleteCharAt(result.toString().length - 1)
                result.append("]\n")
            }

            bw.write(result.toString())
        }

        bw.flush()
        bw.close()
    }
}