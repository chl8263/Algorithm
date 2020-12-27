import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ2839 {
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        var given = st.nextToken().toInt()

        var count = 0
        while (true) {
            if (given == 0) break
            if (given < 0) {
                count = -1
                break
            }
            if (given % 5 == 0) {
                given -= 5
                count++
            } else {
                given -= 3
                count++
            }

        }
        println(count)
    }
}