package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ2178 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        val arr = Array(n){Array(m){0}}
        val visit = Array(n){Array(m){-1}}

        for(i in 0 until n){
            val st2 = br.readLine()
            for(j in st2.indices){
                arr[i][j] = st2[j] - '0'
            }
        }

        val vx = arrayOf(1, -1, 0, 0)
        val vy = arrayOf(0, 0, 1, -1)

        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.add(Pair(0, 0))
        visit[0][0] = 1
        while (q.isNotEmpty()){
            val peek = q.poll()
            for(i in 0..3){
                val x = peek.first + vx[i]
                val y = peek.second + vy[i]
                if(x < 0 || x >= n) continue
                if(y < 0 || y >= m) continue
                if(visit[x][y] == -1 && arr[x][y] != 0){
                    visit[x][y] = visit[peek.first][peek.second] + 1
                    q.add(Pair(x, y))
                }
            }
        }

        bw.write(visit[n-1][m-1].toString())

        bw.flush()
        bw.close()
    }
}