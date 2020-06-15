import java.time.format.DateTimeFormatter

object App {
    @JvmStatic
    fun main(args: Array<String>){

        var count = 0
        var price = 362

        val minCal = fun (value: Int): Int {

            val a = value - 100
            val b = value - 50
            val c = value - 1

            count++
            var temp = 0
            if(a < 0 && b < 0) {
                return c
            }

            temp = if(a < 0 && b > 0) {
                b
            } else a
            return temp
        }

        while(price != 0){
            price = minCal(price)
            if(price == 0){
                println(count)
                break
            }
        }
    }
}