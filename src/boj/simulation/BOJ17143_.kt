package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min

class Shark(
    var y: Int,
    var x: Int,
    var s: Int,
    var d: Int,
    var z: Int
) : Comparable<Shark>{
    override fun compareTo(other: Shark): Int {
        if(this.y < other.y) return -1
        else return 1
    }
}

object BOJ17143_ {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var Y = 0
    var X = 0
    //var arr = Array(Y){Array(X){Triple(0, 0, 0)}}
    var sharkList = ArrayList<Shark>()

    val dy = arrayOf(-1, 1, 0, 0)
    val dx = arrayOf(0, 0, 1, -1)

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        Y = st.nextToken().toInt()
        X = st.nextToken().toInt()
        //arr = Array(Y){Array(X){Triple(0, 0, 0)}}
        var num = st.nextToken().toInt()

        for(i in 0 until num){
            val st2 = StringTokenizer(br.readLine())
            val yy = st2.nextToken().toInt() - 1
            val xx = st2.nextToken().toInt() - 1
            val s = st2.nextToken().toInt()
            val d = st2.nextToken().toInt() - 1
            val z = st2.nextToken().toInt()

            //arr[yy][xx] = Triple(s, d, z)
            sharkList.add(Shark(yy, xx, s, d, z))
        }
        var ans = 0
        for(i in 0 until X){
            var result = Int.MAX_VALUE
            var subIndex = 0
            for(k in 0 until sharkList.size){
                if(sharkList[k].x == i){
                    result = min(result, k)
                }
            }
            if(result != Int.MAX_VALUE){
                ans += sharkList[result].z
                sharkList.removeAt(result)
            }

//            var temp = sharkList.filter { it.x == i }
//            if(temp.isNotEmpty()){
//                ans += temp.min()!!.z
//            }
//            loop@for(j in 0 until Y){
//                if(arr[j][i].third != 0) {
//                    ans += arr[j][i].third
//                    arr[j][i] = Triple(0, 0, 0)
//                    break@loop
//                }
//            }
            move()
//            for(i in 0 until Y){
//                for(j in 0 until X){
//                    print(arr[i][j])
//                }
//                println()
//            }
//            println("===============")
        }

        bw.write("$ans")

//        move()
//        for(i in 0 until Y){
//            for(j in 0 until X){
//                print(arr[i][j])
//            }
//            println()
//        }

        bw.flush()
        bw.close()
    }

    fun move(){

        var sub_sharkList = ArrayList<Shark>()

        for(shark in sharkList){
            var location = Pair(shark.y, shark.x)
            var d = shark.d
            var index = 0
            loop@while (true){
                if(index == shark.s) {
                    var fff = false
                    loop2@for(i in 0 until sub_sharkList.size){
                        if(sub_sharkList[i].y == location.first && sub_sharkList[i].x == location.second){
                            if(sub_sharkList[i].z < shark.z){
                                sub_sharkList[i].s = shark.s
                                sub_sharkList[i].d = d
                                sub_sharkList[i].z = shark.z
                            }
                            fff = true
                            break@loop2
                        }
                    }
                    if(!fff){
                        sub_sharkList.add(Shark(location.first, location.second, shark.s, d, shark.z))
                    }

                    break@loop
                }
                val vy = location.first + dy[d]
                val vx = location.second + dx[d]

                if(vy < 0 || vy >= Y || vx < 0 || vx >= X){
                    if(d == 0) d = 1
                    else if(d == 1) d = 0
                    else if(d == 2) d = 3
                    else if(d == 3) d = 2
                }else {
                    location = Pair(vy, vx)
                    index++
                }
            }
        }

        sharkList = sub_sharkList

        //var arr2 = Array(Y){Array(X){Triple(0, 0, 0)}}

//        var arr2 = ArrayList<Triple<Int, Int, Triple<Int, Int, Int>>>()
//
//        for(i in 0 until Y){
//            for(j in 0 until X){
//                if(arr[i][j].third == 0) continue
//
//                var location = Pair(i, j)
//                val t = arr[i][j]
//                val s = t.first
//                var d = t.second
//                val z = t.third
//                var index = 0
//                loop@while (true){
//                    if(index == s) {
//                        val t = arr2.filter { it ->  it.first == location.first && it.second == location.second }.singleOrNull()
//                        if(t == null){
//                            arr2.add(Triple(location.first, location.second, Triple))[location.first][location.second] = Triple(s, d, z)
//                        }
//
//                        if(arr2[location.first][location.second].third != 0){
//                            if(arr2[location.first][location.second].third < t.third){
//                                arr2[location.first][location.second] = Triple(s, d, z)
//                            }
//                        }else {
//                            arr2[location.first][location.second] = Triple(s, d, z)
//                        }
////                        if(arr2[location.first][location.second].third != 0){
////                            if(arr2[location.first][location.second].third < t.third){
////                                arr2[location.first][location.second] = Triple(s, d, z)
////                            }
////                        }else {
////                            arr2[location.first][location.second] = Triple(s, d, z)
////                        }
////                        break@loop
//                    }
//                    val vy = location.first + dy[d]
//                    val vx = location.second + dx[d]
//
//                    if(vy < 0 || vy >= Y || vx < 0 || vx >= X){
//                        if(d == 0) d = 1
//                        else if(d == 1) d = 0
//                        else if(d == 2) d = 3
//                        else if(d == 3) d = 2
//                    }else {
//                        location = Pair(vy, vx)
//                        index++
//                    }
//                }
//            }
//        }
//
//        arr = arr2
//        for(i in 0 until Y) {
//            for (j in 0 until X) {
//                 arr[i][j] = arr2[i][j]
//            }
//        }
    }
}

