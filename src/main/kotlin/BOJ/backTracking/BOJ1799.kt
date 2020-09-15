package BOJ.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ1799 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val num = st.nextToken().toInt()
        var canGoNum = 0
        val arr = Array(num){Array(num){0}}
        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until num){
                val t = st2.nextToken().toInt()
                arr[i][j] = t
                if(t == 1) canGoNum++
            }
        }

        val results = ArrayList<Int>()
        val v1 = Array(num * 2 - 1){false}
        val v2 = Array(num * 2 - 1){false}

        fun func1(y: Int, x: Int, s: Int, k: Int){
            if(s == (num * num)){
                results.add(k)
                return
            }
            var temp = s

            for(i in y until num){
                for(j in x until num){
                    temp++
                    if(arr[i][j] == 0) continue
                    if(v1[i + j]) continue
                    if(v2[num - 1 - i + j]) continue
                    v1[i + j] = true
                    v2[num - 1 - i + j] = true

                    var tx = 0
                    var ty = 0

                    if(j == num-1){
                        ty = y+1
                        tx = 0
                    }else {
                        ty = y
                        tx = x+1
                    }

                    func1(ty, tx, temp, k+1)

                    //func1(i, j, temp, k+1)

                    v1[i + j] = false
                    v2[num - 1 - i + j] = false
                }
            }
        }

        func1(0, 0, 0, 0)

        bw.write("${results.max()}")

        bw.flush()
        bw.close()
    }
}