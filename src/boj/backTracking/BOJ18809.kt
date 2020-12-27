package boj.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

object BOJ18809 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val Y = st.nextToken().toInt()
        val X = st.nextToken().toInt()
        val G = st.nextToken().toInt()
        val R = st.nextToken().toInt()

        val arr = Array(Y){Array(X){0}}

        var possibleList = ArrayList<Pair<Int, Int>>()
        for(i in 0 until Y){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until X){
                var t = st2.nextToken().toInt()
                arr[i][j] = t
                if(t == 2) possibleList.add(Pair(i, j))
            }
        }

        val visit = Array(possibleList.size){false}
        fun dfs (count: Int){
            if(count == possibleList.size) {

                return
            }

            for(i in 0 until possibleList.size){
                if(!visit[i]){
                    visit[i] = true
                    dfs(count+1)
                    visit[i] = false
                }
            }
        }

        bw.flush()
        bw.close()
    }
}