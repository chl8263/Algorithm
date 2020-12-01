package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ17144 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var R = 0
    var C = 0
    var T = 0

    var arr = Array(R){Array(C){0}}


    val dy = arrayOf(0, 0, 1, -1)
    val dx = arrayOf(1, -1, 0, 0)

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())



        R = st.nextToken().toInt()
        C = st.nextToken().toInt()
        T = st.nextToken().toInt()

        arr = Array(R){Array(C){0}}

        for(i in 0 until R){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until C){
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        arr[2][0] = 2
        arr[3][0] = 2

        for(i in 0 until T){

        }

        bw.flush()
        bw.close()
    }

    fun spread(){
        var temp = Array(R){Array(C){0}}
        val q: Queue<Pair<Int, Int>> = LinkedList()
        val isVisited = Array(R){Array(C){false}}
        while (q.isNotEmpty()){
            val p = q.poll()
            val spreadAmount = arr[p.first][p.second] / 5

            var spreadCount = 0
            for(i in 0..3){
                val vy = p.first
                val vx = p.second
                if(vy < 0 || vy >= R || vx < 0 || vx >= C || isVisited[vy][vx] || arr[vy][vx] == 2) continue
                spreadCount++
            }

            temp[p.first][p.second] = arr[p.first][p.second] - spreadAmount * spreadCount
        }
    }


}