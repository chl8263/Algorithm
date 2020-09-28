package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ18808 {

    var Y = 0
    var X = 0
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

         Y = st.nextToken().toInt()
         X = st.nextToken().toInt()
        val K = st.nextToken().toInt()

        val stickers = ArrayList<Array<Array<Int>>>()
        var arr = Array(Y){Array(X){0}}

        for(i in 0 until K){
            val st2 = StringTokenizer(br.readLine())
            val Y2 = st2.nextToken().toInt()
            val X2 = st2.nextToken().toInt()
            val t_arr = Array(Y2){Array(X2){0}}

            for(j in 0 until Y2){
                val st3 = StringTokenizer(br.readLine())
                for(h in 0 until X2){
                    t_arr[j][h] = st3.nextToken().toInt()
                }
            }
            stickers.add(t_arr)
        }

        for(sticker in stickers){
            var t_sticker = sticker
            loop@for(k in 0..3){
                for(i in 0 until Y){
                    for(j in 0 until X){
                        if(checkDuplicate(arr, i, j, t_sticker)){
                            arr = drewUpArr(arr, i, j, t_sticker)
                            break@loop
                        }
                    }
                }
                t_sticker = rotateArr(t_sticker.size, t_sticker[0].size, t_sticker)
            }
        }

        var ans = 0
        for(tY in arr){
            for(tX in tY){
                if(tX == 1) ans++
            }
        }

        bw.write("$ans")

        bw.flush()
        bw.close()
    }


    fun checkDuplicate(fArr: Array<Array<Int>>, fY: Int, fX: Int, compare: Array<Array<Int>>): Boolean {
        var result = true

        loop@for((i, t_y) in compare.withIndex()){
            for((j, t_x) in t_y.withIndex()){
                if(fY + i >= Y  || fX + j >= X || (compare[i][j] == 1 && fArr[fY + i][fX + j] == 1)) {
                    result = false
                    break@loop
                }
            }
        }
        return result
    }

    fun drewUpArr(fArr: Array<Array<Int>>, fY: Int, fX: Int, compare: Array<Array<Int>>): Array<Array<Int>> {
        for((i, t_y) in compare.withIndex()){
            for((j, t_x) in t_y.withIndex()){
                if(compare[i][j] == 1 && fArr[fY + i][fX + j] == 0) {
                    fArr[fY + i][fX + j] = 1
                }
            }
        }
        return fArr
    }

    fun rotateArr(y: Int, x: Int, arr: Array<Array<Int>>): Array<Array<Int>> {
        val result = Array(x){Array(y){0}}

        for(i in 0 until y){
            for(j in 0 until x){
                result[j][y-1-i] = arr[i][j]
            }
        }
        return result
    }
}
