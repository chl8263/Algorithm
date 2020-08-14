package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

object BOJ3197 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val Y = st.nextToken().toInt()
        val X = st.nextToken().toInt()

        var arr = Array(Y){Array(X){'X'}}
        var arr2 = Array(Y){Array(X){'X'}}

//        val startPoint: Pair<Int, Int>
//        val endPoint: Pair<Int, Int>
        val pointList = ArrayList<Pair<Int, Int>>()

        for(y in 0 until Y){
            val st2 = br.readLine()
            for(x in 0 until X){
                if(st2[x] == '.'){
                    arr[y][x] = st2[x]
                    arr2[y][x] = st2[x]
                }else if(st2[x] == 'L'){
                    arr[y][x] = st2[x]
                    arr2[y][x] = st2[x]
                    pointList.add(Pair(y, x))
                }
            }
        }

        val vx = arrayOf(0, 0, 1, -1)
        val vy = arrayOf(1, -1, 0, 0)

        var result = 0
        loop@while (true) {
            var visit = Array(Y){Array(X){-1} }
            val q: Queue<Pair<Int, Int>> = LinkedList()
            val startPoint = pointList[0]
            val endPoint = pointList[1]
            q.add(startPoint)
            visit[startPoint.first][startPoint.second] = 1

            while (q.isNotEmpty()) {
                val p = q.poll()
                for (i in 0..3) {
                    val dy = p.first + vy[i]
                    val dx = p.second + vx[i]

                    if (dy < 0 || dy >= Y || dx < 0 || dx >= X) continue
                    if (arr[dy][dx] == 'X' || visit[dy][dx] == 1) continue
                    if (dy == endPoint.first && dx == endPoint.second){
                        break@loop
                    }

                    q.add(Pair(dy, dx))
                    visit[dy][dx] = 1
                }
            }

//            for(y in 0 until Y){
//                for(x in 0 until X){
//                    print(arr2[y][x])
//                }
//                println()
//            }
//            println()

            for(y in 0 until Y){
                for(x in 0 until X){
                    for (i in 0..3) {
                        val dy = y + vy[i]
                        val dx = x + vx[i]
                        if (dy < 0 || dy >= Y || dx < 0 || dx >= X) continue
                        if(arr2[y][x] == 'X' && arr[y][x] == 'X' && arr[dy][dx] != 'X') {
                            arr2[y][x] = '.'
                        }
                    }
                }
            }

            arr = arr2
            arr2 = Array(Y){Array(X){'X'}}
            for(y in 0 until Y){
                for(x in 0 until X){
                    arr2[y][x] = arr[y][x]
                }
            }
            result++

//            for(y in 0 until Y){
//                for(x in 0 until X){
//                    print(arr[y][x])
//                }
//                println()
//            }
//            println()

//            for(y in 0 until Y){
//                for(x in 0 until X){
//                    print(arr2[y][x])
//                }
//                println()
//            }
//            println()

        }

//        for(y in 0 until Y){
//            for(x in 0 until X){
//                print(arr[y][x])
//            }
//            println()
//        }

        bw.write("$result")

        bw.flush()
        bw.close()
    }
}