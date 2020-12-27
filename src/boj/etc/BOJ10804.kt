import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ10804 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))

        val arr = Array(20){i -> i+1}

        for(i in 0..9){
            val st = StringTokenizer(br.readLine())
            val a = st.nextToken().toInt()-1
            val b = st.nextToken().toInt()-1

            val temp = Stack<Int>()
            for(j in a..b){
                temp.add(arr[j])
            }

            for(j in a..b){
                arr[j] = temp.pop()
            }
        }

        arr.forEach { print("$it ") }
    }
}