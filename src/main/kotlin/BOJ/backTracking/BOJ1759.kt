package BOJ.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ1759 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))

        val st = StringTokenizer(br.readLine())
        val st2 = StringTokenizer(br.readLine())

        val L = st.nextToken().toInt()
        val C = st.nextToken().toInt()

        val numArr = Array(C){'x'}

        for(i in 0 until C){
            numArr[i] = st2.nextToken()[0]
        }
        numArr.sort()

        val arr = Array(L){'x'}
        val isUsed = Array(C){false}
        fun func1(s: Int, k: Int){
            if(s == L){
                var v1 = 0
                var v2 = 0
                for(i in 0 until L){
                    if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                        v1++
                    }else v2++

                }

                if(v1 > 0 && v2 > 1) {
                    for (i in 0 until L) {
                        bw.write("${arr[i]}")
                    }
                    bw.write("\n")
                }
                return
            }


            for(i in k until C){
                if(!isUsed[i]){
                    isUsed[i] = true
                    arr[s] = numArr[i]
                    func1(s+1, i+1)
                    isUsed[i] = false
                }
            }
        }

        func1(0, 0)

        bw.flush()
        bw.close()
    }
}