package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ2146 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        val arr = Array(num){Array(num){0}}
        val visit = Array(num){Array(num){0}}
        val isEdge = Array(num){Array(num){0}}

        for(i in 0 until num) {
            val st2 = StringTokenizer(br.readLine())
            for (j in 0 until num) {
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        val vy = arrayOf(0, 0, 1, -1)
        val vx = arrayOf(1, -1, 0, 0)
        val q: Queue<Pair<Int, Int>> = LinkedList()

        for(i in 0 until num) {
            for (j in 0 until num) {
                if(arr[i][j] == 1 && visit[i][j] == 0){

                    q.add(Pair(i, j))
                    visit[i][j]
                    while(q.isNotEmpty()) {
                        val p = q.poll()
                        for (k in 0..3) {
                            val dy = p.first + vy[k]
                            val dx = p.second + vx[k]

                            if(dy < 0 || dx >= num || dx < 0 || dx >= num) continue
                            if(visit[dy][dx] == 1 || arr[dy][dx] == 0) continue

                            q.add(Pair(dy, dx))
                            visit[dy][dx] = 1
                        }
                    }
                }
            }
        }

        for(i in 0 until num) {
            for (j in 0 until num) {
                print(visit[i][j])
            }
            println()
        }


        bw.flush()
        bw.close()
    }
}