package boj.recursion

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ17478 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val num = st.nextToken().toInt()


        fun func1(i: Int, prefixCount: Int){
            if(i == -1) return
            var prefix = ""
            for(k in 1..prefixCount){
                prefix += "_"
            }

            bw.write("${prefix}\"재귀함수가 뭔가요?\"\n")

            if(i == 0){
                bw.write("${prefix}\"재귀함수는 자기 자신을 호출하는 함수라네\"\n")
            }else {
                bw.write("${prefix}\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n")
                bw.write("${prefix}마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n")
                bw.write("${prefix}그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n")
            }
            func1(i - 1, prefixCount + 4)

            if(i == -1){
                bw.write("${prefix}라고 답변하였지.")
            }else {
                bw.write("${prefix}라고 답변하였지.\n")
            }

        }

        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n")

        func1(num, 0)

        bw.flush()
        bw.close()
    }
}