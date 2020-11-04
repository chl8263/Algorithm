import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object App {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        val num = st.nextToken().toInt()
        val timestamp = ArrayList<Int>()
        val top = ArrayList<Int>()
        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            val a = st2.nextToken().toInt()
            timestamp.add(a)
        }

        val st3 = StringTokenizer(br.readLine())
        val topp = st3.nextToken().toInt()
        for(i in 0 until topp){
            val st2 = StringTokenizer(br.readLine())
            val a = st2.nextToken().toInt()
            top.add(a)
        }

        timestamp.sort()
        top.sort()

        //val s = Stack<Int>()
        var s = 0
        var ans = 0
        for (i in 0..top[top.size-1] + 1) {
            loop@ for (time in timestamp) {
                if (time > i) break@loop
                if (time == i) s++//s.add(time)
            }
            if (top.size > 0 && top[0] == i) {
                val total = s
                if (total < 5) {
                    ans += s
                    s = 0
                } else {
                    ans += 5
                    s -= 5
                }
                top.removeAt(0)
            }
        }

        println(ans)

        bw.flush()
        bw.close()
    }


}