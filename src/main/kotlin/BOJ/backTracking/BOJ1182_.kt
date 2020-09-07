package BOJ.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ1182_ {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val st2 = StringTokenizer(br.readLine())

        val num = st.nextToken().toInt()
        val goal = st.nextToken().toInt()

        val arr = Array(num){0}
        for(i in 0 until num){
            arr[i] = st2.nextToken().toInt()
        }

        var result = 0
        fun func1(k: Int, t: Int){
            if(k == num ){
                if(t == goal)
                    result++
                return
            }

            func1(k+1, t+arr[k])
            func1(k+1, t)
        }

        func1(0, 0)

        if(goal == 0) result--

        bw.write("$result")

        bw.flush()
        bw.close()
    }
}