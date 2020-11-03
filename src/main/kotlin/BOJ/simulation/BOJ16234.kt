package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ16234 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        val num = st.nextToken().toInt()
        val L = st.nextToken().toInt()
        val H = st.nextToken().toInt()

        val arr = Array(num){Array(num){0}}
        val visited = Array(num){Array(num){0}}

        for(i in 0 until num) {
            val st2 = StringTokenizer(br.readLine())
            for (j in 0 until num) {
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        val dy = arrayOf(0, 0, 1, -1)
        val dx = arrayOf(1, -1, 0, 0)

        val q: Queue<Pair<Int, Int>> = LinkedList()
        while (q.isNotEmpty()){
            val p = q.poll()
        }


        for(i in 0 until num) {
            for (j in 0 until num) {
                val q: Queue<Pair<Int, Int>> = LinkedList()
                while (q.isNotEmpty()){
                    val p = q.poll()
                }
            }
        }

        bw.flush()
        bw.close()
    }
}