package BOJ.linkedList

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

object BOJ1406_ {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val st = StringTokenizer(br.readLine())
        val st2 = StringTokenizer(br.readLine())

        val wordList = LinkedList<Char>()
        st.nextToken().forEach { wordList.add(it) }

        val num = st2.nextToken().toInt()
        var max = wordList.size
        var cursor = max

        for(i in 1..num){
            val st3 = StringTokenizer(br.readLine())
            while (st3.hasMoreTokens()){
                val command = st3.nextToken()
                when(command){
                    "L" -> {
                        if(cursor != 0) cursor--
                    }
                    "D" -> {
                        if(cursor < max) cursor++
                    }
                    "B" -> {
                        if(cursor > 0) {
                            wordList.removeAt(cursor-1)
                            cursor --
                            max --
                        }
                    }
                    "P" -> {
                        val literal = st3.nextToken()[0]
                        val temp = if(cursor == 0) 0 else cursor
                        wordList.add(temp, literal)
                        cursor++
                        max ++
                    }
                }
            }
        }

        wordList.forEach { bw.write(it.toString()) }

        bw.flush()
        bw.close()
    }
}
