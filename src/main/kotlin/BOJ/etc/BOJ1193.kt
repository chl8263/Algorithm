package BOJ.etc

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ1193 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val given = st.nextToken().toInt()

        var cnt = 1
        var sum = 1

        var one = 0
        var two = 0

        while(true){
            if(given <= sum){
                if(cnt % 2 == 0){
                    one = cnt - (sum - given)

                    two = cnt + 1 - one
                }else {
                    one = sum - given + 1
                    two = cnt - (sum - given)
                }
                break
            }else {
                sum += ++cnt
            }
        }
        println("$one/$two")
    }
}