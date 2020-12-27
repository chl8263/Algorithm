package boj.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

object BOJ14890 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var num = 0
    var L = 0
    var arr = Array(num){Array(num){0}}
    val dy = arrayOf(1, 0)
    val dx = arrayOf(0, 1)

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        num = st.nextToken().toInt()
        L = st.nextToken().toInt()

        arr = Array(num){Array(num){0}}

        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until num){
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        var ans = 0

        for(i in 0 until num){
            if(check(0, i, 0)) {
                ans++
            }
        }

        for(i in 0 until num){
            if(check(i, 0, 1)) {
                ans++
            }
        }

        bw.write("$ans")

        bw.flush()
        bw.close()
    }

    fun check(y: Int, x: Int, sw: Int): Boolean {

        var result = true

        val isSlide = Array(num){Array(num){false}}
        val q: Queue<Pair<Int, Int>> = LinkedList()

        q.add(Pair(y, x))

        while(q.isNotEmpty()){
            val p = q.poll()
            val vy = p.first + dy[sw]
            val vx = p.second + dx[sw]

            if(vy < 0 || vy >= num || vx < 0 || vx >= num) continue

            val current = arr[p.first][p.second]
            val next = arr[vy][vx]

            if(abs(current - next) >= 2) {
                return false
            }

            if(abs(current - next) == 1){
                if(current > next){
                    for(i in 1..L){
                        val vy2 = p.first + (dy[sw] * i)
                        val vx2 = p.second + (dx[sw] * i)
                        if(vy2 < 0 || vy2 >= num || vx2 < 0 || vx2 >= num || isSlide[vy2][vx2] || abs(current - arr[vy2][vx2]) != 1) return false
                        isSlide[vy2][vx2] = true
                    }
                    val yy = p.first + (dy[sw] * (L))
                    val xx = p.second + (dx[sw] * (L))
                    if(yy < 0 || yy >= num || xx < 0 || xx >= num){

                    }else{
                        q.add(Pair(yy, xx))
                    }
                }else if(current < next){
                    for(i in 0 until L){
                        val vy2 = p.first - (dy[sw] * i)
                        val vx2 = p.second - (dx[sw] * i)
                        if(vy2 < 0 || vy2 >= num || vx2 < 0 || vx2 >= num || isSlide[vy2][vx2] || abs(next - arr[vy2][vx2]) != 1) return false
                        isSlide[vy2][vx2] = true
                    }
                    val yy = p.first + dy[sw]
                    val xx = p.second + dx[sw]
                    if(yy < 0 || yy >= num || xx < 0 || xx >= num){

                    }else{
                        q.add(Pair(yy, xx))
                    }
                }
            }else if(current == next){
                q.add(Pair(vy, vx))
            }
        }

        return result
    }
}
