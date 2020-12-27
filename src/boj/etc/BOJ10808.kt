import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ10808 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val given = st.nextToken()

        val arr = Array(26){0}

        given.forEach {
            arr[it.toByte().toInt()-97] ++
        }

        arr.forEach {
            bw.write("$it ")
        }

        bw.flush()
        bw.close()
    }
}