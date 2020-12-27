package boj.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

object BOJ1799 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val num = st.nextToken().toInt()
        val arr = Array(num){Array(num){0}}
        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until num){
                val t = st2.nextToken().toInt()
                arr[i][j] = t
            }
        }

        //val results = ArrayList<Int>()
        var result1 = 0
        var result2 = 0
        val v1 = Array(num * 2 - 1){false}
        val v2 = Array(num * 2 - 1){false}

        fun func1(y: Int, x: Int, s: Int, k: Int, flag: Int){
            if((num % 2 == 0 && s == (num * num) / 2) ||
                (num % 2 == 1 && flag == 0 && s == (num * num) / 2 + 1) ||
                (num % 2 == 1 && flag == 1 && s == (num * num) / 2)
            ){
                if(flag == 0) {
                    result1 = max(result1, k)
                }else if(flag == 1) {
                    result2 = max(result2, k)
                }
                //results.add(k)
                return
            }
            var temp = s

            for(i in y until num){
                for(j in x until num step 2){
                    temp++
                    if(arr[i][j] == 0) continue
                    if(v1[i + j]) continue
                    if(v2[num - 1 - i + j]) continue
                    v1[i + j] = true
                    v2[num - 1 - i + j] = true

                    var tx = 0
                    var ty = 0

                    if (j == num - 2) {
                        ty = y + 1
                        tx = 0
                    } else if (j == num - 1) {
                        ty = y + 1
                        tx = 1
                    } else {
                        ty = y
                        tx = x
                    }

                    func1(ty, tx, temp, k+1, flag)

                    v1[i + j] = false
                    v2[num - 1 - i + j] = false
                }
            }
        }

        func1(0, 0, 0, 0, 0)
        func1(0, 1, 0, 0, 1)

        bw.write("${result1 + result2}")
        bw.write("${result1}")
        bw.write("${result2}")
        //bw.write("${results.max()}")

        bw.flush()
        bw.close()
    }
}