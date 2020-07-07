package BOJ.bruteForceSearch

object BOJ2309 {
    @JvmStatic
    fun main(args: Array<String>){

//        val s = Scanner(System.`in`)
//
//        val given = mutableListOf<Int>()
//
//        for(i in 1..9){
//            given.add(s.nextInt())
//        }

        val given = arrayOf(20,7,23,19,10,15,25,8,13)

        var result = listOf<Int>()

        for((i,v) in given.withIndex()){

            for((j,v) in given.withIndex()){
                if(i != j){
                    val filter = given.filter { x -> x != given[i] && x != given[j]}
                    val reducer = filter.fold(0){ acc, value -> acc + value }
                    if(reducer == 100){
                        result = filter.sorted()
                        break
                    }
                }
            }
        }

        result.forEach {
            println(it)
        }
    }
}