package bruteForceSearch

import java.time.format.DateTimeFormatter
import java.util.*

object BOJ10448 {
    @JvmStatic
    fun main(args: Array<String>){
        val s = Scanner(System.`in`)
        val given = s.nextInt()
        val givenMatrix = Array<Int>(given){0}
        for(i in 0 until given){
            givenMatrix[i] = s.nextInt()
        }

        val triNumarr = Array(44){i ->  i+1}
        val triNum = triNumarr.map {
            it*(it+1)/2
        }

        givenMatrix.forEachIndexed{ i, x ->
            triNum.forEach {it1 ->
                triNum.forEach {it2 ->
                    triNum.forEach {it3 ->
                        if((it1 + it2 + it3) == x){
                            givenMatrix[i] = 1
                        }
                    }
                }
            }
            if(givenMatrix[i] != 1) givenMatrix[i] = 0
        }
        givenMatrix.forEach { println(it) }
    }
}