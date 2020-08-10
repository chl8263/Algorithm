package BOJ.stack
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ6198 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())

        val num = st.nextToken().toInt()

        val arr = Array(num){0}
        val stack = Stack<Int>()
        var result = 0

        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            val building = st2.nextToken().toInt()
            while(!stack.isEmpty() && stack.peek() <= building){
                stack.pop()
            }
            stack.push(building)
            result += stack.size-1
        }

        bw.write(result.toString())

        bw.flush()
        bw.close()
    }
}