package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

object BOJ16234 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var a: Int? = null
    @JvmStatic
    fun main(args: Array<String>){

        val st = StringTokenizer(br.readLine())

        val num = st.nextToken().toInt()
        val L = st.nextToken().toInt()
        val H = st.nextToken().toInt()

        val arr = Array(num){Array(num){0}}

        for(i in 0 until num) {
            val st2 = StringTokenizer(br.readLine())
            for (j in 0 until num) {
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        val dy = arrayOf(0, 0, 1, -1)
        val dx = arrayOf(1, -1, 0, 0)

        var ans = 0
        var flag = true

        while (flag){

            val isVisited = Array(num){Array(num){false}}
            var tmpFlag = false

            for(i in 0 until num) {
                for (j in 0 until num) {

                    if(isVisited[i][j]) continue

                    val check = ArrayList<Pair<Int, Int>>()
                    val q: Queue<Pair<Int, Int>> = LinkedList()
                    q.add(Pair(i, j))
                    check.add(Pair(i, j))
                    isVisited[i][j] = true
                    var total = arr[i][j]

                    while (q.isNotEmpty()){
                        val p = q.poll()
                        for(i in 0..3){
                            val dy = p.first + dy[i]
                            val dx = p.second + dx[i]
                            if(dy < 0 || dy >= num || dx < 0 || dx >= num || isVisited[dy][dx]) continue
                            val diff = abs(arr[p.first][p.second] - arr[dy][dx])
                            if(diff in L..H) {
                                check.add(Pair(dy, dx))
                                q.add(Pair(dy, dx))
                                isVisited[dy][dx] = true
                                total += arr[dy][dx]
                            }
                        }
                    }

                    if (check.size > 1) tmpFlag = true

                    var caled = total / check.size

                    for(ch in check){
                        arr[ch.first][ch.second] = caled
                    }
                }
            }

            if(tmpFlag) ans++
            else flag = false
        }

        bw.write("$ans")

        bw.flush()
        bw.close()
    }
}
