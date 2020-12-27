import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ2480 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        val calTwo = {i: Int -> 1000+i*100}
        if(a == b) {
            if(b == c) {
                print(10000+a*1000)
            }
            if(b != c) {
                print(calTwo(a))
            }
        }else if(b == c || a == c){
            print(calTwo(c))
        }else {
            var t = 0
            if(a > b) t = a
            else if(b > c) t = b
            else t = c
            print(t * 100)
        }
    }
}