package boj.stack

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ4949 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val a = '('
        val a1 = ')'
        val b = '['
        val b1 = ']'

        var f = true
        while(f){
            val str = br.readLine()
            if(str == ".") break

            var result = "yes"

            val s = Stack<Char>()

            for(it in str){
                if(it == a || it == b){
                    s.push(it)
                }else if(it == a1){
                    if(s.isEmpty()) {
                        result = "no"
                        break
                    }
                    if(s.peek() == a) s.pop()
                    else {
                        result = "no"
                        break
                    }
                }else if(it == b1){
                    if(s.isEmpty()) {
                        result = "no"
                        break
                    }
                    if(s.peek() == b) s.pop()
                    else {
                        result = "no"
                        break
                    }
                }
            }
            if(s.isNotEmpty()) result = "no"
            bw.write("$result\n")
        }

        bw.flush()
        bw.close()
    }
}