package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

object BOJ13913 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val N = st.nextToken().toInt()
        val K = st.nextToken().toInt()

        val visit = Array(100001){Pair(-1, -1)}
        val q: Queue<Int> = LinkedList()
        q.add(N)
        visit[N] = Pair(0, 0)

        val vx = arrayOf(2, -1 , 1)
        var result = 0
        val list = ArrayList<Int>()
        loop@while(q.isNotEmpty()){
            val p = q.poll()

            for(i in 0..2){
                var visitState = 1
                var dx: Int
                if(i == 0){
                    dx = p * vx[i]
                }else {
                    dx =  p + vx[i]
                }
                if(dx < 0 || dx > 100000) continue
                if(visit[dx].first > -1 && visit[dx].first <= visit[p].first + visitState) continue
                if(dx == K) {
                    if (visit[dx].first > -1) {
                        result = if (visit[dx].first >= visit[p].first + visitState) visit[p].first + visitState
                        else visit[dx].first
                    } else {
                        result = visit[p].first + visitState
                    }

                    list.add(dx)
                    list.add(p)
                    var t = visit[p]
                    while (true){
                        if(t.second == 0) break
                        list.add(t.second)
                        t = visit[t.second]
                    }

                    break@loop
                }
                q.add(dx)
                visit[dx] = Pair(visit[p].first + visitState, p)
            }
        }

        bw.write("$result\n")
        val list2 = list.reversed()
        list2.forEach {
            bw.write("$it ")
        }

        bw.flush()
        bw.close()
    }
}