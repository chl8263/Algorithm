package boj.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max
import kotlin.math.min

object BOJ14888 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val numS: Queue<Int> = LinkedList()
    val numS2: Queue<Int> = LinkedList()
    val operatorS = ArrayList<Int>()

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

        var ansMax = -1000000000
        var ansMin = 1000000000

        fun duplicate(){
            numS2.clear()
            for(i in numS){
                numS2.add(i)
            }
        }

        fun dfs(c: Int){
            if(c == operatorNum){
                duplicate()
                var result = 0
                result += numS2.poll()
                for(i in order){
                    val t = operatorS[i]
                    when(t){
                        0 -> {
                            result += numS2.poll()
                        }
                        1 -> {
                            result -= numS2.poll()
                        }
                        2 -> {
                            result *= numS2.poll()
                        }
                        3 -> {
                            val tt = numS2.poll()
                            if(result < 0 && tt > 0){
                                result = -result
                                result /= tt
                                result = -result
                            }else {
                                result /= tt
                            }
                        }
                    }
                }
                ansMax = max(ansMax, result)
                ansMin = min(ansMin, result)
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

        bw.write("$ansMax\n")
        bw.write("$ansMin")

        bw.flush()
        bw.close()
    }
}