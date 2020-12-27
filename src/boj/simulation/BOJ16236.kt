package boj.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ16236 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var N = 0
    var arr = Array(N){Array(N){0}}
    var currentShark = Triple(0, 0, 0)

    val dy = arrayOf(0, 0, 1, -1)
    val dx = arrayOf(1, -1, 0, 0)

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())
        N = st.nextToken().toInt()
        arr = Array(N){Array(N){0}}

        for(i in 0 until N) {
            val st2 = StringTokenizer(br.readLine())
            for (j in 0 until N) {
                val t = st2.nextToken().toInt()
                if(t == 9){
                    currentShark = Triple(i, j, 2)
                }else{
                    arr[i][j] = t
                }

            }
        }

        var ans = 0

        var ex = 0

        var flag = true
        while (flag) {
            val subResult = search()
            if(subResult.first == Int.MAX_VALUE) flag = false
            else {
                ans += subResult.third

                currentShark = currentShark.copy(first = subResult.first, second = subResult.second)
                arr[subResult.first][subResult.second] = 0
                if(currentShark.third == ++ex){
                    currentShark = currentShark.copy(third = currentShark.third + 1)
                    ex = 0
                }

            }
        }

        bw.write("$ans")

        bw.flush()
        bw.close()
    }

    fun search (): Triple<Int, Int, Int> {
        var result = Triple(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE)

        val q: Queue<Pair<Int, Int>> = LinkedList()
        val visited = Array(N){Array(N){-1}}
        q.add(Pair(currentShark.first, currentShark.second))
        visited[currentShark.first][currentShark.second] = 0
        while (q.isNotEmpty()){
            val p = q.poll()
            for(i in 0..3){
                val vy = p.first + dy[i]
                val vx = p.second + dx[i]
                if(vy < 0 || vy >= N || vx < 0 || vx >= N || visited[vy][vx] > -1 || currentShark.third < arr[vy][vx]) continue
                if(arr[vy][vx] > 0 && currentShark.third > arr[vy][vx]){
                    if(result.first == Int.MAX_VALUE) {
                        result = Triple(vy, vx, visited[p.first][p.second] + 1)

                    }else if(result.third > visited[p.first][p.second] + 1){
                        result = Triple(vy, vx, visited[p.first][p.second] + 1)

                    }else if(result.third == visited[p.first][p.second] + 1){
                        if(result.first > vy)
                            result = Triple(vy, vx, visited[p.first][p.second] + 1)

                        else if(result.first == vy && result.second > vx)
                            result = Triple(vy, vx, visited[p.first][p.second] + 1)
                    }
                }
                q.add(Pair(vy, vx))
                visited[vy][vx] = visited[p.first][p.second] + 1
            }
        }
        return result
    }
}