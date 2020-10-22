package BOJ.simulation

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
        val order = Array(num){0}

        var ans = Int.MAX_VALUE

        var isVisited2 = Array(num){false}
        val order2 = Array(2){0}

        var t_arr = ArrayList<Int>()
        var t_result = 0
        fun dfs2(c: Int){
            if(c == 2){
//                for(i in order2){
//                    print(i)
//                }
//                println()
                t_result += arr[t_arr[order2[0]]][t_arr[order2[1]]]
                return
            }
            for(i in 0 until t_arr.size){
                if(isVisited2[i]) continue
                isVisited2[i] = true
                order2[c] = i
                dfs2(c+1)
                isVisited2[i] = false
            }
        }

        fun cal(tt_arr: ArrayList<Int>): Int {
            t_arr = tt_arr
            isVisited2 = Array(tt_arr.size){false}
            t_result = 0
            dfs2(0)
            return t_result
        }

        fun dfs(c: Int){
            if(c == num){
                var one = 0
                var two = 0
                val mid = (num-1)/2

                val oneArr = ArrayList<Int>()
                val twoArr = ArrayList<Int>()
                for(i in 0 until order.size){
                    if(i <= mid){
                        oneArr.add(order[i])
                    }else {
                        twoArr.add(order[i])
                    }
                }
                val result1 = cal(oneArr)
                val result2 = cal(twoArr)
                ans = min(ans, abs(result1 - result2))
                return
            }

            for(i in 0 until num){
                if(visited[i]) continue
                visited[i] = true
                order[c] = i
                dfs(c + 1)
                visited[i] = false
            }
        }
        dfs(0)

        bw.write("$ans")

        //dfs2(0, 0)

        bw.flush()
        bw.close()
    }
}