package boj.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ10026 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val num = st.nextToken().toInt()
        val arr = Array(num){Array(num){'x'}}
        var visit = Array(num){Array(num){0}}

        for(i in 0 until num){
            val line = br.readLine()
            for(j in line.indices) {
                arr[i][j] = line[j]
            }
        }

        val vx = arrayOf(1, -1, 0, 0)
        val vy = arrayOf(0, 0, 1, -1)

        val q: Queue<Triple<Int, Int, Char>> = LinkedList()
        q.add(Triple(0, 0, arr[0][0]))
        visit[0][0] = 1

        var total = 1

        for(i in 0 until num){
            for(j in 0 until num){
                if(visit[i][j] == 0){
                    q.add(Triple(i, j, arr[i][j]))
                    total++
                }

                while (q.isNotEmpty()){
                    val pick = q.poll()
                    for(i in 0..3){
                        val ty = pick.first + vy[i]
                        val tx = pick.second + vx[i]

                        if(ty < 0 || ty >= num || tx < 0 || tx >= num) continue
                        if(visit[ty][tx] == 1) continue
                        if(pick.third != arr[ty][tx]) continue

                        visit[ty][tx] = 1
                        q.add(Triple(ty, tx, arr[ty][tx]))
                    }
                }
            }
        }

        //val q2: Queue<Triple<Int, Int, Char>> = LinkedList()
        q.clear()
        visit = Array(num){Array(num){0}}

        q.add(Triple(0, 0, arr[0][0]))
        visit[0][0] = 1

        var total2 = 1

        for(i in 0 until num){
            for(j in 0 until num){
                if(visit[i][j] == 0){
                    q.add(Triple(i, j, arr[i][j]))
                    total2++
                }

                while (q.isNotEmpty()){
                    val pick = q.poll()
                    for(i in 0..3){
                        val ty = pick.first + vy[i]
                        val tx = pick.second + vx[i]

                        if(ty < 0 || ty >= num || tx < 0 || tx >= num) continue
                        if(visit[ty][tx] == 1) continue
                        if(pick.third == 'R' || pick.third == 'G'){
                            if(arr[ty][tx] != 'R' && arr[ty][tx] != 'G') continue
                        }
                        else {
                            if(pick.third != arr[ty][tx]) continue
                        }

                        visit[ty][tx] = 1
                        q.add(Triple(ty, tx, arr[ty][tx]))
                    }
                }
            }
        }

        bw.write("$total\n")
        bw.write("$total2\n")

        bw.flush()
        bw.close()
    }
}