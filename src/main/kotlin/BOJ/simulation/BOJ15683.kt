package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min

object BOJ15683 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val dy = arrayOf(0, 0, 1, -1)
    val dx = arrayOf(1, -1, 0, 0)

    lateinit var arr: Array<Array<Int>>
    lateinit var arr2: Array<Array<Int>>

    var Y: Int = 0
    var X: Int = 0

    val cctvs = ArrayList<Triple<Int ,Int, Int>>()

    var ans = 0

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())
        Y = st.nextToken().toInt()
        X = st.nextToken().toInt()

        arr = Array(Y){Array(X){0}}
        arr2 = Array(Y){Array(X){0}}

        for(i in 0 until Y){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until X){
                val t = st2.nextToken().toInt()
                arr[i][j] = t
                if(t in 1..5){
                    cctvs.add(Triple(i, j, t))
                }
                if(t == 0) ans++
            }
        }

        var totalPath = 1

        for(i in 0 until cctvs.size){
            totalPath *= 4
        }

        for(path in 0 until totalPath){

            for(i in 0 until Y){
                for(j in 0 until X){
                    arr2[i][j] = arr[i][j]
                }
            }

            var temp = path

            for(j in 0 until cctvs.size){
                var t = temp % 4
                temp /= 4

                val type = cctvs[j].third
                when (type){
                    1 -> {
                        uArr(cctvs[j].first, cctvs[j].second, t)
                    }
                    2 -> {
                        uArr(cctvs[j].first, cctvs[j].second, t)
                        uArr(cctvs[j].first, cctvs[j].second, t+2)
                    }
                    3 -> {
                        uArr(cctvs[j].first, cctvs[j].second, t)
                        uArr(cctvs[j].first, cctvs[j].second, t+1)
                    }
                    4 -> {
                        uArr(cctvs[j].first, cctvs[j].second, t)
                        uArr(cctvs[j].first, cctvs[j].second, t+1)
                        uArr(cctvs[j].first, cctvs[j].second, t+2)
                    }
                    5 -> {
                        uArr(cctvs[j].first, cctvs[j].second, t)
                        uArr(cctvs[j].first, cctvs[j].second, t+1)
                        uArr(cctvs[j].first, cctvs[j].second, t+2)
                        uArr(cctvs[j].first, cctvs[j].second, t+3)
                    }
                }
            }

            var count = 0
            for(i in 0 until Y){
                for(j in 0 until X){
                    if(arr2[i][j] == 0) count++
                }
            }
            ans = min(ans, count)
        }

        bw.write("$ans")

        bw.flush()
        bw.close()
    }

    fun uArr (y: Int, x: Int, dir: Int){
        var d = dir % 4
        var vy = y
        var vx = x
        while (true){
            vy += dy[d]
            vx += dx[d]
            if(vy < 0 || vy >= Y || vx < 0 || vx >= X || arr2[vy][vx] == 6) return
            if(arr2[vy][vx] in 1..5) continue
            arr2[vy][vx] = -1
        }
    }
}

