package BOJ.stack

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

object BOJ2504_ {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val given = st.nextToken()

        val s = Stack<Any>()
        var flag = true
        var result = 0

        loop@for(i in given.indices){
            if(given[i] == '(' || given[i] == '['){
                s.push(given[i])
            }else if(given[i] == ')'){
                var temp = 0
                while(s.isNotEmpty() && s.peek() != '('){
                    val peek = s.pop()
                    if(peek is Int)
                        temp += peek
                    else {
                        flag = false
                        break@loop
                    }
                }
                if(s.isEmpty()) {
                    flag = false
                    break@loop
                }
                s.pop()
                if(temp == 0) temp = 1
                s.push(temp * 2)

            }else if(given[i] == ']'){
                var temp = 0
                while(s.isNotEmpty() && s.peek() != '['){
                    val peek = s.pop()
                    if(peek is Int)
                        temp += peek
                    else {
                        flag = false
                        break@loop
                    }
                }
                if(s.isEmpty()) {
                    flag = false
                    break@loop
                }
                s.pop()
                if(temp == 0) temp = 1
                s.push(temp * 3)
            }else {
                flag = false
                break@loop
            }
        }

        if(!flag) bw.write(0.toString())

        else {
            while (s.isNotEmpty()) {
                var peek = s.pop()
                if(peek is Int) {
                    result += peek
                } else {
                    result = 0
                    break
                }
            }
            bw.write(result.toString())
        }

        bw.flush()
        bw.close()
    }
}