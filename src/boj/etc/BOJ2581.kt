import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ2581 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        val one = st.nextToken().toInt()
        val st2 = StringTokenizer(br.readLine())
        val two = st2.nextToken().toInt()

        val result = arrayListOf<Int>()

        for(i in one..two){
            var count = 0
            for(j in 1..i){
                if(i % j == 0)
                    count++
            }
            if(count == 2) result.add(i)
        }
        if(result.size == 0) println(-1)
        else {
            val sum = result.fold(0) { acc, v -> acc + v }
            println(sum)
            result.sort()
            println(result[0])
        }
    }
}