package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ14503 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())
        val st2 = StringTokenizer(br.readLine())

        val y = st.nextToken().toInt()
        val x = st.nextToken().toInt()

        val arr = Array(y){Array(x){0}}

        val currentY = st2.nextToken().toInt()
        val currentX = st2.nextToken().toInt()
        val currentD = st2.nextToken().toInt()

        for(i in 0 until y){
            val st3 = StringTokenizer(br.readLine())
            for(j in 0 until x){
                arr[i][j] = st3.nextToken().toInt()
            }
        }
        val dx = arrayOf(0, 1, 0, -1)
        val dy = arrayOf(-1, 0, 1, 0)
        val q: Queue<Triple<Int, Int, Int>> = LinkedList()
        val isVisit = Array(y){Array(x){false}}

        isVisit[currentY][currentX] = true
        q.add(Triple(currentY, currentX, currentD))

        loop@while(q.isNotEmpty()){
            val p = q.poll()
            var direct = (p.third + 4 - 1) % 4
            var vy = p.first + dy[direct]
            var vx = p.second + dx[direct]

            if(arr[vy][vx] == 1 || isVisit[vy][vx]){
                for(i in 1..3){
                    direct = (direct + 4 - 1) % 4
                    vy = p.first + dy[direct]
                    vx = p.second + dx[direct]
                    if(arr[vy][vx] == 0 && !isVisit[vy][vx]){
                        q.add(Triple(vy, vx, direct))
                        isVisit[vy][vx] = true
                        continue@loop
                    }
                }
                var backDirect = (p.third + 4 - 1) % 4
                backDirect = (backDirect + 4 - 1) % 4
                val backDirectY = p.first + dy[backDirect]
                var backDirectX = p.second + dx[backDirect]
                if(arr[backDirectY][backDirectX] == 1){
                    break@loop
                }else if(arr[backDirectY][backDirectX] == 0 && isVisit[backDirectY][backDirectX]){
                    q.add(Triple(backDirectY, backDirectX, p.third))
                }

            }else if(arr[vy][vx] == 0 && !isVisit[vy][vx]) {
                q.add(Triple(vy, vx, direct))
                isVisit[vy][vx] = true
            }
        }

        var ans = 0

        for(i in 0 until y){
            for(j in 0 until x){
                if(isVisit[i][j]) ans++
            }
        }

        bw.write("$ans")

        bw.flush()
        bw.close()
    }
}