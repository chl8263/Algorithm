package BOJ.stack

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ9012 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        for(i in 1..num){
            val s = Stack<Char>()
            val given = br.readLine()

            for(i in given.indices){
                if(given[i] == '('){
                    s.push(given[i])
                }else {
                    if(s.isNotEmpty()&&s.peek() == '('){
                       s.pop()
                    }else {
                        s.push(given[i])
                    }
                }
            }
            if(s.empty()) bw.write("YES\n")
            else bw.write("NO\n")
        }

        bw.flush()
        bw.close()
    }
}