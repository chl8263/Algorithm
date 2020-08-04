package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

object BOJ2583 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val y = st.nextToken().toInt()
        val x = st.nextToken().toInt()
        val arr = Array(y){Array(x){0}}
        val visit = Array(y){Array(x){0}}

        val num = st.nextToken().toInt()
        var fx: Int
        var fy: Int
        var tx: Int
        var ty: Int

        for(i in 1..num){
            val st2 = StringTokenizer(br.readLine())
            fx = st2.nextToken().toInt()
            fy = st2.nextToken().toInt()
            tx = st2.nextToken().toInt()
            ty = st2.nextToken().toInt()

            for(i in fy until ty){
                for(j in fx until tx){
                    arr[i][j] = -1
                    visit[i][j] = -1
                }
            }
        }

        val q: Queue<Pair<Int, Int>> = LinkedList()
        val vx = arrayOf(1, -1, 0, 0)
        val vy = arrayOf(0, 0, 1, -1)
        val list = ArrayList<Int>()
        var result = 0
        for(i in 0 until y){
            for(j in 0 until x){
                if(visit[i][j] == 0){
                    q.add(Pair(i, j))
                    visit[i][j] = 1
                    result ++
                }

                var cnt = 0
                while(q.isNotEmpty()){
                    val pick = q.poll()
                    cnt++
                    for(i in 0..3){
                        val tx = pick.second + vx[i]
                        val ty = pick.first + vy[i]
                        if(tx < 0 || tx >= x || ty < 0 || ty >= y) continue
                        if(visit[ty][tx] == 1 || arr[ty][tx] == -1) continue
                        q.add(Pair(ty, tx))
                        visit[ty][tx] = 1

                    }
                }
                if(cnt != 0) list.add(cnt)
            }
        }

        bw.write("${result}\n")
        list.sort()
        list.forEach { bw.write("${it} ") }

        bw.flush()
        bw.close()
    }
}