package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

object BOJ2667 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        val arr = Array(num){Array(num){0}}
        val visit = Array(num){Array(num){0}}
        for(i in 0 until num){
            val line = br.readLine()
            for(j in line.indices){
                arr[i][j] = line[j] - '0'
            }
        }

        val vx = arrayOf(1, -1, 0, 0)
        val vy = arrayOf(0, 0, 1, -1)
        val q: Queue<Pair<Int, Int>> = LinkedList()
        var total = 0
        val cntList = ArrayList<Int>()
        for(i in 0 until num){
            for(j in 0 until num){
                if(visit[i][j] == 0 && arr[i][j] == 1){
                    visit[i][j] = 1
                    q.add(Pair(i, j))
                    total++
                }

                var cnt = 0
                while(q.isNotEmpty()){
                    val first = q.poll()
                    cnt++
                    for(i in 0..3){
                        val ty = first.first + vy[i]
                        val tx = first.second + vx[i]
                        if(ty < 0 || ty >= num || tx < 0 || tx >= num) continue
                        if(visit[ty][tx] == 1 || arr[ty][tx] == 0) continue
                        q.add(Pair(ty, tx))

                        visit[ty][tx] = 1
                    }
                }
                if(cnt > 0) cntList.add(cnt)
            }
        }

        bw.write("$total\n")
        cntList.sort()
        cntList.forEach { bw.write("$it\n") }

        bw.flush()
        bw.close()
    }
}