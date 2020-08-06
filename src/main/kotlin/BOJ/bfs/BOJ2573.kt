package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

object BOJ2573 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val y = st.nextToken().toInt()
        val x = st.nextToken().toInt()
        var arr = Array(y){Array(x){0}}
        var after = Array(y){Array(x){0}}

        for(i in 0 until y){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until x){
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        val vy = arrayOf(0, 0, 1, -1)
        val vx = arrayOf(1, -1, 0, 0)

        var solvable = false
        var mainCnt = 0
        loop@while (true) {
            var maxInMatrix = 0
            mainCnt++
            for (i in 1 until y) {
                for (j in 1 until x) {
                    var cnt = 0
                    for (k in 0..3) {
                        val cy = i + vy[k]
                        val cx = j + vx[k]
                        if (cy < 0 || cy >= y || cx < 0 || cx >= x) continue
                        if (arr[cy][cx] == 0) cnt++
                    }

                    after[i][j] = arr[i][j] - cnt
                    if (after[i][j] < 0) after[i][j] = 0
                    maxInMatrix = max(maxInMatrix, after[i][j])
                }
            }
            if(maxInMatrix == 0) break@loop
            arr = after
            after = Array(y){ Array(x) { 0 } }

            var innerCnt = 0
            var visit = Array(y){Array(x){0}}
            for (i in 1 until y) {
                for (j in 1 until x) {
                    if (visit[i][j] == 0 && arr[i][j] > 0) {
                        val q: Queue<Pair<Int, Int>> = LinkedList()
                        q.add(Pair(i, j))
                        visit[i][j] = 1

                        while (q.isNotEmpty()) {
                            val p = q.poll()
                            for (k in 0..3) {
                                val cy = p.first + vy[k]
                                val cx = p.second + vx[k]
                                if (cy < 0 || cy >= y - 1 || cx < 0 || cx >= x - 1) continue
                                if (visit[cy][cx] == 1 || arr[cy][cx] == 0) continue
                                q.add(Pair(cy, cx))
                                visit[cy][cx] = 1
                            }
                        }
                        innerCnt++
                    }
                }
            }
            if(innerCnt >= 2) {
                solvable = true
                break@loop
            }
        }

        if(!solvable) bw.write("0")
        else bw.write("$mainCnt")

        bw.flush()
        bw.close()
    }
}