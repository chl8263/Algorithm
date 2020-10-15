package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ13460__ {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var y: Int = 0
    var x: Int = 0

    val dy = arrayOf(0, 0, 1, -1)
    val dx = arrayOf(1, -1, 0, 0)

    lateinit var arr: Array<Array<Char>>
    lateinit var isVisit: Array<Array<Pair<Int, Int>>>
    lateinit var isVisit_r: Array<Array<Pair<Int, Int>>>
    lateinit var isVisit_b: Array<Array<Pair<Int, Int>>>
    lateinit var arr_r: Array<Array<Char>>
    lateinit var arr_b: Array<Array<Char>>

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        y = st.nextToken().toInt()
        x = st.nextToken().toInt()

        arr = Array(y){Array(x){'#'}}
        isVisit = Array(y){Array(x){Pair(-1, -1)}}
        isVisit_r = Array(y){Array(x){Pair(-1, -1)}}
        isVisit_b = Array(y){Array(x){Pair(-1, -1)}}

        var rY = 0
        var rX = 0
        var bY = 0
        var bX = 0
        var oY = 0
        var oX = 0

        for(i in 0 until y){
            val st2 = br.readLine()
            for(j in 0 until x){
                val t = st2[j]
                if(t != '#') arr[i][j] = t
                if(t == 'R'){
                    rY = i
                    rX = j
                }
                if(t == 'B'){
                    bY = i
                    bX = j
                }
                if(t == 'O'){
                    oY = i
                    oX = j
                }
            }
        }

        // flag, direction, count, realCount

        dfs(rY, rX)

        for(i in 0 until y){
            for(j in 0 until x){
                isVisit_r[i][j] = isVisit[i][j]
            }
        }
        isVisit = Array(y){Array(x){Pair(-1, -1)}}

        dfs(bY, bX)

        var ans = 0
        if(isVisit_r[oY][oX].first == -1 || isVisit_r[oY][oX].first >= 10 || (isVisit[oY][oX].first > -1 && isVisit_r[oY][oX].first > isVisit[oY][oX].first)
            || (isVisit_r[oY][oX].first == isVisit[oY][oX].first && isVisit_r[oY][oX].second >= isVisit[oY][oX].second)){
            ans = -1
        }else {
            ans = isVisit_r[oY][oX].first
        }

        bw.write("${ans}")

        for(i in 0 until y){
            for(j in 0 until x){
                print("${isVisit_r[i][j].first}  ")
            }
            println()
        }

        println()

        for(i in 0 until y){
            for(j in 0 until x){
                print("${isVisit_r[i][j].second}  ")
            }
            println()
        }

        println()

        for(i in 0 until y){
            for(j in 0 until x){
                print("${isVisit[i][j].first}  ")
            }
            println()
        }

        println()

        for(i in 0 until y){
            for(j in 0 until x){
                print("${isVisit[i][j].second}  ")
            }
            println()
        }


        bw.flush()
        bw.close()
    }

    fun dfs(initY: Int, initX: Int) {
        val q: Queue<Triple<Int, Int, Int>> = LinkedList()
        q.add(Triple(-1, initY, initX))
        isVisit[initY][initX] = Pair(0, 0)  //count, realCount

        while(q.isNotEmpty()){

            val p = q.poll()
            if(p.first == -1){
                for(i in 0..3){
                    val vy = p.second + dy[i]
                    val vx = p.third + dx[i]
                    if(vy < 0 || vy >= y || vx < 0 || vx >= x) continue
                    if(arr[vy][vx] == '#' || isVisit[vy][vx].first > -1) continue
                    isVisit[vy][vx] = Pair(isVisit[p.second][p.third].first + 1, isVisit[p.second][p.third].second + 1)
                    q.add(Triple(i, vy, vx))
                }
            }else if(p.first >= 0) {
                val vy = p.second + dy[p.first]
                val vx = p.third + dx[p.first]
                if(vy < 0 || vy >= y || vx < 0 || vx >= x) continue
                if(isVisit[vy][vx].first > -1) continue
                if(arr[vy][vx] == '#'){
                    //isVisit[vy][vx] = Pair(isVisit[p.second][p.third].first, isVisit[p.second][p.third].second + 1)
                    q.add(Triple(-1, p.second, p.third))
                }else {
                    isVisit[vy][vx] = Pair(isVisit[p.second][p.third].first, isVisit[p.second][p.third].second + 1)
                    q.add(Triple(p.first, vy, vx))
                }

            }

        }
    }
}