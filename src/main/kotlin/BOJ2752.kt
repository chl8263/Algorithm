import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object BOJ2752 {
    @JvmStatic
    fun main(args: Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val one = st.nextToken().toInt()
        val two = st.nextToken().toInt()
        val three = st.nextToken().toInt()

        val arr = arrayOf(one, two, three)

        for(i in 0 until arr.size){
            if(i == arr.size -1) break
            if(arr[i] > arr[i+1]){
                val t = arr[i+1]
                arr[i+1] = arr[i]
                arr[i] = t
            }
            if(i == 0){
                if(arr[i] > arr[i+2]){
                    val t = arr[i+2]
                    arr[i+2] = arr[i]
                    arr[i] = t
                }
            }
        }
        arr.forEach { print("$it ") }
    }
}