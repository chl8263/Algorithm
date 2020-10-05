package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ14499 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    lateinit var arr: Array<Array<Int>>
    val dice = Array(6){0}

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        var y = st.nextToken().toInt()
        var x = st.nextToken().toInt()
        val k = st.nextToken().toInt()

        arr = Array(n){Array(m){0}}

        for(i in 0 until n){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until m){
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        val st3 = StringTokenizer(br.readLine())

        val vy = arrayOf(0, 0, -1, 1)
        val vx = arrayOf(1, -1, 0, 0)


        for(i in 1..k){
            val command = st3.nextToken().toInt()

            val dy = y + vy[command-1]
            val dx = x + vx[command-1]

            if(dy < 0 || dy >= n || dx < 0 || dx >= m) continue
            y = dy
            x = dx
            doDice(command)
            bw.write("${dice[3]}\n")
            if(arr[dy][dx] != 0){
                dice[1] = arr[dy][dx]
                arr[dy][dx] = 0
            }
            else if(arr[dy][dx] == 0) {
                arr[dy][dx] = dice[1]
                //dice[1] = 0
            }
        }

        bw.flush()
        bw.close()
    }

    fun doDice(command: Int){
        when(command){
            1->{
                val t = dice[3]
                dice[3] = dice[4]
                dice[4] = dice[1]
                dice[1] = dice[5]
                dice[5] = t
            }
            2->{
                val t = dice[3]
                dice[3] = dice[5]
                dice[5] = dice[1]
                dice[1] = dice[4]
                dice[4] = t
            }
            3->{
                val t = dice[2]
                dice[2] = dice[1]
                dice[1] = dice[0]
                dice[0] = dice[3]
                dice[3] = t
            }
            4->{
                val t = dice[0]
                dice[0] = dice[1]
                dice[1] = dice[2]
                dice[2] = dice[3]
                dice[3] = t
            }
        }
    }
}