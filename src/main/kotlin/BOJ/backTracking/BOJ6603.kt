package BOJ.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ6603 {
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        var arr: Array<Int> = Array(1) { 0 }
        var check: Array<Boolean> = Array(1) { false }
        var num = 0
        fun func1(k: Int, s: Int) {
            if (k == 6) {
                for (i in 0 until check.size) {
                    if (check[i])
                        bw.write("${arr[i]} ")
                }
                bw.write("\n")
                return
            }

            for (i in s until num) {
                if (!check[i]) {
                    check[i] = true
                    func1(k + 1, i + 1)
                    check[i] = false
                }

            }

            while (true) {
                val st = StringTokenizer(br.readLine())
                num = st.nextToken().toInt()
                if (num == 0) break
                arr = Array(num) { 0 }
                check = Array(num) { false }
                for (i in 0 until num) {
                    arr[i] = st.nextToken().toInt()
                }
                func1(0, 0)
                bw.write("\n")
            }

            bw.flush()
            bw.close()
        }
    }
}