package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

object BOJ14891 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    lateinit var arr: Array<Deque<Int>>

    @JvmStatic
    fun main(args: Array<String>){

        arr = Array<Deque<Int>>(4){LinkedList()}

        for(i in 0..3){
            val st = br.readLine()
            for(j in st){
                arr[i].add(j - '0')
            }
        }

//        for(i in 0..7){
//            print(arr[0].elementAt(i))
//        }
//        println()
//        var t = arr[0].pollLast()
//        arr[0].addFirst(t)
//
//        for(i in 0..7){
//            print(arr[0].elementAt(i))
//        }

        val validation = arrayOf(1, -1)

        val commandNum = br.readLine().toInt()
        for(i in 0 until commandNum){
            val st2 = StringTokenizer(br.readLine())
            val circleNum = st2.nextToken().toInt()
            val command = st2.nextToken().toInt()
            val visited = Array(4){false}
            val q: Queue<Pair<Int, Int>> = LinkedList()

            q.add(Pair(circleNum-1, command))
            visited[circleNum-1] = true
            while (q.isNotEmpty()){
                val p = q.poll()
                for(k in validation){
                    val vx = p.first + k
                    if(vx < 0 || vx >= 4 || visited[vx]) continue
                    if(k == 1
                        && arr[p.first].elementAt(2) != arr[vx].elementAt(6)){
                        q.add(Pair(vx, -p.second))
                        visited[vx] = true
                    }else if(k == -1
                        && arr[p.first].elementAt(6) != arr[vx].elementAt(2)){
                        q.add(Pair(vx, -p.second))
                        visited[vx] = true
                    }
                }
                operate(p.first, p.second)
            }
        }

        var ans = 0

        for(i in 0..3){
            val p = arr[i].elementAt(0)
            //println(p)
            val result = p.shl(i)
            ans+=result
        }

        bw.write("$ans")

        bw.flush()
        bw.close()
    }

    fun operate(num: Int, command: Int){
        if(command == 1){
            val last = arr[num].pollLast()
            arr[num].addFirst(last)
        }else {
            val first = arr[num].pollFirst()
            arr[num].addLast(first)
        }
    }
}