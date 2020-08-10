package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min

object BOJ2146 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        val arr = Array(num){Array(num){0}}
        val visit = Array(num){Array(num){Triple(0, 0, 0)}}
        val edgeList = ArrayList<Triple<Int, Int, Int>>()

        for(i in 0 until num) {
            val st2 = StringTokenizer(br.readLine())
            for (j in 0 until num) {
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        val vy = arrayOf(0, 0, 1, -1)
        val vx = arrayOf(1, -1, 0, 0)
        val q: Queue<Pair<Int, Int>> = LinkedList()

        var landNumber = 1
        for(i in 0 until num) {
            for (j in 0 until num) {
                if(arr[i][j] == 1 && visit[i][j].first == 0){

                    q.add(Pair(i, j))
                    visit[i][j] = visit[i][j].copy(first = 1)

                    while(q.isNotEmpty()) {
                        val p = q.poll()
                        for (k in 0..3) {
                            val dy = p.first + vy[k]
                            val dx = p.second + vx[k]

                            if(dy < 0 || dy >= num || dx < 0 || dx >= num || arr[dy][dx] == 0) {
                                if(edgeList.firstOrNull { x -> x.first == p.first && x.second == p.second } == null){
                                    edgeList.add(Triple(p.first, p.second, landNumber))
                                    visit[p.first][p.second] = visit[p.first][p.second].copy(second = 1, third = landNumber)
                                }
                                continue
                            }
                            if(visit[dy][dx].first == 1) continue

                            q.add(Pair(dy, dx))
                            visit[dy][dx] = visit[dy][dx].copy(first = 1)
                        }
                    }
                    landNumber++
                }
            }
        }

        var result = Int.MAX_VALUE
        for(x in edgeList){

            val land = x.third
            val q2: Queue<Pair<Int, Int>> = LinkedList()
            val visit2 = Array(num){Array(num){Pair(0, 0)}}
            q2.add(Pair(x.first, x.second))
            visit2[x.first][x.second] = Pair(1, 0)
            while (q2.isNotEmpty()){
                val p = q2.poll()
                for(i in 0..3) {
                    val dy = p.first + vy[i]
                    val dx = p.second + vx[i]

                    if (dy < 0 || dy >= num || dx < 0 || dx >= num ) continue

                    if(visit[dy][dx].second == 1) {
                        if(visit[dy][dx].third != land){
                            result = min(result, visit2[p.first][p.second].second)
                            visit2[dy][dx] = visit2[dy][dx].copy(first = 1)
                        }
                        else {
                            visit2[dy][dx] = visit2[dy][dx].copy(first = 1)
                        }
                        continue
                    }
                    if(arr[dy][dx] == 1 || visit2[dy][dx].first == 1) continue

                    q2.add(Pair(dy, dx))
                    val temp = visit2[p.first][p.second]
                    visit2[dy][dx] = visit2[dy][dx].copy(first = 1, second = temp.second + 1)
                }
            }
        }

        bw.write("$result")

        bw.flush()
        bw.close()
    }
}