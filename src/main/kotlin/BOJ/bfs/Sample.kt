package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


object Sample {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))

        val board = Array(502){Array(502){0}}
        val n = 7
        val m = 10
        val dx = arrayOf(1, -1, 0, 0)
        val dy = arrayOf(0, 0, 1, -1)

        board[0][0] = 1; board[0][1] = 1; board[0][2] = 1; board[0][4] = 1
        board[1][0] = 1; board[1][4] = 1
        board[2][0] = 1; board[2][1] = 1; board[2][2] = 1; board[2][4] = 1
        board[3][0] = 1; board[3][1] = 1; board[3][4] = 1
        board[4][1] = 1

        for(i in 0 until n){
            for(j in 0 until m){
                bw.write("${board[i][j]} ")
            }
            bw.write("\n")
        }

        val visit = Array(502){Array(502){0}}
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.add(Pair(0,0))
        visit[0][0] = 1

        bw.write("\n")

        for(i in 0 until n){
            for(j in 0 until m){
                bw.write("${visit[i][j]} ")
            }
            bw.write("\n")
        }

        bw.write("\n")

        while (q.isNotEmpty()){
            val curr = q.poll()
            for(i in 0..3){
                val x = curr.first + dx[i]
                val y = curr.second + dy[i]
                if(x < 0 || x >= m || y < 0 || y >= n) continue
                if(board[x][y] != 1 || visit[x][y] == 1) continue
                visit[x][y] = 1
                q.add(Pair(x,y))
            }
        }

        for(i in 0 until n){
            for(j in 0 until m){
                bw.write("${visit[i][j]} ")
            }
            bw.write("\n")
        }

        bw.flush()
        bw.close()
    }
}