package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ2206___ {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val y = st.nextToken().toInt()
        val x = st.nextToken().toInt()

        val arr = Array(y){Array(x){0}}
        val visit = Array(y){Array(x){0}}

        for(i in 0 until y){
            val st2 = br.readLine()
            for(j in st2.indices){
                arr[i][j] = st2[j] - '0'
                visit[i][j] = Int.MAX_VALUE
            }
        }

        var ans = Int.MAX_VALUE
        val vx = arrayOf(1, -1, 0, 0)
        val vy = arrayOf(0, 0, 1, -1)
        val q: Queue<Place> = LinkedList()
        q.add(Place(0, 0, 1, 0))
        visit[0][0] = 0

        while(q.isNotEmpty()){
            val p = q.poll()
            if(p.y == y-1 && p.x == x-1){
                ans = p.dis
                break
            }
            for(i in 0..3){
                val dy = p.y + vy[i]
                val dx = p.x + vx[i]
                if(dy < 0 || dy >= y || dx < 0 || dx >= x) continue
                if(visit[dy][dx] <= p.drill) continue
                if(arr[dy][dx] == 0){
                    visit[dy][dx] = p.drill
                    q.add(Place(dy, dx, p.dis+1, p.drill))
                }else {
                    if(p.drill == 0){
                        visit[dy][dx] = p.drill+1
                        q.add(Place(dy, dx, p.dis+1, p.drill+1))
                    }
                }
            }
        }

        if(ans == Int.MAX_VALUE) bw.write("-1")
        else bw.write("$ans")


        bw.flush()
        bw.close()
    }

    data class Place(
        var y: Int,
        var x: Int,
        var dis: Int,
        var drill: Int
    )
}