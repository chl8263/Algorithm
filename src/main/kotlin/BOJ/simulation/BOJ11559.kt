package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

object BOJ11559 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var arr = Array(12){Array(6){'.'}}

    @JvmStatic
    fun main(args: Array<String>){


        for(i in 0 until 12){
            val st = br.readLine()
            for(j in 0 until 6){
                val literal = st[j]
                if(literal != '.'){
                    arr[i][j] = literal
                }
            }
        }

        val vy = arrayOf(0, 0, 1, -1)
        val vx = arrayOf(1, -1, 0, 0)

        var ans = 0
        var flag = true
        while (flag) {
            flag = false
            var result = 0
            var puyoList = ArrayList<Pair<Int, Int>>()
            var isVisit = Array(12){Array(6){false}}

            for (i in 0 until 12) {
                for (j in 0 until 6) {
                    if (arr[i][j] != '.') {
                        puyoList.add(Pair(i, j))
                    }
                }
            }

            for (puyo in puyoList) {
                if (isVisit[puyo.first][puyo.second]) continue

                var color = arr[puyo.first][puyo.second]

                var q: Queue<Pair<Int, Int>> = LinkedList()
                var tempList = ArrayList<Pair<Int, Int>>()

                q.add(Pair(puyo.first, puyo.second))
                isVisit[puyo.first][puyo.second] = true
                tempList.add(Pair(puyo.first, puyo.second))

                while (q.isNotEmpty()) {
                    val p = q.poll()
                    for (i in 0..3) {
                        val dy = p.first + vy[i]
                        val dx = p.second + vx[i]
                        if (dy < 0 || dy >= 12 || dx < 0 || dx >= 6) continue
                        if(isVisit[dy][dx] || color != arr[dy][dx]) continue
                        q.add(Pair(dy, dx))
                        tempList.add(Pair(dy, dx))
                        isVisit[dy][dx] = true
                    }
                }
                if (tempList.size >= 4) {
                    flag = true
                    if(result != 1) result++
                    for (t in tempList) {
                        arr[t.first][t.second] = '.'
                    }
                }
            }

            ans+=result

            fallDown()
        }

        println("$ans")

        bw.flush()
        bw.close()
    }

    fun fallDown(){
        for (i in 0 until 6) {
            var index = 11
            val t = Array(12){'.'}
            for (j in 11 downTo 0) {
                if (arr[j][i] != '.') {
                    t[index--] = arr[j][i]
                }
            }
            for (j in 11 downTo 0) {
                arr[j][i] = t[j]
            }
        }
    }
}