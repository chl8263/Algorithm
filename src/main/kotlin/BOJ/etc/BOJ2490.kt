import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ2490 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))

        val cal = { st: StringTokenizer ->
            var cnt = 0
            for (i in 0 until 4) {
                if(st.hasMoreTokens()){
                    val a = st.nextToken().toInt()
                    if (a == 1) cnt++
                }
            }
            when (cnt) {
                3 -> println("A")
                2 -> println("B")
                1 -> println("C")
                0 -> println("D")
                4 -> println("E")
            }
        }
        val st = StringTokenizer(br.readLine())
        val st2 = StringTokenizer(br.readLine())
        val st3 = StringTokenizer(br.readLine())
        cal(st)
        cal(st2)
        cal(st3)
    }
}