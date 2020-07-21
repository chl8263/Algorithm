package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min

object BOJ4179 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val m = st.nextToken().toInt()
        val n = st.nextToken().toInt()

        val arr = Array(m){Array(n){'x'}}
        val fire = Array(m){Array(n){-1}}
        val joe = Array(m){Array(n){-1}}
        val f_q: Queue<Pair<Int, Int>> = LinkedList()
        val f_j: Queue<Pair<Int, Int>> = LinkedList()

        val dx = arrayOf(1, -1, 0, 0)
        val dy = arrayOf(0, 0, 1, -1)

        for(i in 0 until m){
            val st2 = br.readLine()
            for(j in st2.indices){
                if(st2[j] == 'F'){
                    f_q.add(Pair(i, j))
                    fire[i][j] = 0
                }
                if(st2[j] == 'J'){
                    f_j.add(Pair(i, j))
                    joe[i][j] = 0
                }
                arr[i][j] = st2[j]
            }
        }

        while (f_q.isNotEmpty()){
            val peek = f_q.poll()
            for(i in 0..3){
                val x = peek.first + dx[i]
                val y = peek.second + dy[i]
                if(x < 0 || x >= n || y < 0 || y >= m) continue
                if(arr[x][y] == '#') continue
                if(fire[x][y] == -1) {
                    fire[x][y] = fire[peek.first][peek.second] + 1
                    f_q.add(Pair(x, y))
                }
            }
        }

        while (f_j.isNotEmpty()){
            val peek = f_j.poll()
            for(i in 0..3){
                val x = peek.first + dx[i]
                val y = peek.second + dy[i]
                if(x < 0 || x >= n || y < 0 || y >= m) continue
                if(arr[x][y] == '#') continue
                if(joe[x][y] == -1) {
                    joe[x][y] = joe[peek.first][peek.second] + 1
                    f_j.add(Pair(x, y))
                }
            }
        }

        var min = -1
        for(i in 0 until m){
            for(j in 0 until n){
                if(i == 0 || i == m-1 || j == 0 || j == n-1){
                    if(joe[i][j] != -1 && joe[i][j] < fire[i][j]){
                        if(min == -1) min = joe[i][j]
                        else min = min(min, joe[i][j])
                    }
                }
            }
        }

        if(min == -1) bw.write("IMPOSSIBLE")
        else bw.write("${min+1}")

        bw.flush()
        bw.close()
    }
}