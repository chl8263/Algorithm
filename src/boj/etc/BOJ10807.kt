import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ10807 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val given = st.nextToken().toInt()

        val arr = Array(201){0}

        val st2 = StringTokenizer(br.readLine())
        for(i in 1..given){
            val num2 = st2.nextToken().toInt()
            arr[num2+100]++
        }

        val st3 = StringTokenizer(br.readLine())
        val num3 = st3.nextToken().toInt()

        bw.write("${arr[num3+100]}")


        bw.flush()
        bw.close()
    }
}