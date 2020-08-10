package BOJ.bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ5427 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        for(k in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            val x = st2.nextToken().toInt()
            val y = st2.nextToken().toInt()
            val arr = Array(y){Array(x){'x'}}
            val visit_fire = Array(y){Array(x){0}}
            val visit_man = Array(y){Array(x){0}}
            val q_fire: Queue<Pair<Int, Int>> = LinkedList()
            val q_man: Queue<Pair<Int, Int>> = LinkedList()
            val vy = arrayOf(0, 0, 1, -1)
            val vx = arrayOf(1, -1, 0, 0)

            for(i in 0 until y){
                val line = br.readLine()
                for(j in 0 until x){
                    val t = line[j]
                    arr[i][j] = line[j]
                    if(t == '*') {
                        q_fire.add(Pair(i, j))
                        visit_fire[i][j] = 1
                    }else if(t == '#') {
                        visit_fire[i][j] = -1
                        visit_man[i][j] = -1
                    }else if(t == '@'){
                        q_man.add(Pair(i, j))
                        visit_man[i][j] = 1
                    }
                }
            }

            while (q_fire.isNotEmpty()){
                val p = q_fire.poll()
                for(i in 0..3){
                    val dy = p.first + vy[i]
                    val dx = p.second + vx[i]
                    if(dy < 0 || dy >= y || dx < 0 || dx >= x) continue
                    if(arr[dy][dx] == '#') continue
                    if(visit_fire[dy][dx] != 0) continue
                    q_fire.add(Pair(dy, dx))
                    visit_fire[dy][dx] = visit_fire[p.first][p.second] + 1
                }
            }

            var result = 0
            loop@while (q_man.isNotEmpty()){
                val p = q_man.poll()
                for(i in 0..3){
                    val dy = p.first + vy[i]
                    val dx = p.second + vx[i]
                    if(dy < 0 || dy >= y || dx < 0 || dx >= x) {
                        result = visit_man[p.first][p.second]
                        break@loop
                    }
                    if(arr[dy][dx] == '#') continue
                    if(visit_man[dy][dx] != 0) continue
                    if(visit_fire[dy][dx] > 0 && visit_fire[dy][dx] <= visit_man[p.first][p.second] + 1 ) continue
                    q_man.add(Pair(dy, dx))
                    visit_man[dy][dx] = visit_man[p.first][p.second] + 1
                }
            }

            if(result == 0) bw.write("IMPOSSIBLE\n")
            else bw.write("$result\n")

//            for(i in 0 until y){
//                for(j in 0 until x){
//                    //print(arr[i][j])
//                    //print("${visit_fire[i][j]}  ")
//                    print("${visit_man[i][j]}  ")
//                }
//                println()
//            }
//            println()
//
//            for(i in 0 until y){
//                for(j in 0 until x){
//                    //print(arr[i][j])
//                    print("${visit_fire[i][j]}  ")
//                    //print("${visit_man[i][j]}  ")
//                }
//                println()
//            }
//            println()
        }

        bw.flush()
        bw.close()
    }
}