package BOJ.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ1941 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))

        val arr = Array(5){Array(5){'x'}}
        for(i in 0 until 5){
            val st = br.readLine()
            for(j in 0 until 5){
                arr[i][j] = st[j]
            }
        }

        val visit = Array(25){false}
        val check = Array(7){'x'}
        val checkPath = Array(7){"x"}

        val dy = arrayOf(0, 0, 1, -1)
        val dx = arrayOf(1, -1, 0, 0)

        fun dfs (y: Int, x: Int): Int{

            val q: Queue<Pair<Int, Int>> = LinkedList()
            val dfsVisit = Array(5){Array(5){false}}
            var result = 0
            q.add(Pair(y, x))
            dfsVisit[y][x] = true

            while(q.isNotEmpty()){
                val peek = q.poll()

                for(i in 0..3){
                    val vy = peek.first + dy[i]
                    val vx = peek.second + dx[i]
                    if(vy < 0 || vy >= 5 || vx < 0 || vx >= 5) continue
                    if(dfsVisit[vy][vx]) continue
                    val tt = "$vy$vx"
                    if(checkPath.contains(tt)){
                        dfsVisit[vy][vx] = true
                        q.add(Pair(vy, vx))
                        result++
                    }
                }
            }
            return result
        }

        var superResult = 0

        fun func1(c: Int, start: Int){
            if(c == 7){
                var countS = 0
                for(i in 0 until check.size){
                    if(check[i] == 'S') countS++
                }
                if(countS >= 4){
                    val f = dfs(checkPath[0][0] - '0', checkPath[0][1] - '0')
                    if(f == 6){
                        superResult++
                    }
                }
                return
            }
            for(i in start..24){
                val tx = i / 5
                val ty = i % 5
                if(!visit[i]){
                    visit[i] = true
                    check[c] = arr[ty][tx]
                    checkPath[c] = "$ty$tx"
                    func1(c+1, i+1)
                    visit[i] = false
                }
            }
        }

        func1(0, 0)

        bw.write("$superResult")

        bw.flush()
        bw.close()
    }
}