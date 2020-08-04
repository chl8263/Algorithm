package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

object BOJ7576 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()

        val arr = Array(m){ Array(n){ 0 } }
        val visit = Array(m){ Array(n){ -1 } }
        val q: Queue<Pair<Int, Int>> = LinkedList()
        for(i in 0 until m){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until n){
                val value = st2.nextToken().toInt()
                if(value == 1) {
                    q.add(Pair(i, j))
                    visit[i][j] = 1
                }else if(value == 0) {
                    visit[i][j] = 0
                }
                arr[i][j] = value
            }
        }

        val dx = arrayOf(1, -1, 0 , 0)
        val dy = arrayOf(0, 0, 1 , -1)

        while (q.isNotEmpty()){
            val peek = q.poll()

            for(i in 0..3){
                val x = peek.first + dx[i]
                val y = peek.second + dy[i]
                if(x < 0 || x >= m) continue
                if(y < 0 || y >= n) continue

                if(arr[x][y] == 0 && visit[x][y] == 0){
                    visit[x][y] = visit[peek.first][peek.second] + 1
                    q.add(Pair(x, y))
                }
            }

        }

        var max = 0
        loop@for(i in 0 until m){
            for(j in 0 until n){
                val t = visit[i][j]
                if(t == 0) {
                    max = 0
                    break@loop
                }
                max = max(max, t)
            }
        }

        bw.write("${max-1}")

        bw.flush()
        bw.close()
    }
}