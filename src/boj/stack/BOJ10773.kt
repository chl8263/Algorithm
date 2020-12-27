package boj.stack

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ10773 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        val stack = Stack<Int>()
        for(i in 1..num){
            val st2 = StringTokenizer(br.readLine())
            val num2 = st2.nextToken().toInt()
            if(num2 != 0)
                stack.push(num2)
            else stack.pop()
        }

        var result = 0
        while (stack.isNotEmpty()){
            result += stack.pop()
        }

        bw.write("$result")

        bw.flush()
        bw.close()
    }
}