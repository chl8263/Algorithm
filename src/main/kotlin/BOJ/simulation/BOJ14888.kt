package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ14888 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val numS = Stack<Int>()
    val operatorS = Stack<Int>()

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        val num = st.nextToken().toInt()

        val st2 = StringTokenizer(br.readLine())
        for(i in 0 until num){
            numS.add(st2.nextToken().toInt())
        }

        val st3 = StringTokenizer(br.readLine())
        for(i in 0..3){
            val t = st3.nextToken().toInt()
            for(j in 0 until t){
                operatorS.add(i)
            }
        }

        val operatorNum = operatorS.size
        val visited = Array(operatorNum){false}
        val order = Array(operatorNum){0}
        fun dfs(c: Int){

            if(c == operatorNum){
                for(i in order){
                    print(order[i])
                }
                println()
                return
            }

            for(i in 0 until operatorNum){
                if(visited[i]) continue
                order[c] = i
                visited[i] = true
                dfs(c + 1)
                visited[i] = false
            }
        }

        dfs(0)

        bw.flush()
        bw.close()
    }
}