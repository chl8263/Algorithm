package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

object BOJ7569 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        val z = st.nextToken().toInt()

        val arr = Array(z){Array(y){Array(x){-1}}}
        val visit = Array(z){Array(y){Array(x){0}}}
        val q: Queue<Triple<Int, Int, Int>> = LinkedList()

        val vx = arrayOf(1, -1, 0, 0)
        val vy = arrayOf(0, 0, 1, -1)
        val vz = arrayOf(1, -1)

        for(z in 0 until z){
            for(y in 0 until y){
                val st2 = StringTokenizer(br.readLine())
                for(x in 0 until x){
                    val k = st2.nextToken().toInt()
                    arr[z][y][x] = k
                    if(k == 1) {
                        visit[z][y][x] = 1
                        q.add(Triple(z, y, x))
                    }else if(k == -1){
                        visit[z][y][x] = -1
                    }
                }
            }
        }

        while (q.isNotEmpty()){
            val head = q.poll()
            for(i in 0..3){
                val dx = head.third + vx[i]
                val dy = head.second + vy[i]
                if(dx < 0 || dx >= x || dy < 0 || dy >= y) continue
                if(visit[head.first][dy][dx] == 0 && arr[head.first][dy][dx] == 0){
                    visit[head.first][dy][dx] = visit[head.first][head.second][head.third] + 1
                    q.add(Triple(head.first, dy, dx))
                }
            }
            for(i in 0..1){
                val dz = head.first + vz[i]
                if(dz < 0 || dz >= z) continue
                if(visit[dz][head.second][head.third] == 0 && arr[dz][head.second][head.third] == 0){
                    visit[dz][head.second][head.third] = visit[head.first][head.second][head.third] + 1
                    q.add(Triple(dz, head.second, head.third))
                }
            }
        }

        var max = 0
        loop@for(z in 0 until z){
            for(y in 0 until y){
                for(x in 0 until x){
                    val k = visit[z][y][x]
                    if(k == 0){
                        max = 0
                        break@loop
                    }
                    max = max(max, k)
                }
            }
        }
        bw.write("${max -1}")

        bw.flush()
        bw.close()
    }
}