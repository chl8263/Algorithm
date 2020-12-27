package boj.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ15685 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val arr = Array(104){Array(104){false}}
    val dy = arrayOf(0, -1, 0, 1)
    val dx = arrayOf(1, 0, -1, 0)

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        for(i in 1..num){
            val st2 = StringTokenizer(br.readLine())
            val x = st2.nextToken().toInt()
            val y = st2.nextToken().toInt()
            val direction = st2.nextToken().toInt()
            val generation = st2.nextToken().toInt()

            arr[y][x] = true
            val vy = y + dy[direction]
            val vx = x + dx[direction]
            arr[vy][vx] = true
            val gList = ArrayList<Int>()
            gList.add(direction)

            var matrix = Pair(vy, vx)
            for(g in 1..generation){
                for(j in gList.size - 1 downTo 0){
                    val newD = (gList[j] + 4 + 1) % 4
                    gList.add(newD)
                    val newY = matrix.first + dy[newD]
                    val newX = matrix.second + dx[newD]
                    arr[newY][newX] = true
                    matrix = Pair(newY, newX)
                }
            }
        }

        var ans = 0

        for(i in 0..100){
            for(j in 0..100){
                if(arr[i][j] && arr[i][j+1] && arr[i+1][j] && arr[i+1][j+1]) ans++
            }
        }

        bw.write("$ans")

        bw.flush()
        bw.close()
    }
}