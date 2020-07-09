package BOJ.stack

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

object BOJ1874 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        val stack = Stack<Int>()
        val list = ArrayList<Int>()
        for (i in 1..num) list.add(i)

        val sb = StringBuilder()

        var index = 0
        loop@ for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            val num2 = st2.nextToken().toInt()
            loop1@ while (true) {
                when {
                    index > num  -> {
                        sb.clear()
                        sb.append("NO")
                        break@loop
                    }
                    stack.isEmpty() || num2 != stack.peek() ->{
                        stack.push(++index)
                        sb.append("+\n")
                    }
                    num2 == stack.peek() -> {
                        stack.pop()
                        sb.append("-\n")
                        continue@loop
                    }
                }
            }
        }

        bw.write(sb.toString())

        bw.flush()
        bw.close()
    }
}
