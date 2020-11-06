package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max
import kotlin.math.min

object BOJ17142 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var N = 0
    var M = 0

    var arr = Array(N){Array(N){-1}}

    val virusList = ArrayList<Pair<Int, Int>>()

    val dy = arrayOf(0, 0, -1, 1)
    val dx = arrayOf(-1, 1, 0, 0)

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        N = st.nextToken().toInt()
        M = st.nextToken().toInt()
        arr = Array(N){Array(N){-1}}

        for(i in 0 until N){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until N){
                val t = st2.nextToken().toInt()
                if(t == 2) {
                    virusList.add(Pair(i, j))
                }
                arr[i][j] = t

            }
        }

        var ans = Int.MAX_VALUE
        val visited = Array(virusList.size){false}
        fun dfs (s: Int, c: Int){
            if(c == M){
                val t = bfs(visited)
                if(t != -1) ans = min(ans, t)
                return
            }

            for(i in s until virusList.size){
                if(visited[i]) continue
                visited[i] = true
                dfs(i, c+1)
                visited[i] = false
            }

        }

        dfs(0, 0)

        if(ans == Int.MAX_VALUE) ans = -1
        bw.write("$ans")

        bw.flush()
        bw.close()
    }

    fun bfs(pickList: Array<Boolean>): Int {

        val q: Queue<Pair<Int, Int>> = LinkedList()
        val visited = Array(N){Array(N){-1}}

        for(i in 0 until pickList.size){
            if(pickList[i]){
                q.add(Pair(virusList[i].first, virusList[i].second))
                visited[virusList[i].first][virusList[i].second] = 0
            }
        }

        for(i in 0 until N){
            for(j in 0 until N){
                val t = arr[i][j]
                if(t == 1) {
                    visited[i][j] = Int.MAX_VALUE
                }
            }
        }

        while (q.isNotEmpty()){
            val p = q.poll()
            for(i in 0..3){
                val vy = p.first + dy[i]
                val vx = p.second + dx[i]

                if(vy < 0 || vy >= N || vx < 0 || vx >= N || visited[vy][vx] > -1) continue
                q.add(Pair(vy, vx))
                visited[vy][vx] = visited[p.first][p.second] + 1
            }
        }

        var ans = -1
        loop@for(i in 0 until N){
            for(j in 0 until N){
                if(arr[i][j] == 2){
                    ans = max(ans, 0)
                } else if(visited[i][j] == Int.MAX_VALUE){
                    continue
                } else if(visited[i][j] == -1){
                    return -1
                }else {
                    val t = visited[i][j]
                    ans = max(ans, t)
                }
            }
        }

        return ans
    }
}