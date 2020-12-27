package boj.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

object BOJ17140 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var r = 0
    var c = 0
    var k = 0

    var arr = Array(100){Array(100){0}}

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        r = st.nextToken().toInt()-1
        c = st.nextToken().toInt()-1
        k = st.nextToken().toInt()

        for(i in 0..2){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0..2){
                arr[i][j] = st2.nextToken().toInt()
            }
        }

        var current_y = 3
        var current_x = 3
        var ans = -1
        loop@for(i in 0..100) {
            if (arr[r][c] == k) {
                ans = i
                break@loop
            } else {
                if (current_x > current_y) {
                    var temp = 0
                    for (k in 0 until current_x) {

                        val numberList = ArrayList<Num>()
                        val amountList = Array(101) { 0 }

                        for (j in 0 until current_y) {
                            val t = arr[j][k]
                            amountList[t] = amountList[t] + 1
                        }

                        for (u in 1..100) {
                            if (amountList[u] == 0) continue
                            numberList.add(Num(u, amountList[u]))
                        }
                        numberList.sort()

                        for (j in 0 until 100) {
                            arr[j][k] = 0
                        }

                        var index = 0
                        for (v in 0 until numberList.size) {
                            if(index > 99) continue
                            arr[index++][k] = numberList[v].number
                            arr[index++][k] = numberList[v].amount
                        }
                        temp = max(temp, index)
                    }
                    current_y = temp

                } else if (current_x <= current_y) {
                    var temp = 0
                    for (k in 0 until current_y) {

                        val numberList = ArrayList<Num>()
                        val amountList = Array(101) { 0 }

                        for (j in 0 until current_x) {
                            val t = arr[k][j]
                            amountList[t] = amountList[t] + 1
                        }

                        for (u in 1..100) {
                            if (amountList[u] == 0) continue
                            numberList.add(Num(u, amountList[u]))
                        }
                        numberList.sort()

                        for (j in 0 until 100) {
                            arr[k][j] = 0
                        }

                        var index = 0
                        for (v in 0 until numberList.size) {
                            if(index > 99) continue
                            arr[k][index++] = numberList[v].number
                            arr[k][index++] = numberList[v].amount
                        }
                        temp = max(temp, index)
                    }
                    current_x = temp
                }
            }
        }

        bw.write("$ans")

        bw.flush()
        bw.close()
    }

    class Num(var number: Int, var amount: Int) : Comparable<Num>{
        override fun compareTo(o: Num): Int {
            if(this.number == o.number){
                if(this.amount < o.amount) return -1
                else return 1
            }else if(this.amount < o.amount){
                return -1
            }else {
                return 1
            }
        }
    }

}