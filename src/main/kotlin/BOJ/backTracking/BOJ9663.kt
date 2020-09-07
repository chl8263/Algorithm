package BOJ.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ9663 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        val arr = Array(num){Array(num){false}}
        val chY = Array(num){false}
        val chDiaGonal_1 = Array(num+(num-1)){false}
        val chDiaGonal_2 = Array(num+(num-1)){false}

        var result = 0
        fun func1(k: Int){
            if(k == num){
                result++
                return
            }

            for(i in 0 until num){
                val n1 = k + i
                val n2 = k - i + (num - 1)
                if(!chY[i] && !chDiaGonal_1[n1] && !chDiaGonal_2[n2]){
                    chY[i] = true
                    chDiaGonal_1[n1] = true
                    chDiaGonal_2[n2] = true
                    func1(k + 1)
                    chY[i] = false
                    chDiaGonal_1[n1] = false
                    chDiaGonal_2[n2] = false
                }
            }
        }

        func1(0)

        bw.write("$result")

        bw.flush()
        bw.close()
    }
}