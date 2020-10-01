package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

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
                arr2[i][j] = st2.nextToken().toInt()
            }
        }

//        for(i in 0..1023){
//            copyArr()
//            var brute = i
//            for(j in 0..4){
//                val dir = brute % 4
//                brute /= 4
//                tilt(dir)
//            }
//        }

        arr2 = tilt(1)

        for(i in 0 until num){
            for(j in 0 until num){
                print(arr2[i][j])
            }
            println()
        }

        bw.flush()
        bw.close()
    }

    fun tilt(direction: Int): Array<Array<Int>> {

        val y = arr2.size
        val x = arr2[0].size

        val t_arr = Array(y){Array(x){0}}
        val isAccu = Array(y){Array(x){false}}

        for(i in 0 until y){
            var index = 0
            for(j in 0 until x){
                if(arr2[i][j] != 0){
                    if(j == 0){
                        t_arr[i][index] = arr2[i][j]
                    } else if(isAccu[i][index]){
                        t_arr[i][++index] = arr2[i][j]
                    }else {
                        if(t_arr[i][index] == arr2[i][j] && !isAccu[i][index]){
                            t_arr[i][index] +=  arr2[i][j]
                        }else {
                            t_arr[i][++index] +=  arr2[i][j]
                        }
                    }
                }
            }
        }
        return t_arr
    }

    fun rotate(arr: Array<Array<Int>>){
        val y = arr.size
        val x = arr[0].size

        val t = Array(x){Array(y){0}}

        for(i in 0 until y){
            for(j in 0 until x){
                t[i][j] = arr[][]
            }
        }
    }

    fun copyArr(){
        for(i in 0 until arr.size){
            for(j in 0 until arr[0].size){
                arr2[i][j] = arr[i][j]
            }
        }
    }

}