import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ1267 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        val st2 = StringTokenizer(br.readLine())

        val n = st.nextToken().toInt()
        var totalY = 0
        var totalM = 0

        for(i in 0 until n){
            val a=  st2.nextToken().toInt()
            val Y1 = a / 30
            totalY += (10 * (Y1 + 1))

            val M1 = a / 60
            totalM += (15 * (M1+1))
        }

        if(totalM > totalY) println("Y $totalY")
        else if(totalM == totalY) println("Y M $totalY")
        else println("M $totalM")
    }
}