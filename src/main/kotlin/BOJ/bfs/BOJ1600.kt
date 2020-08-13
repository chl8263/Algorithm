package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ1600 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val st2 = StringTokenizer(br.readLine())
        val K = st.nextToken().toInt()
        val W = st2.nextToken().toInt()
        val H = st2.nextToken().toInt()

        val arr = Array(H){Array(W){-1}}
        val visit = Array(H){Array(W){Array(K+1){false}}}

        for(i in 0 until H){
            val st3 = StringTokenizer(br.readLine())
            for(j in 0 until W){
                arr[i][j] = st3.nextToken().toInt()
            }
        }

        val vx = arrayOf(0, 0, -1, 1, 2,  2, -2, -2, 1, -1,  1, -1) // 12
        val vy = arrayOf(-1, 1, 0, 0, 1, -1,  1, -1, 2,  2, -2, -2) // 12

        val q: Queue<Hor> = LinkedList()
        q.add(Hor(0, 0, 0, 0))
        visit[0][0][0] = true

        var result = -1
        loop@while(q.isNotEmpty()){
            val p = q.poll()
            for(i in 0..11){
                if(i > 3 && p.hor >= K) continue
                val t_break = if(i > 3) 1 else 0
                val dy = p.y + vy[i]
                val dx = p.x + vx[i]

                if(dy < 0 || dy >= H || dx < 0 || dx >= W) continue
                if(arr[dy][dx] == 1) continue
                if(i > 3 && visit[dy][dx][p.hor + 1]) continue
                if(i <= 3 && visit[dy][dx][p.hor]) continue

                if(dy == H-1 && dx == W-1){
                    result = p.cnt + 1
                    break@loop
                }

                q.add(Hor(dy, dx, p.cnt + 1, p.hor + t_break))
                visit[dy][dx][p.hor + t_break] = true
            }
        }

        bw.write("$result\n")

//        for(i in 0 until H){
//            for(j in 0 until W){
//                print(arr[i][j])
//            }
//            println()
//        }
//
//        println()
//
//        for(i in 0 until H){
//            for(j in 0 until W){
//                print(visit[i][j])
//            }
//            println()
//        }

        bw.flush()
        bw.close()
    }

    data class Hor(
        var y: Int,
        var x: Int,
        var cnt: Int,
        var hor: Int
    )
}