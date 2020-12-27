import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ2753 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val given = st.nextToken().toInt()

        if(given % 4 == 0 && given % 100 != 0 || given % 400 == 0) print(1)
        else print(0)
    }
}