package boj.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ7562 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val case = st.nextToken().toInt()

        val vy = arrayOf(1, -1,  1, -1, 2,  2, -2, -2)
        val vx = arrayOf(2,  2, -2, -2, 1, -1,  1, -1)

        for(i in 1..case){
            val st2 = StringTokenizer(br.readLine())
            val st3 = StringTokenizer(br.readLine())
            val st4 = StringTokenizer(br.readLine())

            val width = st2.nextToken().toInt()
            val arr = Array(width){Array(width){-1}}

            val fx = st3.nextToken().toInt()
            val fy = st3.nextToken().toInt()

            val tx = st4.nextToken().toInt()
            val ty = st4.nextToken().toInt()

            val q: Queue<Pair<Int, Int>> = LinkedList()
            arr[fy][fx] = 0
            q.add(Pair(fy, fx))

            var result = 0

            loop@while (q.isNotEmpty()){
                val first = q.poll()
                for(i in 0..7){
                    val tty = first.first + vy[i]
                    val ttx = first.second + vx[i]
                    if(tty < 0 || tty >= width || ttx < 0 || ttx >= width) continue
                    if(arr[tty][ttx] > -1) continue
                    if(tty == ty && ttx == tx){
                        result = arr[first.first][first.second] + 1
                        break@loop
                    }
                    q.add(Pair(tty, ttx))
                    arr[tty][ttx] = arr[first.first][first.second] + 1
                }
            }

            bw.write("$result\n")
        }

        bw.flush()
        bw.close()
    }
}