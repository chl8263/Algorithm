package boj.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ13335 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    @JvmStatic
    fun main(args: Array<String>) {
        val st = StringTokenizer(br.readLine())

        val n = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        val l = st.nextToken().toInt()

        val arr = Array(n) { 0 }

        val st2 = StringTokenizer(br.readLine())
        for (i in 1..n) {
            arr[i - 1] = st2.nextToken().toInt()
        }

        var ans = 0
        val q: Queue<Int> = LinkedList()

        var weight = 0

        for (truck in arr) {
            loop@while (true) {
                if(q.isEmpty()){
                    q.add(truck)
                    ans++
                    weight += truck
                    break@loop
                }else if(q.size == w){
                    weight -= q.poll()
                }else {
                    if(weight + truck > l){
                        q.add(0)
                        ans++
                    }else {
                        q.add(truck)
                        ans++
                        weight += truck
                        break@loop
                    }
                }
            }
        }

        bw.write("${ans+w}")

        bw.flush()
        bw.close()
    }
}