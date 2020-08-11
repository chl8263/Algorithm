package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ6593 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))

        while(true) {
            val st = StringTokenizer(br.readLine())
            val L = st.nextToken().toInt()
            val Y = st.nextToken().toInt()
            val X = st.nextToken().toInt()
            if(L == 0 && Y == 0 && X == 0) break

            val arr = Array(L){Array(Y){Array(X){'x'}}}
            val visit = Array(L){Array(Y){Array(X){-1}}}
            val q: Queue<Triple<Int, Int, Int>> = LinkedList()
            for(l in 0 until L){
                for(y in 0 until Y){
                    val st2 = br.readLine()
                    for(x in 0 until X){
                        arr[l][y][x] = st2[x]
                        if(st2[x] == 'S') {
                            q.add(Triple(l, y, x))
                            visit[l][y][x] = 1
                        }else if(st2[x] == '.' || st2[x] == 'E') {
                            visit[l][y][x] = 0
                        }
                    }
                }
                br.readLine()
            }

            val vl = arrayOf(1, -1, 0, 0, 0, 0)
            val vy = arrayOf(0, 0, 0, 0, 1, -1)
            val vx = arrayOf(0, 0, 1, -1, 0, 0)
            var result = -1
            sub@while (q.isNotEmpty()) {
                val p = q.poll()
                for (i in 0..5) {
                    val dl = p.first + vl[i]
                    val dy = p.second + vy[i]
                    val dx = p.third + vx[i]

                    if (dl < 0 || dl >= L || dy < 0 || dy >= Y || dx < 0 || dx >= X) continue
                    if (visit[dl][dy][dx] == -1 || visit[dl][dy][dx] > 0) continue
                    if(arr[dl][dy][dx] == 'E') {
                        result = visit[p.first][p.second][p.third]
                        break@sub
                    }
                    q.add(Triple(dl, dy, dx))
                    visit[dl][dy][dx] = visit[p.first][p.second][p.third] + 1

                }
            }

            if(result != -1) bw.write("Escaped in $result minute(s).\n")
            else bw.write("Trapped!\n")
        }

        bw.flush()
        bw.close()
    }
}