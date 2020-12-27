package boj.recursion

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ1780 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()

        val arr = Array(num){Array(num){-1}}

        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until num){
                val x = st2.nextToken().toInt()
                arr[i][j] = x
            }
        }

        var a = 0
        var b = 0
        var c = 0

        fun cal (x: Int) {
            if(x == -1) {
                a++
            } else if(x == 0) {
                b++
            }else if(x == 1) {
                c++
            }
        }

        fun cal_ (x: Int) {
            if(x == -1) {
                a--
            } else if(x == 0) {
                b--
            }else if(x == 1) {
                c--
            }
        }

        fun func1 (n: Int, y: Int, x: Int): Int {
            if(n == 1) return arr[y][x]

            val devidedN = n / 3

            val v = func1(devidedN, y, x)
            val v2 = func1(devidedN, y, devidedN + x)
            val v3 = func1(devidedN, y, (devidedN * 2) + x)

            val v4 = func1(devidedN, devidedN + y, x)
            val v5 = func1(devidedN, devidedN + y, devidedN + x)
            val v6 = func1(devidedN, devidedN + y, (devidedN * 2) + x)

            val v7 = func1(devidedN, (devidedN * 2) + y, x)
            val v8 = func1(devidedN, (devidedN * 2) + y, devidedN + x)
            val v9 = func1(devidedN, (devidedN * 2) + y, (devidedN * 2) + x)


                if(v >= -1 && n == 3){
                    if(v == v2 && v == v3 && v == v4 && v == v5
                        && v == v6 && v == v7 && v == v8 && v == v9){
                        cal(v)
                        return v
                    }else {
                        cal(v); cal(v2); cal(v3); cal(v4); cal(v5); cal(v6); cal(v7); cal(v8); cal(v9)
                        return -3
                    }
                } else if(n > 3) {
                    if(v == v2 && v == v3 && v == v4 && v == v5
                        && v == v6 && v == v7 && v == v8 && v == v9){
                        for(i in 1..8) {
                            cal_(v)
                        }
                        return v
                    }else {
                        return -3
                    }
                }
            return -2
        }

        val result = func1(num, 0, 0)

        if (result >= -1){
            cal(result)
        }

        bw.write("$a\n")
        bw.write("$b\n")
        bw.write("$c\n")

        bw.flush()
        bw.close()
    }
}