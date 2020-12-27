package boj.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.min

object BOJ14889 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        val num = st.nextToken().toInt()
        val arr = Array(num){Array(num){0}}

        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until num){
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        val visited = Array(num){false}

        var ans = Int.MAX_VALUE

        fun cal(){
            var resultTrue = 0
            var resultFalse = 0
            for(i in 0 until num){
                for(j in 0 until num){
                    if(i != j && visited[i] && visited[j]){
                        resultTrue += arr[i][j]
                    }
                    if(i != j && !visited[i] && !visited[j]){
                        resultFalse += arr[i][j]
                    }
                }
            }
            ans = min(ans, abs(resultFalse - resultTrue))
        }

        fun dfs(c: Int, start: Int){
            if(c == num/2){
                cal()
                return
            }

            for(i in start until num){
                if(visited[i]) continue
                visited[i] = true
                dfs(c + 1, i)
                visited[i] = false
            }
        }

        dfs(0, 0)

        bw.write("$ans")

        bw.flush()
        bw.close()
    }
}