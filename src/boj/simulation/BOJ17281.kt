package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

object BOJ17281 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var num = 0
    var scoreList = Array(0){Array(0){0}}

    val mixVisit = Array(9){false}
    val order = Array(9){0}

    var f_list = Array(num){0}
    var ans = 0

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())
        num = st.nextToken().toInt()
        scoreList = Array(num){Array(9){0}}
        f_list = Array(9){0}
        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until 9){
                scoreList[i][j] = st2.nextToken().toInt()
            }
        }

        dfs(1)

        bw.write("$ans")

        bw.flush()
        bw.close()
    }

    fun dfs(c: Int){
        if(c == 9){
//            for(i in 0 until 9){
//                print(order[i])
//            }
//            println()
            for(i in 1..3){
                f_list[i-1] = order[i]
            }
            f_list[3] = 0
            for(i in 4..8){
                f_list[i] = order[i]
            }
            ans = max(ans, game())
            return
        }
        for(i in 1 until 9){
            if(mixVisit[i]) continue
            mixVisit[i] = true
            order[c] = i
            dfs(c+1)
            mixVisit[i] = false
        }
    }

    fun game(): Int {
        val ground = Array(3){0}
        var out = 0
        var score = 0
        var ining = 0
        var index = 0
        while (ining < num){
            val t = f_list[index%9]
            index++
            if (index == 9) index = 0

            when (scoreList[ining][t]){
                0 -> {
                    out++
                }
                1 -> {
                    score += ground[0]
                    ground[0] = ground[1]
                    ground[1] = ground[2]
                    ground[2] = 1
                }
                2 -> {
                    score += ground[0]
                    score += ground[1]
                    ground[0] = ground[2]
                    ground[1] = 1
                    ground[2] = 0
                }
                3 -> {
                    score += ground[0]
                    score += ground[1]
                    score += ground[2]
                    ground[0] = 1
                    ground[1] = 0
                    ground[2] = 0
                }
                4 -> {
                    score += ground[0]
                    score += ground[1]
                    score += ground[2]
                    score += 1
                    ground[0] = 0
                    ground[1] = 0
                    ground[2] = 0
                }
            }

            if(out == 3){
                ining ++
                ground[0] = 0
                ground[1] = 0
                ground[2] = 0
                out = 0
            }
        }
        return score
    }

}