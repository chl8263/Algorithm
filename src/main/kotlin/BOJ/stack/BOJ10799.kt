package BOJ.stack

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ10799 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val given = br.readLine()

        val s = Stack<Int>()
        var result = 0

        for(i in 0 until given.length-1){
            if(given[i] == '('){
                s.push(i)
            }else if(given[i] == ')'){
                if(s.peek() == i-1) {
                    s.pop()
                    if(s.isNotEmpty())
                        result += s.size +1
                }else s.pop()

            }
        }
        bw.write(result.toString())

        bw.flush()
        bw.close()
    }
}