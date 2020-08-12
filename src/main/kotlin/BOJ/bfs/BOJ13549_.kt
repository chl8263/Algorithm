package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ13549_ {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val N = st.nextToken().toInt()
        val K = st.nextToken().toInt()

        val visit = Array(100001){-1}
        val q: Queue<Int> = LinkedList()
        q.add(N)
        visit[N] = 0
        /*
        * The original -> val vx = arrayOf(2, -1 , 1)
        * The calculate order change *2 , -1, +1, then pass.. should thinking more about order
        * */
        val vx = arrayOf(2, -1 , 1)
        var result = 0
        loop@while(q.isNotEmpty()){
            val p = q.poll()

            for(i in 0..2){
                var visitState = 0
                var dx: Int
                if(i == 0){
                    dx = p * vx[i]
                }else {
                    dx =  p + vx[i]
                    visitState = 1
                }
                if(dx < 0 || dx > 100000) continue
                if(visit[dx] > -1 && visit[dx] <= visit[p] + visitState) continue
                if(dx == K) {
                    if (visit[dx] > -1) {
                        result = if (visit[dx] >= visit[p] + visitState) visit[p] + visitState
                        else visit[dx]
                    } else {
                        result = visit[p] + visitState
                    }
                    break@loop
                }
                q.add(dx)
                visit[dx] = visit[p] + visitState
            }
        }

        bw.write("$result")

        bw.flush()
        bw.close()
    }
}