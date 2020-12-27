package boj.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ16235 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var N = 0
    var M = 0
    var K = 0

    var tree = Array(N){Array(N){ArrayList<Int>()}}
    var meal = Array(N){Array(N){5}}
    var deadMeal = Array(N){Array(N){0}}
    var A = Array(N){Array(N){0}}

    val dy = arrayOf(0, 0, 1, -1, 1, -1, 1, -1)
    val dx = arrayOf(1, -1, 0, 0, 1, 1, -1, -1)

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        N = st.nextToken().toInt()
        M = st.nextToken().toInt()
        K = st.nextToken().toInt()

        tree = Array(N){Array(N){ArrayList<Int>()}}
        meal = Array(N){Array(N){5}}
        deadMeal = Array(N){Array(N){0}}
        A = Array(N){Array(N){0}}

        for(i in 0 until N){
            val st2 = StringTokenizer(br.readLine())
            for(j in 0 until N){
                A[i][j] = st2.nextToken().toInt()
            }
        }

        for(i in 0 until M){
            val st3 = StringTokenizer(br.readLine())
            val x = st3.nextToken().toInt() - 1
            val y = st3.nextToken().toInt() - 1
            val old = st3.nextToken().toInt()
            tree[y][x].add(old)
        }

        for(i in 1..K){
            spring()
            summer()
            autom()
            winter()
            
//            for(i in 0 until N){
//                for(j in 0 until N){
//                    val treeList = tree[i][j]
//                    for(treeI in 0 until treeList.size){
//                        print("${treeList[treeI]} ")
//                    }
//                    print(" || ")
//                    println()
//                }
//            }
//            println("================")
        }

        var ans = 0
        for(i in 0 until N){
            for(j in 0 until N){
                ans += tree[i][j].size
            }
        }

        bw.write("$ans")

        bw.flush()
        bw.close()
    }

    fun spring(){
        for(i in 0 until N){
            for(j in 0 until N){
                val treeList = tree[i][j]
                treeList.sort()
                var t_meal = meal[i][j]
                for(treeI in 0 until treeList.size){
                    val treeOld = treeList[treeI]
                    val cal = t_meal - treeOld
                    if (cal < 0) {
                        deadMeal[i][j] += (treeOld/2)
                        treeList.removeAt(treeI)
                    }else {
                        treeList[treeI]++
                        meal[i][j] = cal
                    }
                }
            }
        }
    }

    fun summer(){
        for(i in 0 until N){
            for(j in 0 until N){
                meal[i][j] += deadMeal[i][j]
                deadMeal[i][j] = 0
            }
        }
    }

    fun autom(){
        for(i in 0 until N) {
            for (j in 0 until N) {
                val treeList = tree[i][j]
                for(treeIndex in 0 until treeList.size){
                    if(treeList[treeIndex] % 5 == 0){
                        for(v in 0..7){
                            val vy = i + dy[v]
                            val vx = j + dx[v]
                            if(vy < 0 || vy >= N || vx < 0 || vx >= N) continue
                            tree[vy][vx].add(1)
                        }
                    }
                }
            }
        }
    }

    fun winter(){
        for(i in 0 until N) {
            for (j in 0 until N) {
                meal[i][j] += A[i][j]
            }
        }
    }
}