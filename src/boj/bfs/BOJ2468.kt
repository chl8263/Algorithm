package boj.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max
import kotlin.math.min

object BOJ2468 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num =  st.nextToken().toInt()

        val arr = Array(num){Array(num){0}}

        var min = -1
        var max = -1
        var result = 0
        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until num){
                val t = st2.nextToken().toInt()
                arr[i][j] = t
                min = if(min == -1) t
                else min(t, min)
                max = if(max == -1) t
                else max(t, max)
            }
        }

        val vy = arrayOf(0, 0, -1, 1)
        val vx = arrayOf(-1, 1, 0, 0)

        for(k in min..max){
            val visit = Array(num){Array(num){0}}
            val q: Queue<Pair<Int,Int>> = LinkedList()
            var tempResult = 0

            for(i in 0 until num){
                for(j in 0 until num){
                    if(visit[i][j] != 1 && arr[i][j] > k) {
                        var tmp = 0
                        q.add(Pair(i, j))
                        visit[i][j] = 1
                        while (q.isNotEmpty()) {
                            tmp ++
                            val p = q.poll()
                            for (u in 0..3) {
                                val dy = p.first + vy[u]
                                val dx = p.second + vx[u]

                                if (dy < 0 || dy >= num || dx < 0 || dx >= num) continue
                                if (visit[dy][dx] == 1 || arr[dy][dx] <= k ) continue
                                q.add(Pair(dy, dx))
                                visit[dy][dx] = 1
                            }
                        }
                        if(tmp != 0) tempResult++
                    }
                }
            }
            result = max(result, tempResult)
            if(result == 0) result = 1
        }

        bw.write("$result")

        bw.flush()
        bw.close()
    }
}