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

        val visit = Array(5){Array(5){false}}
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

        fun func1(c: Int, ty: Int, tx: Int){
            if(c == 7){
                //var countY = 0

                var countS = 0
                for(i in 0 until check.size){
                    //if(check[i] == 'Y') countY++
                    if(check[i] == 'S') countS++
                }
                if(countS >= 4){
//                    println("!!")
                    val f = dfs(checkPath[0][0] - '0', checkPath[0][1] - '0')
                    if(f == 6){
                        superResult++
                    }
                }
                return
            }
            for(i in 0..4){
                for(j in 0..4){
                    if(!visit[i][j]){
                        visit[i][j] = true
                        check[c] = arr[i][j]
                        checkPath[c] = "$i$j"
                        if(j == 4) {
                            func1(c+1, i+1, 0)
                        }else {
                            func1(c+1, i, j+1)
                        }

                        visit[i][j] = false
                    }
                }
            }
        }

        func1(0, 0, 0)

        bw.write("$superResult")

        bw.flush()
        bw.close()
    }
}