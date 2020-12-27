package boj.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.time.seconds

/*
* Must check how many light can turn on, not how many room can visit
* */
object BOJ11967__ {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()
        val R = st.nextToken().toInt()

        val arr = Array(num){Array(num){Pair(0, ArrayList<Pair<Int, Int>>())}}

        val lightVisit =  Array(num){Array(num){0}}

        for (i in 0 until R){
            val st2 = StringTokenizer(br.readLine())
            val x = st2.nextToken().toInt() -1
            val y = st2.nextToken().toInt() -1
            val a = st2.nextToken().toInt() -1
            val b = st2.nextToken().toInt() -1

            arr[y][x].second.add(Pair(b, a))
        }

        val vx = arrayOf(0, 0, 1, -1)
        val vy = arrayOf(1, -1, 0, 0)

        var result = 1
        lightVisit[0][0] = 1
        arr[0][0] = arr[0][0].copy(first = 1)

        loop@while (true) {

            var researchFlag = false
            val q: Queue<Pair<Int, Int>> = LinkedList()
            val visit =  Array(num){Array(num){0}}
            q.add(Pair(0, 0))
            visit[0][0] = 1

            while (q.isNotEmpty()) {
                val p = q.poll()
                for (light in arr[p.first][p.second].second) {
                    val toX = light.second
                    val toY = light.first
                    if(lightVisit[toY][toX] == 0){
                        lightVisit[toY][toX] = 1
                        arr[toY][toX] = arr[toY][toX].copy(first = 1)
                        researchFlag = true
                        result++
                    }
                }

                if(researchFlag){
                    continue@loop
                }

                for (i in 0..3) {
                    val dx = p.second + vx[i]
                    val dy = p.first + vy[i]

                    if (dx < 0 || dx >= num || dy < 0 || dy >= num) continue
                    if (visit[dy][dx] == 1 || arr[dy][dx].first == 0) continue

                    q.add(Pair(dy, dx))
                    visit[dy][dx] = 1
                }
            }
            if(!researchFlag) {

                break@loop
            }
        }

        bw.write("$result")

        bw.flush()
        bw.close()
    }
}