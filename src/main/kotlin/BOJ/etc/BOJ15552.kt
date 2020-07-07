import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ15552 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        for(i in 1..num){
            val st2 = StringTokenizer(br.readLine())
            val num1 = st2.nextToken().toInt()
            val num2 = st2.nextToken().toInt()
            bw.write("${(num1 + num2)} \n")
        }
        bw.flush()
        bw.close()
    }
}