package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

object BOJ14502 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var y = 0
    var x = 0
    var arr = Array(y){Array(x){0}}
    var arr2 = Array(y){Array(x){0}}

    val emptyList = ArrayList<Pair<Int, Int>>()
    val virusList = ArrayList<Pair<Int, Int>>()

    val dy = arrayOf(0, 0, 1, -1)
    val dx = arrayOf(1, -1, 0, 0)

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        y = st.nextToken().toInt()
        x = st.nextToken().toInt()

        arr = Array(y){Array(x){0}}
        arr2 = Array(y){Array(x){0}}

        for(i in 0 until y){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until x){
                val t = st2.nextToken().toInt()
                if(t == 0){
                    emptyList.add(Pair(i, j))
                }else if(t == 2) {
                    virusList.add(Pair(i, j))
                }
                arr[i][j] = t
            }
        }

        val isVisited = Array(emptyList.size){false}

        var ans = 0

        fun dfs(n: Int, start: Int){

            if(n == 3){
                for(i in 0 until y){
                    for(j in 0 until x){
                        arr2[i][j] = arr[i][j]
                    }
                }
                for (i in 0 until isVisited.size){
                    if(isVisited[i]){
                        val t = emptyList[i]
                        arr2[t.first][t.second] = 1
                    }
                }
                ans = max(bfs(), ans)
                return
            }

            for(i in start until emptyList.size){
                if(!isVisited[i]){
                    isVisited[i] = true
                    dfs(n + 1, i)
                    isVisited[i] = false
                }
            }
        }

        dfs(0, 0)

        bw.write("$ans")

        bw.flush()
        bw.close()
    }

    fun bfs(): Int {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        val visited = Array(y){Array(x){false}}
        var result = 0

        for(virus in virusList){
            q.add(Pair(virus.first, virus.second))
            visited[virus.first][virus.second] = true
            while (q.isNotEmpty()){
                val p = q.poll()
                for(i in 0..3){
                    val vy = p.first + dy[i]
                    val vx = p.second + dx[i]

                    if(vy < 0 || vy >= y || vx < 0 || vx >= x || visited[vy][vx]) continue
                    if(arr2[vy][vx] != 0) continue

                    q.add(Pair(vy, vx))
                    visited[vy][vx] = true
                    arr2[vy][vx] = 2
                }
            }
        }

        for(i in 0 until y){
            for(j in 0 until x){
                val t = arr2[i][j]
                if(t == 0) result++
            }
        }
        return result
    }
}