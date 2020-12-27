package boj.recursion

import java.util.*

object BOJ1629 {
    @JvmStatic
    fun main(args: Array<String>){
        val sc = Scanner(System.`in`)
        val A = sc.nextInt()
        var B = sc.nextInt()
        val mod = sc.nextInt()

        var ans: Long = 1
        var multiply = A % mod.toLong()

        while (B > 0) {
            if (B % 2 == 1) {
                ans *= multiply
                ans %= mod.toLong()
            }
            multiply = multiply % mod * (multiply % mod) % mod
            B /= 2
        }
        print(ans)
    }
}