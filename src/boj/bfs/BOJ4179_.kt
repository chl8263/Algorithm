package boj.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min
/*
* Problem myself of this solve is this I confused x, y in Array
* */
object BOJ4179_ {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val R = st.nextToken().toInt()
        val C = st.nextToken().toInt()

        val arr = Array(R){Array(C){'x'}}
        val fire = Array(R){Array(C){-1}}
        val joe = Array(R){Array(C){-1}}
        val f_q: Queue<Pair<Int, Int>> = LinkedList()
        val f_j: Queue<Pair<Int, Int>> = LinkedList()

        val dx = arrayOf(1, -1, 0, 0)
        val dy = arrayOf(0, 0, 1, -1)

        for(i in 0 until R){
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
                val y = peek.first + dy[i]
                val x = peek.second + dx[i]
                if(x < 0 || x >= C || y < 0 || y >= R) continue
                if(arr[y][x] == '#') continue
                if(fire[y][x] == -1) {
                    fire[y][x] = fire[peek.first][peek.second] + 1
                    f_q.add(Pair(y, x))
                }
            }
        }

        while (f_j.isNotEmpty()){
            val peek = f_j.poll()
            for(i in 0..3){
                if(peek.first < 0 || peek.first >= C || peek.second < 0 || peek.second >= R){

                }
                val y = peek.first + dy[i]
                val x = peek.second + dx[i]
                if(x < 0 || x >= C || y < 0 || y >= R &&
                    fire[peek.first][peek.second] > joe[peek.first][peek.second]) {
                    bw.write("${joe[peek.first][peek.second] + 1}")
                    bw.flush()
                    bw.close()
                    return
                }
                if(joe[y][x] >= 0 || arr[y][x] == '#') continue
                if(fire[y][x] != -1 && fire[y][x] <= joe[peek.first][peek.second] + 1) continue
                joe[y][x] = joe[peek.first][peek.second] + 1
                f_j.add(Pair(y, x))
            }
        }

        bw.write("IMPOSSIBLE")

        bw.flush()
        bw.close()
    }
}