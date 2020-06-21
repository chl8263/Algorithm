package bruteForceSearch

import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

object Back3085 {
    @JvmStatic
    fun main(args: Array<String>) {
        val s = Scanner(System.`in`)
        val given = s.nextInt()
        val matrix = Array(given){Array(given){'0'}}
        var result = 0

        val validator = { i: Int, j: Int ->
            i >= 0 && i < given && j >= 0 && j < given
        }

        val matrixCandy = { i: Int, j: Int ->
            var subCount = 1
            var subMaxCount = 1
            var subChar = '0'
            matrix[i].forEachIndexed { i, it ->
                if(subChar == it){
                    subCount ++
                    if(subCount > subMaxCount) subMaxCount = subCount
                }else {
                    subChar = it
                    if(subCount > subMaxCount) subMaxCount = subCount
                    subCount = 1
                }
            }

            var yMatrix = Array<Char>(given){'0'}
            matrix.forEachIndexed { ii , it ->
                it.forEachIndexed { jj , x ->
                   if(j == jj)
                       yMatrix[ii] = x
                }
            }

            var ysubCount = 1
            var ysubMaxCount = 1
            var ysubChar = '0'
            yMatrix.forEachIndexed { i, it ->
                if(ysubChar == it){
                    ysubCount ++
                    if(ysubCount > ysubMaxCount) ysubMaxCount = ysubCount
                }else {
                    ysubChar = it
                    if(ysubCount > ysubMaxCount) ysubMaxCount = ysubCount
                    ysubCount = 1
                }
            }
            if(subMaxCount > ysubMaxCount) subMaxCount
            else ysubMaxCount
        }

        matrix.forEachIndexed { i , it ->
            val color = s.next()
            it.forEachIndexed { j , x ->
                matrix[i][j] = color[j]
            }
        }

        matrix.forEachIndexed { i , it ->
            it.forEachIndexed { j , x ->
                if(validator(i, j+1)){
                    val temp = matrix[i][j]
                    val temp2 = matrix[i][j+1]
                    matrix[i][j] = temp2
                    matrix[i][j+1] = temp
                    if(matrixCandy(i, j) > result)
                        result = matrixCandy(i, j)
                    matrix[i][j] = temp
                    matrix[i][j+1] = temp2
                }

                if(validator(i+1, j)){
                    val temp = matrix[i][j]
                    val temp2 = matrix[i+1][j]
                    matrix[i][j] = temp2
                    matrix[i+1][j] = temp
                    if(matrixCandy(i, j) > result)
                        result = matrixCandy(i, j)
                    matrix[i][j] = temp
                    matrix[i+1][j] = temp2
                }
                if(validator(i, j-1)){
                    val temp = matrix[i][j]
                    val temp2 = matrix[i][j-1]
                    matrix[i][j] = temp2
                    matrix[i][j-1] = temp
                    if(matrixCandy(i, j) > result)
                        result = matrixCandy(i, j)
                    matrix[i][j] = temp
                    matrix[i][j-1] = temp2
                }
                if(validator(i-1, j)){
                    val temp = matrix[i][j]
                    val temp2 = matrix[i-1][j]
                    matrix[i][j] = temp2
                    matrix[i-1][j] = temp
                    if(matrixCandy(i, j) > result)
                        result = matrixCandy(i, j)
                    matrix[i][j] = temp
                    matrix[i-1][j] = temp2
                }
            }
        }
        println(result)
    }
}