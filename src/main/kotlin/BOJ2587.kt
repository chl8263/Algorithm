import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ2587 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))

        val arr = Array(5){0}
        for(i in 0 until 5){
            val st = StringTokenizer(br.readLine())
            val a = st.nextToken().toInt()
            arr[i] = a
        }
        arr.sort()
        println(arr.fold(0){acc, it -> acc + it} / arr.size)
        println(arr[2])
    }
}