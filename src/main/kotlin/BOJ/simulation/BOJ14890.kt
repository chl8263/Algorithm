package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

object BOJ14890 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var num = 0
    var L = 0
    var arr = Array(num){Array(num){0}}
    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        num = st.nextToken().toInt()
        L = st.nextToken().toInt()

        arr = Array(num){Array(num){0}}

        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until num){
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        for(i in 0 until num){
            for(j in 0 until num){

            }
        }

        bw.flush()
        bw.close()
    }

    fun check(start: Int, flag: Int): Boolean {
        val visit = Array(num){false}
        var temp = 0
        for(i in 0 until num){
            if(temp == 0){
                if(flag == 0){
                    temp = arr[start][i]
                }else {
                    temp = arr[i][start]
                }
            }else {
                if(flag == 0){
                    val diff = abs(temp - arr[start][i])
                    if(diff == 0) continue
                    else if(diff > 1) return false
                    else if(diff == 1){
                        var result = false
                        for(k1 in 0..1){
                            for(k2 in 0 until L){
                                if(k1 == 0){
                                    val t = arr[start][i]
                                }
                            }
                        }
                    }
                }else if (flag == 1 && temp == arr[i][start]) {
                    temp = arr[i][start]
                }
            }

        }
    }
}