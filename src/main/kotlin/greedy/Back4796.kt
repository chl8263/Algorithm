package greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

object Back4796 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))

        val arr = ArrayList<Triple<Int,Int,Int>>()

        while (true){
            val st = StringTokenizer(br.readLine())

            val one = st.nextToken().toInt()
            val two = st.nextToken().toInt()
            val three = st.nextToken().toInt()

            if(one == 0 && two == 0 && three == 0) break

            arr.add(Triple(one, two, three))
        }
    }
}