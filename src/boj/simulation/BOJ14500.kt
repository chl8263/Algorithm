package boj.simulation


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

object BOJ14500 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var y = 0
    var x = 0

    val dy = arrayOf(0, 0, 1, -1)
    val dx = arrayOf(1, -1 ,0, 0)

    var arr = Array(y){Array(x){0}}

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())
        val y = st.nextToken().toInt()
        val x = st.nextToken().toInt()

        arr = Array(y){Array(x){0}}

        for(i in 0 until y){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until x){
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        var ans = 0

        val isVisited = Array(y){Array(x){false}}

        fun calSpecial(yy: Int, xx: Int): Int {
            var result = 0
            loop@for(i in 0..3){
                var temp = arr[yy][xx]
                for(j in 0..3){
                    if(i == j) continue
                    val vy = yy + dy[j]
                    val vx = xx + dx[j]
                    if(vy < 0 || vy >= y || vx < 0 || vx >= x) continue@loop
                    temp += arr[vy][vx]
                }
                result = max(result, temp)
            }
            return result
        }

        fun dfs(n: Int, ty: Int, tx: Int, sum: Int){
            if(n == 3){
                ans = max(sum, ans)
                return
            }

            for(i in 0..3){
                val vy = ty + dy[i]
                val vx = tx + dx[i]
                if(vy < 0 || vy >= y || vx < 0 || vx >= x || isVisited[vy][vx]) continue
                isVisited[vy][vx] = true
                dfs(n + 1, vy, vx, sum + arr[vy][vx])
                isVisited[vy][vx] = false
            }
        }

        for(i in 0 until (x * y)){
            val yy = i % y
            val xx = i / y
            isVisited[yy][xx] = true
            dfs(0, yy, xx, arr[yy][xx])
            ans = max(calSpecial(yy, xx), ans)
            isVisited[yy][xx] = false
        }

        bw.write("$ans")

        bw.flush()
        bw.close()
    }

}