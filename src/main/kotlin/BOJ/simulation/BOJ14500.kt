package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ14500 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var y = 0
    var x = 0

    var arr = Array(y){Array(x){0}}

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())
        val y = st.nextToken().toInt()
        val x = st.nextToken().toInt()

        arr = Array(y){Array(x){0}}

        val shape1 = Array(1){Array(4){1}}
        val shape2 = Array(2){Array(2){1}}
        val shape3 = Array(3){Array(2){0}}
        shape3[0][0] = 1; shape3[1][0] = 1; shape3[2][0] = 1; shape3[2][1] = 1
        val shape4 = Array(3){Array(2){0}}
        shape4[0][0] = 1; shape4[1][0] = 1; shape4[1][1] = 1; shape4[2][1] = 1
        var shape5 = Array(2){Array(3){0}}
        shape5[0][0] = 1; shape5[0][1] = 1; shape5[0][2] = 1; shape5[1][1] = 1;

        val shapeList = arrayListOf(shape1, shape2, shape3, shape4, shape5)

        for(i in 0 until y){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until x){
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        for(s in 0..4) {
            val currentShape = shapeList[s]

            for(i in 0..3){

            }

            for(i in 0..3){

            }
        }

        bw.flush()
        bw.close()
    }

    fun rotate(shape: Array<Array<Int>>): Array<Array<Int>> {
        val y = shape.size
        val x = shape[0].size
        val result = Array(x){Array(y){0}}

        for(i in 0 until y){
            for(j in 0 until x){
                result[j][y-1-i] = shape[i][j]
            }
        }
        return result
    }

    fun check(){

    }
}