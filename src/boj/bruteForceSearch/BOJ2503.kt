package BOJ.bruteForceSearch

import java.util.*

object BOJ2503 {
    @JvmStatic
    fun main(args: Array<String>) {
        val s = Scanner(System.`in`)
        val given = s.nextInt()
        s.nextLine()

        var result = 0

        val gameArr = Array<String>(given) { "" }

        for (i in 0 until gameArr.size) {
            gameArr[i] = s.nextLine()//.split("")
        }

        loop@ for (i in 123..999) {
            val tempI = i.toString()
            if (i.toString()[0] == '0' || i.toString()[1] == '0' || i.toString()[2] == '0')
                continue

            if(tempI[0] == tempI[1] || tempI[0] == tempI[2] || tempI[1] == tempI[2])
                continue

            var O_s = 0
            var O_b = 0
            var s = 0
            var b = 0

            for(j in gameArr){
                val a = j.split(" ")
                val num = a[0]
                val strike = a[1].toInt()
                val ball = a[2].toInt()
                O_s += strike
                O_b += ball

                if(tempI == num)
                    continue@loop

                for((k,v) in num.withIndex()){
                    for((k2,v2) in tempI.withIndex()){
                        if(k == k2 && v == v2) s++
                        else if(k != k2 && v == v2) b ++
                    }
                }
            }
            if(O_s == s && O_b == b) result ++
        }

        println(result)
    }
}