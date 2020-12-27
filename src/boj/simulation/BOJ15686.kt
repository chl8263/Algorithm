package boj.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs
import kotlin.math.min

object BOJ15686 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var n = 0
    var m = 0

    val chickenList = ArrayList<Pair<Int, Int>>()
    val homeList = ArrayList<Pair<Int, Int>>()

    lateinit var arr : Array<Array<Int>>

    var isUsed = Array(chickenList.size){false}
    var combiChicken = Array(m){Pair(0, 0)}
    var ans = Int.MAX_VALUE
    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        n = st.nextToken().toInt()
        m = st.nextToken().toInt()

        arr = Array(n){Array(n){0}}

        for(i in 0 until n){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until n){
                val t = st2.nextToken().toInt()
                arr[i][j] = t
                if(t == 2) chickenList.add(Pair(i, j))
                if(t == 1) homeList.add(Pair(i, j))
            }
        }

        isUsed = Array(chickenList.size){false}
        combiChicken = Array(m){Pair(0, 0)}

        combiantion(0, 0)

        bw.write("$ans")

        bw.flush()
        bw.close()
    }



    fun combiantion(count: Int, start: Int){
        if(count == m){
            ans = min(cal(), ans)
            return
        }

        for(i in start until chickenList.size){
            if(isUsed[i]) continue
            isUsed[i] = true
            combiChicken[count] = chickenList[i]
            combiantion(count+1, i+1)
            isUsed[i] = false
        }
    }

    fun cal(): Int {
        var result = 0
        for(home in homeList){
            var tResult = Int.MAX_VALUE
            var a = 0
            var b = 0
            for(chicken in combiChicken){
                val a = abs(home.first - chicken.first)
                val b = abs(home.second - chicken.second)
                tResult = min(tResult, a+b)
            }
            result+=tResult
        }
        return result
    }
}