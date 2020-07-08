package BOJ.LinkedList

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ5397 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val given = st.nextToken().toInt()

        for(i in 1..given){
            val stack = Stack<Char>()
            val stack2 = Stack<Char>()
            val cursor = 0
            val st2 = StringTokenizer(br.readLine())
            val case = st2.nextToken()
            case.forEach {
                when (it) {
                    '<' -> {
                        if(!stack.isEmpty()){
                            stack2.push(stack.pop())
                        }
                    }
                    '>' -> {
                        if(!stack2.isEmpty()){
                            stack.push(stack2.pop())
                        }
                    }
                    '-' -> {
                        if(!stack.isEmpty()){
                            stack.pop()
                        }
                    }
                    else -> stack.push(it)
                }
            }
            while (!stack2.isEmpty()){
                stack.push(stack2.pop())
            }
            stack.forEach { bw.write("$it") }
            bw.newLine()
        }


        bw.flush()
        bw.close()
    }
}