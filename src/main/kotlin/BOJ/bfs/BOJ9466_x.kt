package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ9466_x {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            val length = st2.nextToken().toInt()
            val arr = Array(length){i ->  Pair(i, 0)}
            val visit = Array(length){0}

            val st3 = StringTokenizer(br.readLine())
            for(j in 0 until length){
                val x = st3.nextToken().toInt()
                arr[j] = arr[j].copy(second = x-1)
            }

            val q: Queue<Pair<Int, Int>> = LinkedList()
            var result = 0
            for(j in 0 until length){
                val temp = arr[j]
                if (visit[temp.first] != 1) {
                    visit[temp.first] = 1
                    q.add(temp)

                    while (q.isNotEmpty()) {
                        val peek = q.last()

                        when {
                            peek.second == peek.first -> {
                                result += q.size - 1
                                q.clear()
                            }
                            visit[peek.second] == 1 -> {
                                result += q.size
                                q.clear()
                            }
                            else -> {
                                var t = false
                                q.forEachIndexed loop@{ index, pair ->
                                    if (index != q.size - 1) {
                                        if (peek.second == pair.first) {
                                            result += index - 1
                                            q.clear()
                                            t = true
                                            return@loop
                                        }
                                    }
                                }
                                if (!t) q.add(arr[peek.second])
                            }
                        }
                        visit[peek.second] = 1
                    //}
                    }
                }
            }
            result += q.size
            q.clear()

            bw.write("$result\n")
        }

        bw.flush()
        bw.close()
    }
}
