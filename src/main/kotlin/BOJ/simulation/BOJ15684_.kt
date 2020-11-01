package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ15684_ {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var N = 0
    var M = 0
    var H = 0

    var arr = Array(H+1){Array(N){0}}
    var lineList = Array(H){Array(N-1){false}}
    var lineList2 = Array(H){Array(N-1){false}}
    var lineListVisit = Array(H){Array(N-1){false}}
    var lineListForDfs = Array(H * (N-1)){false}
    var ans = -1

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        N = st.nextToken().toInt()
        M = st.nextToken().toInt()
        H = st.nextToken().toInt()

        arr = Array(H){Array(N){0}}
        lineList = Array(H){Array(N-1){false}}
        lineList2 = Array(H){Array(N-1){false}}
        lineListVisit = Array(H){Array(N-1){false}}
        lineListForDfs = Array(H * (N-1)){false}


        for(i in 0 until M){
            val st2 = StringTokenizer(br.readLine())
            val y = st2.nextToken().toInt() - 1
            val x = st2.nextToken().toInt() - 1
            lineList[y][x] = true
        }

        dfs(0, 0, 0)
        if(ans < 0) dfs(0, 0, 1)
        if(ans < 0) dfs(0, 0, 2)
        if(ans < 0) dfs(0, 0, 3)

        bw.write("$ans")

        bw.flush()
        bw.close()
    }

    fun dfs(start: Int, c: Int, e: Int){
        if(c == e) {

            for(i in 0 until H){
                for(j in 0 until N-1){
                    lineList2[i][j] = lineList[i][j]
                }
            }

            for(i in 0 until lineListForDfs.size){
                if(lineListForDfs[i]){
                    val y = i / (N - 1)
                    val x = i % (N - 1)
                    if(lineList2[y][x]) return
                    else lineList2[y][x] = true
                }
            }

            if(ans == -1 && bfs()) ans = e

            return
        }
        for(i in start until lineListForDfs.size){
            if(lineListForDfs[i]) continue
            lineListForDfs[i] = true
            dfs(i, c + 1, e)
            lineListForDfs[i] = false
        }
    }

    val dy = arrayOf(1, 0, 0)
    val dx = arrayOf(0, -1, 1)
    fun bfs(): Boolean {
        for(i in 0 until N){
            var result = 0
            val q: Queue<Pair<Int, Int>> =  LinkedList()
            q.add(Pair(0, i))
            lineListVisit = Array(H){Array(N-1){false}}
            while (q.isNotEmpty()){
                val p = q.poll()
                var num = 0
                if(p.second < N-1 && lineList2[p.first][p.second] && !lineListVisit[p.first][p.second]) {
                    lineListVisit[p.first][p.second] = true
                    num = 2
                }
                else if(p.second < N && p.second - 1 >= 0 && lineList2[p.first][p.second - 1] && !lineListVisit[p.first][p.second - 1]) {
                    lineListVisit[p.first][p.second - 1] = true
                    num = 1
                }

                val vy = p.first + dy[num]
                val vx = p.second + dx[num]
                if(vy == H) {
                    result = p.second
                    break
                }
                if(vy < 0 || vy >= H || vx < 0 || vx >= N) continue

                q.add(Pair(vy, vx))
            }
            if(result != i) return false
        }
        return true
    }
}