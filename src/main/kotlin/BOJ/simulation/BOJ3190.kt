package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ3190 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())
        val st2 = StringTokenizer(br.readLine())

        val n = st.nextToken().toInt()
        val arr = Array(n){Array(n){Pair(0, 0)}}

        val appleNum = st2.nextToken().toInt()
        for(i in 0 until appleNum){
            val st3 = StringTokenizer(br.readLine())
            val appleY = st3.nextToken().toInt()
            val appleX = st3.nextToken().toInt()
            arr[appleY-1][appleX-1] = Pair(1, 0)
        }

        val st4 = StringTokenizer(br.readLine())
        val commandNum = st4.nextToken().toInt()
        val commandList = ArrayList<Pair<Int, Char>>()
        for(i in 0 until commandNum){
            val st5 = StringTokenizer(br.readLine())
            val sec = st5.nextToken().toInt()
            val command = st5.nextToken()[0]
            commandList.add(Pair(sec, command))
        }
        val dy = arrayOf(-1, 0, 1, 0)
        val dx = arrayOf(0, 1, 0, -1)

        var tail = Pair(0, 0)
        var ans = 0

        val q: Queue<Triple<Int, Int, Int>> = LinkedList()
        q.add(Triple(1, 0, 0))
        arr[0][0] = Pair(2, 1)

        loop@while(q.isNotEmpty()){
            val p = q.poll()
            val vy = p.second + dy[p.first]
            val vx = p.third + dx[p.first]
            if(vy < 0 || vy >= n || vx < 0 || vx >= n || arr[vy][vx].first == 2){
                break@loop
            }

            var direction = p.first
            for(i in 0 until commandList.size){
                val t = commandList[i]
                if(ans == t.first){
                    if(t.second == 'L'){
                        direction = (p.first + 4 - 1) % 4
                    }else if(t.second == 'D'){
                        direction = (p.first + 4 + 1) % 4
                    }
                    break
                }
            }

            if(arr[vy][vx].first == 0){
                tail = Pair(tail.first + dy[arr[tail.first][tail.second].second],
                    tail.second + dx[arr[tail.first][tail.second].second])
                arr[tail.first][tail.second] = Pair(0, 0)
            }
            arr[vy][vx] = Pair(2, direction)

            q.add(Triple(direction, vy, vx))
            ans++
        }

        bw.write("$ans")

        bw.flush()
        bw.close()
    }
}