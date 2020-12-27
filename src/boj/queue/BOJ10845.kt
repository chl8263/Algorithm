package boj.queue

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ10845 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        val queue = Array<Int>(100000){0}
        var head = 0
        var rear = 0

        for(i in 1..num){
            val st2 = StringTokenizer(br.readLine())
            when(st2.nextToken()){
                "push" -> {
                    val value = st2.nextToken().toInt()
                    queue[rear] = value
                    rear++
                }
                "pop" -> {
                    if(rear - head == 0){
                        bw.write("-1\n")
                    }else {
                        bw.write("${queue[head]}\n")
                        head++
                    }
                }
                "front" -> {
                    if(rear - head == 0){
                        bw.write("-1\n")
                    }else {
                        bw.write("${queue[head]}\n")
                    }
                }
                "back" -> {
                    if(rear - head == 0){
                        bw.write("-1\n")
                    }else {
                        bw.write("${queue[rear-1]}\n")
                    }
                }
                "size" -> {
                    bw.write("${rear-head}\n")
                }
                "empty" -> {
                    if(rear - head == 0){
                        bw.write("1\n")
                    }else {
                        bw.write("0\n")
                    }
                }
            }
        }

        bw.flush()
        bw.close()
    }
}