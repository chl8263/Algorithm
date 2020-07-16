package BOJ.stack

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

object BOJ2504 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val given = st.nextToken()

        val s = Stack<Any>()
        var flag = true
        var result = 0
        var cnt1 = 0
        var cnt2 = 0
        loop@for(i in given.indices){
            if(given[i] == '('){
                if(++cnt1 < 0 ) {
                    flag = false
                    break@loop
                }
                s.push(given[i])
            }else if(given[i] == '['){
                if(++cnt2 < 0 ) {
                    flag = false
                    break@loop
                }
                s.push(given[i])
            }else if(given[i] == ')'){
                if(--cnt1 < 0 ) {
                    flag = false
                    break@loop
                }
                if(s.isEmpty()) {
                    flag = false
                    break@loop
                }
                var temp = 0
                while(s.peek() != '('){
                    val peek = s.pop()
                    if(peek is Int)
                        temp += peek
                    else {
                        flag = false
                        break@loop
                    }
                }
                s.pop()
                if(temp == 0) temp = 1
                s.push(temp * 2)

            }else if(given[i] == ']'){
                if(--cnt2 < 0 ) {
                    flag = false
                    break@loop
                }
                if(s.isEmpty()) {
                    flag = false
                    break@loop
                }
                var temp = 0
                while(s.peek() != '['){
                    val peek = s.pop()
                    if(peek is Int)
                        temp += peek
                    else {
                        flag = false
                        break@loop
                    }
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
                result += s.pop() as Int
            }
            bw.write(result.toString())
        }

        bw.flush()
        bw.close()
    }
}