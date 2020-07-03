import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ9498 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val given = st.nextToken().toInt()

        when (given) {
            in 90..100 -> {
                print("A")
            }
            in 80..89 -> {
                print("B")
            }
            in 70..79 -> {
                print("C")
            }
            in 60..69 -> {
                print("D")
            }
            else -> print("F")
        }
    }
}