//
//object BOJ17143_ {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
//
//    var Y = 0
//    var X = 0
//    var arr = Array(Y){Array(X){Triple(0, 0, 0)}}
//
//    val dy = arrayOf(-1, 1, 0, 0)
//    val dx = arrayOf(0, 0, 1, -1)
//
//    @JvmStatic
//    fun main(args: Array<String>){
//        val st = StringTokenizer(br.readLine())
//
//        Y = st.nextToken().toInt()
//        X = st.nextToken().toInt()
//        arr = Array(Y){Array(X){Triple(0, 0, 0)}}
//        var num = st.nextToken().toInt()
//
//        for(i in 0 until num){
//            val st2 = StringTokenizer(br.readLine())
//            val yy = st2.nextToken().toInt() - 1
//            val xx = st2.nextToken().toInt() - 1
//            val s = st2.nextToken().toInt()
//            val d = st2.nextToken().toInt() - 1
//            val z = st2.nextToken().toInt()
//
//            arr[yy][xx] = Triple(s, d, z)
//        }
//        var ans = 0
//        for(i in 0 until X){
//            loop@for(j in 0 until Y){
//                if(arr[j][i].third != 0) {
//                    ans += arr[j][i].third
//                    arr[j][i] = Triple(0, 0, 0)
//                    break@loop
//                }
//            }
//            move()
////            for(i in 0 until Y){
////                for(j in 0 until X){
////                    print(arr[i][j])
////                }
////                println()
////            }
////            println("===============")
//        }
//
//        bw.write("$ans")
//
////        move()
////        for(i in 0 until Y){
////            for(j in 0 until X){
////                print(arr[i][j])
////            }
////            println()
////        }
//
//        bw.flush()
//        bw.close()
//    }
//
//    fun move(){
//        var arr2 = Array(Y){Array(X){Triple(0, 0, 0)}}
//
//        //var arr2 = ArrayList<Triple<Int, Int, Triple<Int, Int, Int>>>()
//
//        for(i in 0 until Y){
//            for(j in 0 until X){
//                if(arr[i][j].third == 0) continue
//
//                var location = Pair(i, j)
//                val t = arr[i][j]
//                val s = t.first
//                var d = t.second
//                val z = t.third
//                var index = 0
//                loop@while (true){
//                    if(index == s) {
////                        val t = arr2.filter { it ->  it.first == location.first && it.second == location.second }.singleOrNull()
////                        if(t == null){
////                            arr2.add(Triple(location.first, location.second, Triple))[location.first][location.second] = Triple(s, d, z)
////                        }
////
////                        if(arr2[location.first][location.second].third != 0){
////                            if(arr2[location.first][location.second].third < t.third){
////                                arr2[location.first][location.second] = Triple(s, d, z)
////                            }
////                        }else {
////                            arr2[location.first][location.second] = Triple(s, d, z)
////                        }
//                        if(arr2[location.first][location.second].third != 0){
//                            if(arr2[location.first][location.second].third < t.third){
//                                arr2[location.first][location.second] = Triple(s, d, z)
//                            }
//                        }else {
//                            arr2[location.first][location.second] = Triple(s, d, z)
//                        }
//                        break@loop
//                    }
//                    val vy = location.first + dy[d]
//                    val vx = location.second + dx[d]
//
//                    if(vy < 0 || vy >= Y || vx < 0 || vx >= X){
//                        if(d == 0) d = 1
//                        else if(d == 1) d = 0
//                        else if(d == 2) d = 3
//                        else if(d == 3) d = 2
//                    }else {
//                        location = Pair(vy, vx)
//                        index++
//                    }
//                }
//            }
//        }
//
//        arr = arr2
////        for(i in 0 until Y) {
////            for (j in 0 until X) {
////                 arr[i][j] = arr2[i][j]
////            }
////        }
//    }
//}