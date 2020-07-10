package BOJ.stack

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

object BOJ2493 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val st2 = StringTokenizer(br.readLine())

        val sb = StringBuilder()
        val stack = Stack<Pair<Int, Int>>()

        val num = st.nextToken().toInt()
        for(i in 1..num){
            val num2 = st2.nextToken().toInt()
            while(true) {
                if (i == 1) {
                    sb.append("0 ")
                    stack.push(Pair(i, num2))
                    break
                } else {
                    if(stack.peek().second < num2){
                        stack.pop()
                        if(stack.isEmpty()){
                            sb.append("0 ")
                            stack.push(Pair(i, num2))
                            break
                        }
                    }else {
                        sb.append("${stack.peek().first} ")
                        stack.push(Pair(i, num2))
                        break
                    }
                }
            }
        }

        bw.write(sb.toString())

        bw.flush()
        bw.close()
    }
}