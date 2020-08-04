package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ1012 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val case = st.nextToken().toInt()

        val vx = arrayOf(1, -1 ,0 ,0)
        val vy = arrayOf(0, 0, 1 ,-1)

        for(i in 0 until case){
            val st2 = StringTokenizer(br.readLine())
            val x = st2.nextToken().toInt()
            val y = st2.nextToken().toInt()
            val checkNum = st2.nextToken().toInt()
            val arr = Array(y){Array(x){0}}
            val visit = Array(y){Array(x){0}}
            for(i in 0 until checkNum){
                val st3 = StringTokenizer(br.readLine())
                val s_x = st3.nextToken().toInt()
                val s_y = st3.nextToken().toInt()
                arr[s_y][s_x] = 1
            }


            var result = 0
            val q: Queue<Pair<Int, Int>> = LinkedList()

            for(i in 0 until y){
                for(j in 0 until x){
                    if(arr[i][j] == 1 && visit[i][j] == 0){
                        q.add(Pair(i, j))
                        visit[i][j] = 1
                        while(q.isNotEmpty()){
                            val peek = q.poll()
                            for(i in 0..3){
                                val rx = peek.second + vx[i]
                                val ry = peek.first + vy[i]
                                if(rx < 0 || rx >= x || ry < 0 || ry >= y) continue
                                if(visit[ry][rx] != 0 || arr[ry][rx] == 0) continue
                                visit[ry][rx] = 1
                                q.add(Pair(ry, rx))
                            }
                        }
                        result++
                    }
                }
            }

            bw.write("$result\n")

        }

        bw.flush()
        bw.close()
    }
}