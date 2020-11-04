
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max
import kotlin.math.min

object KAKA {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    @JvmStatic
    fun main(args: Array<String>){

//        val arr = arrayOf(1,2,3,1,2)
//        val x = 1
        val arr = arrayOf(1,1,1)
        val x = 2
//        val arr = arrayOf(8, 2, 4, 6)
//        val x = 2
//        val arr = arrayOf(2, 5, 4, 6, 8)
//        val x = 3
//
//        val isVisited = Array(arr.size){false}
//        val ans = Array(x){0}
//        fun dfs(e: Int, start: Int){
//            if(e == x){
//                for(i in 0 until x){
//                    print("${ans[i]} ")
//                }
//                println()
//                return
//            }
//
//            for(i in start until arr.size){
//                if(isVisited[i]) continue
//                isVisited[i] = true
//                ans[e] = arr[i]
//                dfs(e+1, i)
//                if(e + 1 == x){
//                    isVisited[i] = false
//                }
//
//            }
//        }
//
//        dfs(0, 0)


        var index = 0
        var subIndex = 0
        val t_arr = Array(x){0}
        var ans = 0
        loop@while (true){
            t_arr[subIndex] = arr[index]
            subIndex++
            if(x > 1) {
                if (subIndex == x) {

                    subIndex = 0
                    var s_ans = Int.MAX_VALUE
                    for(i in 0 until x){
                        s_ans = min(s_ans, t_arr[i])
                    }
                    ans = max(ans, s_ans)

                    index -= x-2
                    t_arr.forEach {
                        print(it)
                    }
                    println()

                } else if (subIndex <= x) {
                    index++
                }
            }else if(x == 1) {
                if (subIndex == x) {
                    index++
                    subIndex = 0
                    for(i in 0 until x) {
                        ans = max(ans, t_arr[i])
                    }
                }
            }
            if(index == arr.size) break@loop
        }

        println("$ans")

        bw.flush()
        bw.close()
    }




}