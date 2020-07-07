import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ13300 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val given = st.nextToken().toInt()
        val max = st.nextToken().toInt()

        var cnt = 0
        val arr = Array(12){0}

        for(i in 1..given){
            val st2 = StringTokenizer(br.readLine())
            val gender = st2.nextToken().toInt()
            val grade = st2.nextToken().toInt()
            if(gender == 1) arr[(grade*2) -1 -1]++
            else arr[grade*2 -1]++
        }

        arr.forEach {
            val divide = it/max
            val remain = it%max
            cnt += divide
            if(remain != 0) cnt ++
        }

        bw.write("$cnt")

        bw.flush()
        bw.close()
    }
}