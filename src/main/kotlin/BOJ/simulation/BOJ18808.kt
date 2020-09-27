package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ18808 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        //val st = StringTokenizer(br.readLine())

//        val Y = st.nextToken().toInt()
//        val X = st.nextToken().toInt()
//        val K = st.nextToken().toInt()
//
//        val stickers = ArrayList<Array<Array<Int>>>()
//        val arr = Array(Y){Array(X){0}}
//
//        for(i in 0 until K){
//            val st2 = StringTokenizer(br.readLine())
//            val Y2 = st2.nextToken().toInt()
//            val X2 = st2.nextToken().toInt()
//            val t_arr = Array(Y2){Array(X2){0}}
//
//            for(j in 0 until Y2){
//                val st3 = StringTokenizer(br.readLine())
//                for(h in 0 until X2){
//                    t_arr[j][h] = st3.nextToken().toInt()
//                }
//            }
//            stickers.add(t_arr)
//        }

        val st2 = StringTokenizer(br.readLine())
        val Y2 = st2.nextToken().toInt()
        val X2 = st2.nextToken().toInt()
        var t_arr = Array(Y2){Array(X2){0}}

        for(j in 0 until Y2){
            val st3 = StringTokenizer(br.readLine())
            for(h in 0 until X2){
                t_arr[j][h] = st3.nextToken().toInt()
            }
        }

        val t_arr2 = rotateArr(Y2, X2, t_arr)

        for(i in t_arr2){
            for(j in i){
                print(j)
            }
            println()
        }

        bw.flush()
        bw.close()
    }
}

fun rotateArr(y:Int, x: Int, arr: Array<Array<Int>>): Array<Array<Int>> {
    val result = Array(x){Array(y){0}}

    for(i in 0 until x){
        for(j in 0 until y){
            result[i][j] = arr[j][y-i]
        }
    }

    return result
}
