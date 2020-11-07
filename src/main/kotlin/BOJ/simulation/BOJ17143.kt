package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ17143 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var Y = 0
    var X = 0
    var arr = Array(Y){Array(X){Triple(0, 0, 0)}}

    val dy = arrayOf(-1, 1, 0, 0)
    val dx = arrayOf(0, 0, 1, -1)

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        Y = st.nextToken().toInt()
        X = st.nextToken().toInt()
        arr = Array(Y){Array(X){Triple(0, 0, 0)}}
        var num = st.nextToken().toInt()

        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            val yy = st2.nextToken().toInt() - 1
            val xx = st2.nextToken().toInt() - 1
            val s = st2.nextToken().toInt()
            val d = st2.nextToken().toInt() - 1
            val z = st2.nextToken().toInt()

            arr[yy][xx] = Triple(s, d, z)
        }
        var ans = 0
        for(i in 0 until X){
            loop@for(j in 0 until Y){
                if(arr[i][j].first != 0) {
                    ans += arr[i][j].third
                    arr[i][j] = Triple(0, 0, 0)
                    break@loop
                }
            }
            move()
        }

        bw.write("$ans")

//        for(i in 0 until Y){
//            for(j in 0 until X){
//                print(arr[i][j])
//            }
//            println()
//        }

        bw.flush()
        bw.close()
    }

    fun move(){
        var arr2 = Array(Y){Array(X){Triple(0, 0, 0)}}

        for(i in 0 until Y){
            for(j in 0 until X){
                if(arr[i][j].first == 0) continue

                var location = Pair(i, j)
                val t = arr[i][j]
                val s = t.first
                var d = t.second
                val z = t.third
                var index = 0
                loop@while (true){
                    if(index == s) break@loop
                    val vy = location.first + dy[d]
                    val vx = location.second + dx[d]

                    if(vy < 0 || vy >= Y || vx < 0 || vx >= X){
                        if(d == 0) d = 1
                        if(d == 1) d = 0
                        if(d == 2) d = 3
                        if(d == 3) d = 2
                    }else {
                        location = Pair(vy, vx)
                        index++
                    }
                }

                if(arr2[location.first][location.second].first != 0){
                    if(arr2[location.first][location.second].third < t.third){
                        arr2[location.first][location.second] = Triple(s, d, z)
                    }
                }else {
                    arr2[location.first][location.second] = Triple(s, d, z)
                }
            }
        }

        for(i in 0 until Y) {
            for (j in 0 until X) {
                 arr[i][j] = arr2[i][j]
            }
        }
    }
}