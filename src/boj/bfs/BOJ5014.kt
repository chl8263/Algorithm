package boj.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ5014 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val F = st.nextToken().toInt()
        val S = st.nextToken().toInt() - 1
        val G = st.nextToken().toInt() - 1
        val U = st.nextToken().toInt()
        val D = st.nextToken().toInt()

        val visit = Array(F){Pair(0, 0)}
        val q: Queue<Int> = LinkedList()
        q.add(S)
        visit[S] = Pair(1, 0)

        while (q.isNotEmpty()){
            val p = q.poll()
            val up = p + U
            val down = p - D
            if(up < F && visit[up].first != 1) {
                q.add(up)
                visit[up] = visit[up].copy(first = 1, second = visit[p].second + 1)
            }
            if(down >= 0 && visit[down].first != 1) {
                q.add(down)
                visit[down] = visit[down].copy(first = 1, second = visit[p].second + 1)
            }
        }

        val result_visit = visit[G].first
        val result = visit[G].second
        if(result_visit == 0 && result == 0)
            bw.write("use the stairs")
        else bw.write("$result")

        bw.flush()
        bw.close()
    }
}
