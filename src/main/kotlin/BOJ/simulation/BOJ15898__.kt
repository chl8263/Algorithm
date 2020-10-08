package BOJ.simulation

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

object BOJ15898__ {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var arr = Array(5){Array(5){Pair(0, 'W')}}
    var arr2 = Array(5){Array(5){Pair(0, 'W')}}
    var ans = 0
    lateinit var ingredient: Array<Array<Array<Pair<Int, Char>>>>

    @JvmStatic
    fun main(args: Array<String>){
        val st = StringTokenizer(br.readLine())

        val num  = st.nextToken().toInt()
        ingredient = Array(num){Array(4){Array(4){Pair(0, 'W')}}}
        for(i in 0 until num){
            for(j in 0 until 4){
                val st2 = StringTokenizer(br.readLine())
                for(k in 0 until 4){
                    ingredient[i][j][k] = ingredient[i][j][k].copy(first = st2.nextToken().toInt())
                }
            }

            for(j in 0 until 4){
                val st2 = StringTokenizer(br.readLine())
                for(k in 0 until 4){
                    ingredient[i][j][k] = ingredient[i][j][k].copy(second = st2.nextToken().toCharArray()[0])                }
            }
        }

        var total = 1
        for(i in 0 until num){
            total*=16
        }

        //println("total -> $total")

        for(i in 0 until total){

            var brute = i

            var tempCombi = Array(num){0}
            for(j in 0 until num){
                val t = brute % 16
                tempCombi[j] = t
                brute /= 16
            }

            val isVisited = Array(num){false}
            val dfsList = Array(3){Pair(0, 0)}
            fun dfs(index: Int) {
                if(index == 3){
                    for(k in 0 until 5){
                        for(y in 0 until 5){
                            arr2[k][y] = arr[k][y]
                        }
                    }
                    for(r in 0 until 3){

                        val rotateCnt = dfsList[r].second / 4
                        val putCnt = dfsList[r].second % 4

                        var ingre = ingredient[dfsList[r].first]

                        for(rr in 1..rotateCnt){
                            ingre = rotate(ingre)
                        }
                        putIn(ingre, putCnt)
                    }
                    ans = max(cal(), ans)
                    return
                }

                for(dfs_i in 0 until num){
                    if(!isVisited[dfs_i]){
                        isVisited[dfs_i] = true
                        dfsList[index] = Pair(dfs_i, tempCombi[dfs_i])
                        dfs(index+1)
                        isVisited[dfs_i] = false
                    }
                }
            }

            dfs(0)
        }

        bw.write("$ans")

        bw.flush()
        bw.close()
    }

    fun rotate(t: Array<Array<Pair<Int, Char>>>): Array<Array<Pair<Int, Char>>> {
        val result = Array(4){Array(4){Pair(0, 'W')}}

        for(i in 0 until 4){
            for(j in 0 until 4){
                result[j][4-1-i] = result[j][4-1-i].copy(t[i][j].first, t[i][j].second)
            }
        }
        return result
    }

    fun putIn(t: Array<Array<Pair<Int, Char>>>, num: Int){
        var y = 0
        var x = 0

        if(num == 1){
            y = 0
            x = 1
        }else if(num == 2){
            y = 1
            x = 0
        }else if(num == 3){
            y = 1
            x = 1
        }

        var yy = 0
        for(i in y until y+4){
            var xx = 0
            for(j in x until x+4){
                var quality = t[yy][xx].first + arr2[i][j].first
                var color = 'W'

                if(quality > 9) quality = 9
                else if(quality < 0) quality = 0
                if(t[yy][xx].second != 'W') {
                    color = t[yy][xx].second
                }else {
                    color = arr2[i][j].second
                }

                arr2[i][j] = arr2[i][j].copy(first = quality, second = color)
                xx++
            }
            yy++
        }
    }

    fun cal(): Int{

        var R = 0
        var B = 0
        var G = 0
        var Y = 0

        for(i in 0 until 5){
            for(j in 0 until 5){
                if(arr2[i][j].second == 'R'){
                    R += arr2[i][j].first
                }else if(arr2[i][j].second == 'B'){
                    B += arr2[i][j].first
                }else if(arr2[i][j].second == 'G'){
                    G += arr2[i][j].first
                }else if(arr2[i][j].second == 'Y'){
                    Y += arr2[i][j].first
                }
            }
        }

        R *= 7
        B *= 5
        G *= 3
        Y *= 2

        return R + B + G + Y
    }

}