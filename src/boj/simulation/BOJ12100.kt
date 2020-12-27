package boj.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

object BOJ12100 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    lateinit var arr: Array<Array<Int>>
    lateinit var arr2: Array<Array<Int>>
    @JvmStatic
    fun main(args: Array<String>){

        val st = StringTokenizer(br.readLine())

        val num = st.nextToken().toInt()
        arr = Array(num){Array(num){0}}
        arr2 = Array(num){Array(num){0}}

        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until num){
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        var max = 0

        for(i in 0..1023){
            copyArr()
            var brute = i
            for(j in 0..4){
                val dir = brute % 4
                brute /= 4
                arr2 = tilt(dir)
            }
            for(i in 0 until num){
                for(j in 0 until num){
                    max = max(arr2[i][j], max)
                }
            }
        }

        bw.write("$max")

        bw.flush()
        bw.close()
    }

    fun tilt(direction: Int): Array<Array<Int>> {

        val y = arr2.size
        val x = arr2[0].size

        var t_arr = Array(y){Array(x){0}}
        val isAccu = Array(y){Array(x){false}}

        for(i in 0 until direction){
            arr2 = rotate(arr2)
        }

        for(i in 0 until y){
            var index = 0
            for(j in 0 until x){
                if(arr2[i][j] == 0) continue
                if(t_arr[i][index] == 0){
                    t_arr[i][index] = arr2[i][j]
                } else if(isAccu[i][index]){
                    t_arr[i][++index] = arr2[i][j]
                }else if(!isAccu[i][index]){
                    if(t_arr[i][index] == arr2[i][j]){
                        t_arr[i][index] +=  arr2[i][j]
                        isAccu[i][index] = true
                    }else {
                        t_arr[i][++index] +=  arr2[i][j]
                    }
                }
            }
        }

        if(direction != 0) {
            for (i in 0 until 4 - direction) {
                t_arr = rotate(t_arr)
            }
        }

        return t_arr
    }

    fun rotate(arr: Array<Array<Int>>): Array<Array<Int>> {
        val y = arr.size
        val x = arr[0].size

        val t = Array(x){Array(y){0}}

        for(i in 0 until y){
            for(j in 0 until x){
                t[j][y-1-i] = arr[i][j]
            }
        }
        return t
    }

    fun copyArr(){
        for(i in 0 until arr.size){
            for(j in 0 until arr[0].size){
                arr2[i][j] = arr[i][j]
            }
        }
    }

}