package BOJ.stack

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ4889 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))

        var loopCnt = 0
        while(true){
            val st = StringTokenizer(br.readLine())
            val given = st.nextToken()
            if(given[0] == '-') break

            var result = 0

            val s = Stack<Char>()
            for(i in given.indices){
                if(i == 0 && given[i] == '}'){
                    s.push('{')
                    result++
                }
                else if(given[i] == '}' && s.isNotEmpty()){
                    s.pop()
                }else {
                    s.push(given[i])
                }
            }

            bw.write("${++loopCnt}. ${result + (s.size /2)}\n")
        }

        bw.flush()
        bw.close()
    }
}
