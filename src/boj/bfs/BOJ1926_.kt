package boj.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

object BOJ1926_ {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()

        val arr = Array(n){Array(m){0}}
        val visit = Array(n){Array(m){0}}
        for(i in 0 until n){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until m){
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        val q: Queue<Pair<Int, Int>> = LinkedList()
        val vx = arrayOf(1, -1, 0 ,0)
        val vy = arrayOf(0, 0, -1 ,1)

        var container = 0
        var maxArea = 0
        for(i in 0 until n){
            for(j in 0 until m){
                if(arr[i][j] == 1 && visit[i][j] == 0){
                    container++
                    var area = 0
                    q.add(Pair(i, j))
                    while (q.isNotEmpty()){
                        area++
                        if(arr[i][j] == 1 && visit[i][j] == 0){
                            visit[i][j] = 1
                        }
                        val peek = q.poll()
                        val x = peek.first
                        val y = peek.second
                        for (k in 0..3){
                            val dx = x + vx[k]
                            val dy = y + vy[k]
                            if(dx < 0 || dx >= n) continue
                            if(dy < 0 || dy >= m) continue
                            if(arr[dx][dy] == 1 && visit[dx][dy] == 0){
                                visit[dx][dy] = 1
                                q.add(Pair(dx, dy))
                            }
                        }
                    }
                    maxArea = max(maxArea, area)
                }
            }
        }

        bw.write("$container\n")
        bw.write("${maxArea}\n")

        bw.flush()
        bw.close()
    }
}