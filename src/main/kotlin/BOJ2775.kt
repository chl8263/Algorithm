import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ2775 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val given = st.nextToken().toInt()

        val arr = Array(14){Array(14){0}}

        fun cal(k: Int, n: Int): Int{
            if(n == 0) return 1
            if(k == 0) return n+1
            var result = 0
            for(i in 0..n){
                arr[k-1][i] = cal(k-1, i)
                result += arr[k-1][i]
            }
            return result
        }

        for (i in 0 until given){
            val st2 = StringTokenizer(br.readLine())
            val st3 = StringTokenizer(br.readLine())
            val k = st2.nextToken().toInt()
            val n = st3.nextToken().toInt()

            println(cal(k, n-1))
        }
    }
}
