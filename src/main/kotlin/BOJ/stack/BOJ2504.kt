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

        val s = Stack<Char>()
        val result = 0
        val temp = ArrayList<Int>()
        var index = 0
        for(i in given.indices){
            if(given[i] == '(' || given[i] == '['){
                s.push(given[i])
                if(temp.isNotEmpty()){

                }
            }else if(given[i] == ')'){
                s.pop()
                if(s.isEmpty()){
                    // calculate
                }else {
                    temp.add(2)
                    index++
                }
            }else if(given[i] == ']'){

            }
        }

        bw.flush()
        bw.close()
    }
}