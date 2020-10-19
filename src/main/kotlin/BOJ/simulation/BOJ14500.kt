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

        for(i in 0 until y){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until x){
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        for (truck in arr) {
            loop@while (true) {
                if(q.isEmpty()){
                    q.add(truck)
                    ans++
                    weight += truck
                    break@loop
                }else if(q.size == w){
                    weight -= q.poll()
                }else {
                    if(weight + truck > l){
                        q.add(0)
                        ans++
                    }else {
                        q.add(truck)
                        ans++
                        weight += truck
                        break@loop
                    }
                }
            }
        }

        BOJ13335.bw.write("${ans+w}")


        bw.flush()
        bw.close()
    }

}