//package BOJ.backTracking
//
//import java.io.BufferedReader
//import java.io.BufferedWriter
//import java.io.InputStreamReader
//import java.io.OutputStreamWriter
//import java.util.*
//
//object BOJ15683 {
//    @JvmStatic
//    fun main(args: Array<String>){
//        val br = BufferedReader(InputStreamReader(System.`in`))
//        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
//        val st = StringTokenizer(br.readLine())
//
//        val Y = st.nextToken().toInt()
//        val X = st.nextToken().toInt()
//
//        var arr = Array(Y){Array(X){0}}
//        val cctvs = ArrayList<Triple<Int ,Int, Int>>()
//
//        for(i in 0 until Y){
//            val st2 = StringTokenizer(br.readLine())
//            for(j in 0 until X){
//                val t = st2.nextToken().toInt()
//                arr[i][j] = t
//                if(t in 1..5){
//                    cctvs.add(Triple(i, j, t))
//                }
//            }
//        }
//
//        for(cctv in cctvs){
//            when(cctv.third){
//                1 -> {
//                    val dy = arrayOf(0, 0, 1, -1)
//                    val dx = arrayOf(1, -1, 0, 0)
//                    var t1 = 0
//                    var total = 0
//                    for(i in 0..3){
//                        val tt =  tried(arr, cctv.first, cctv.second, dy[i], dx[i], Y, X)
//                        if (tt > total) {
//                            total = tt
//                            t1 = i
//                        }
//                    }
//                    arr = draw(arr, cctv.first, cctv.second, dy[t1], dx[t1], Y, X)
//                }
//
//                2 -> {
//                    val dy = arrayOf(0, 0, 1, -1)
//                    val dx = arrayOf(1, -1, 0, 0)
//                    var t1 = 0
//                    var total = 0
//                    for(i in 0..1){
//                        if(i == 0){
//                            val tt1 =  tried(arr, cctv.first, cctv.second, dy[0], dx[0], Y, X)
//                            val tt2 =  tried(arr, cctv.first, cctv.second, dy[1], dx[1], Y, X)
//                            if (tt1 + tt2 > total) {
//                                total = tt1 + tt2
//                                t1 = i
//                            }
//                        }else {
//                            val tt1 =  tried(arr, cctv.first, cctv.second, dy[2], dx[2], Y, X)
//                            val tt2 =  tried(arr, cctv.first, cctv.second, dy[3], dx[3], Y, X)
//                            if (tt1 + tt2 > total) {
//                                total = tt1 + tt2
//                                t1 = i
//                            }
//                        }
//                    }
//                    if(t1 == 0){
//                        arr = draw(arr, cctv.first, cctv.second, dy[0], dx[0], Y, X)
//                        arr = draw(arr, cctv.first, cctv.second, dy[1], dx[1], Y, X)
//                    }else {
//                        arr = draw(arr, cctv.first, cctv.second, dy[2], dx[2], Y, X)
//                        arr = draw(arr, cctv.first, cctv.second, dy[3], dx[3], Y, X)
//                    }
//                }
//
//                3 -> {
//                    val dy = arrayOf(0, 0, 1, -1)
//                    val dx = arrayOf(1, -1, 0, 0)
//                    var t1 = 0
//                    var total = 0
//                    for(i in 0..3){
//                        if(i == 0){
//                            val tt1 =  tried(arr, cctv.first, cctv.second, dy[3], dx[3], Y, X)
//                            val tt2 =  tried(arr, cctv.first, cctv.second, dy[0], dx[0], Y, X)
//                            if (tt1 + tt2 > total) {
//                                total = tt1 + tt2
//                                t1 = i
//                            }
//                        }else if(i == 1){
//                            val tt1 =  tried(arr, cctv.first, cctv.second, dy[0], dx[0], Y, X)
//                            val tt2 =  tried(arr, cctv.first, cctv.second, dy[2], dx[2], Y, X)
//                            if (tt1 + tt2 > total) {
//                                total = tt1 + tt2
//                                t1 = i
//                            }
//                        }else if(i == 2){
//                            val tt1 =  tried(arr, cctv.first, cctv.second, dy[2], dx[2], Y, X)
//                            val tt2 =  tried(arr, cctv.first, cctv.second, dy[1], dx[1], Y, X)
//                            if (tt1 + tt2 > total) {
//                                total = tt1 + tt2
//                                t1 = i
//                            }
//                        }else if(i == 3){
//                            val tt1 =  tried(arr, cctv.first, cctv.second, dy[2], dx[2], Y, X)
//                            val tt2 =  tried(arr, cctv.first, cctv.second, dy[3], dx[3], Y, X)
//                            if (tt1 + tt2 > total) {
//                                total = tt1 + tt2
//                                t1 = i
//                            }
//                        }
//                    }
//                    if(t1 == 0){
//                        arr = draw(arr, cctv.first, cctv.second, dy[3], dx[3], Y, X)
//                        arr = draw(arr, cctv.first, cctv.second, dy[0], dx[0], Y, X)
//                    }else if(t1 == 1){
//                        arr = draw(arr, cctv.first, cctv.second, dy[0], dx[0], Y, X)
//                        arr = draw(arr, cctv.first, cctv.second, dy[2], dx[2], Y, X)
//                    }else if(t1 == 2){
//                        arr = draw(arr, cctv.first, cctv.second, dy[2], dx[2], Y, X)
//                        arr = draw(arr, cctv.first, cctv.second, dy[1], dx[1], Y, X)
//                    }else if(t1 == 3){
//                        arr = draw(arr, cctv.first, cctv.second, dy[2], dx[2], Y, X)
//                        arr = draw(arr, cctv.first, cctv.second, dy[3], dx[3], Y, X)
//                    }
//                }
//
//                4 -> {
//                    val dy = arrayOf(0, 0, 1, -1)
//                    val dx = arrayOf(1, -1, 0, 0)
//                    var t1 = 0
//                    var total = 0
//
//                    val tt1 =  tried(arr, cctv.first, cctv.second, dy[0], dx[0], Y, X)
//                    val tt2 =  tried(arr, cctv.first, cctv.second, dy[1], dx[1], Y, X)
//                    val tt3 =  tried(arr, cctv.first, cctv.second, dy[2], dx[2], Y, X)
//                    val tt4 =  tried(arr, cctv.first, cctv.second, dy[3], dx[3], Y, X)
//
//                    for(i in 0..3){
//                        if(i == 0){
//                            if (tt1 + tt2 + tt4 > total) {
//                                total = tt1 + tt2 + tt4
//                                t1 = i
//                            }
//                        }else if(i == 1){
//                            if (tt1 + tt3 + tt4 > total) {
//                                total = tt1 + tt3 + tt4
//                                t1 = i
//                            }
//                        }else if(i == 2){
//                            if (tt1 + tt2 + tt3 > total) {
//                                total = tt1 + tt2 + tt3
//                                t1 = i
//                            }
//                        }else if(i == 3){
//                            if (tt1 + tt3 + tt4 > total) {
//                                total = tt1 + tt3 + tt4
//                                t1 = i
//                            }
//                        }
//                    }
//                    if(t1 == 0){
//                        arr = draw(arr, cctv.first, cctv.second, dy[0], dx[0], Y, X)
//                        arr = draw(arr, cctv.first, cctv.second, dy[1], dx[1], Y, X)
//                        arr = draw(arr, cctv.first, cctv.second, dy[3], dx[3], Y, X)
//                    }else if(t1 == 1){
//                        arr = draw(arr, cctv.first, cctv.second, dy[0], dx[0], Y, X)
//                        arr = draw(arr, cctv.first, cctv.second, dy[2], dx[2], Y, X)
//                        arr = draw(arr, cctv.first, cctv.second, dy[3], dx[3], Y, X)
//                    }else if(t1 == 2){
//                        arr = draw(arr, cctv.first, cctv.second, dy[0], dx[0], Y, X)
//                        arr = draw(arr, cctv.first, cctv.second, dy[1], dx[1], Y, X)
//                        arr = draw(arr, cctv.first, cctv.second, dy[2], dx[2], Y, X)
//                    }else if(t1 == 3){
//                        arr = draw(arr, cctv.first, cctv.second, dy[0], dx[0], Y, X)
//                        arr = draw(arr, cctv.first, cctv.second, dy[2], dx[2], Y, X)
//                        arr = draw(arr, cctv.first, cctv.second, dy[3], dx[3], Y, X)
//                    }
//                }
//
//                5 -> {
//                    val dy = arrayOf(0, 0, 1, -1)
//                    val dx = arrayOf(1, -1, 0, 0)
//
//                    arr = draw(arr, cctv.first, cctv.second, dy[0], dx[0], Y, X)
//                    arr = draw(arr, cctv.first, cctv.second, dy[1], dx[1], Y, X)
//                    arr = draw(arr, cctv.first, cctv.second, dy[2], dx[2], Y, X)
//                    arr = draw(arr, cctv.first, cctv.second, dy[3], dx[3], Y, X)
//                }
//            }
//        }
//
//        val result = cal(arr)
//
//        bw.write("$result")
//
//        bw.flush()
//        bw.close()
//    }
//
//    fun tried(arr: Array<Array<Int>>, y: Int, x: Int, dy: Int, dx: Int , totalY: Int, totalX: Int): Int{
//
//        var vx = x
//        var vy = y
//        var ans = 0
//        while(true){
//            vx += dx
//            vy += dy
//
//            if(vy < 0 || vx < 0 || vy >= totalY || vx >= totalX || arr[vy][vx] == 6) {
//                break
//            }
//            if(arr[vy][vx] <= 0) {
//                ans++
//            }
//        }
//        return ans
//    }
//
//    fun draw(arr: Array<Array<Int>>, y: Int, x: Int, dy: Int, dx: Int, totalY: Int, totalX: Int): Array<Array<Int>>{
//
//        var vx = x
//        var vy = y
//        while(true){
//            vx += dx
//            vy += dy
//
//            if(vy < 0 || vx < 0 || vy >= totalY || vx >= totalX || arr[vy][vx] == 6) {
//                break
//            }
//
//            if(arr[vy][vx] <= 0) {
//                arr[vy][vx] = -1
//            }
//        }
//        return arr
//    }
//
//    fun cal(arr: Array<Array<Int>>): Int{
//        var ans = 0
//        for((i, arr2) in arr.withIndex()){
//            for((j, value) in arr2.withIndex()){
//                if(arr[i][j] == 0) ans++
//            }
//        }
//        return ans
//    }
//}