package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ14890 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var num = 0
    var L = 0
    var arr = Array(num){Array(num){0}}
    val dy = arrayOf(0, 1)
    val dx = arrayOf(1, 0)

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

        for(i in 0 until num){
            check(0, i, 0)
        }

        for(i in 0 until num){
            check(i, 0, 1)
        }

        bw.flush()
        bw.close()
    }

    fun check(y: Int, x: Int, sw: Int){
        val start = arr[y][x]

        for(i in 0..6){

        }
    }
}