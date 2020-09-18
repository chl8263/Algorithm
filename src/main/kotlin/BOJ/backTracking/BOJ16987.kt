package BOJ.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

object BOJ16987 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()
        val arr = Array(num){Pair(0, 0)}

        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            arr[i] = arr[i].copy(st2.nextToken().toInt(), st2.nextToken().toInt())
        }

        val visit = Array(num){false}
        var ans = 0
        fun dfs (count: Int, start: Int, breaking: Int){
            if(count == num) {
                ans = max(breaking, ans)
                return
            }

            for(i in start until num){
                if(!visit[i]){

                }
            }
        }

        for(i in 0 until num){

        }

        bw.flush()
        bw.close()
    }
}