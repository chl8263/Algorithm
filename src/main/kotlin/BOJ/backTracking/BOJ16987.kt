package BOJ.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

object BOJ16987 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()
        val arr = Array(num){Pair(0, 0)}

        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            arr[i] = arr[i].copy(st2.nextToken().toInt(), st2.nextToken().toInt())
        }

        val visit = Array(num){false}
        var ans = 0
        fun dfs (count: Int, current: Int, breaking: Int){
            ans = max(breaking, ans)
            if(count == num) {
                return
            }

            for(i in 0 until num){
                if(arr[i].first > 0 && i != current){
                    var tBreak = 0
                    var cur : Int? = null
                    var obj : Int? = null
                    val fff = arr[current].first
                    if(fff > 0){
                        cur = arr[current].first
                        obj = arr[i].first
                        val currentToObj = arr[current].first - arr[i].second
                        val objToCurrent = arr[i].first - arr[current].second

                        arr[current] = arr[current].copy(first = currentToObj)
                        arr[i] = arr[i].copy(first = objToCurrent)

                        if(currentToObj <= 0){
                            tBreak++
                        }
                        if(objToCurrent <= 0){
                            tBreak++
                        }
                    }

                    dfs(count+1, current + 1, breaking + tBreak)

                    if(fff > 0) {
                        arr[current] = arr[current].copy(first = cur!!)
                        arr[i] = arr[i].copy(first = obj!!)
                    }
                }
//                if(i == num-1) {
//                    ans = max(breaking, ans)
//                }
            }
        }

        dfs(0, 0, 0)

        bw.write("$ans")

        bw.flush()
        bw.close()
    }
}