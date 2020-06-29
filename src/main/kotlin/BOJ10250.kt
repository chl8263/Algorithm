import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ10250 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))

        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            val H = st2.nextToken().toInt()
            val W = st2.nextToken().toInt()
            val N = st2.nextToken().toInt()

            var one = 0
            var two = ""
            if(N % H == 0){
                one = H
                two = (N / H).toString()
            }else {
                one = N % H
                two = (N / H + 1).toString()
            }
            if(two.length == 1){
                two = "0${two}"
            }
            println("$one$two")
        }
    }
}