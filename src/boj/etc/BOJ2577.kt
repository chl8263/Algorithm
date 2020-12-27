import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ2577 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        var mul = 1
        for(i in 0..2){
            val st = StringTokenizer(br.readLine())
            val a = st.nextToken().toInt()
            mul *= a
        }
        val arr = Array(10){0}
        val mulToS = mul.toString()
        for(i in 0..mulToS.length-1){
            arr[mulToS[i]-'0'] ++
        }

        arr.forEach {
            println(it)
        }
    }
}