package bruteForceSearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ1018 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))

        val st = StringTokenizer(br.readLine())
        val y = st.nextToken().toInt()
        val x = st.nextToken().toInt()

        val arr = Array(y){Array(x){'0'}}

        var result = 0

        for(i in 0 until y){
            val input = br.readLine()
            for(j in 0 until x){
                arr[i][j] = input[j]
            }
        }

        val cal = { x: Char, arr: Array<Array<Char>> ->
            var count = 0
            for((i, k) in arr.withIndex()){
                for((j, k2) in k.withIndex()){
                    if((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                        if (k2 != x) {
                            count++
                        }
                    }else {
                        if (k2 == x) {
                            count++
                        }
                    }
                }
            }
            count
        }

        val extract = { i: Int, j: Int ->
            val tempArr = Array(8){Array(8){'0'}}
            for((c1, i2) in (i until i+8).withIndex()){
                for((c2, j2) in (j until j+8).withIndex()){
                    tempArr[c1][c2] = arr[i2][j2]
                }
            }

            val a = cal('W', tempArr)
            val b = cal('B', tempArr)
            var sub = 0
            if(a>b) sub = b
            else sub = a
            if(result > 0 && sub < result){
                result = sub
            }else if(result == 0) {
                result = sub
            }
        }

        loop1@for((i, it) in arr.withIndex()){

            if( (y - i) < 8 ) break

            for((j, it2) in it.withIndex()){
                if( (x - j) < 8 ) break
                extract(i, j)
            }
        }
        println(result)
    }
}