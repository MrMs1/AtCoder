fun main() {
    val totalArea = mutableListOf<MutableList<Int>>()
    val (MAX_X, MAX_Y) = 1500 to 1500
    repeat(MAX_Y) {
        totalArea.add(MutableList(MAX_X) { 0 })
    }

    val dotCount = readLine()!!.toInt()
    repeat(dotCount) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() - 1 }
        totalArea[1499 - y][x] += 1
        for (i in x + 1 until MAX_X) { // すべての点を記録した後にx方向の累積和を出していないため、計算が合わない
            val pre =
                when (i - 1) {
                    -1 -> 0
                    else -> totalArea[1499 - y][i - 1]
                }
            totalArea[1499 - y][i] = pre
        }
    }

    repeat(MAX_X) {
        val x = it
        repeat(MAX_Y) {
            val preIndex = it - 1
            val pre =
                when (preIndex) {
                    -1 -> 0
                    else -> totalArea[preIndex][x]
                }
            totalArea[it][x] += pre
        }
    }

    val question = readLine()!!.toInt()
    repeat(question) {
        val (minX, minY, maxX, maxY) = readLine()!!.split(" ").map { it.toInt() - 1 }
        val maxYminX =
            when (minX - 1) {
                -1 -> 0
                else ->
                    when (maxY + 1) {
                        MAX_Y -> 0
                        else -> totalArea[1499 - maxY - 1][minX - 1]
                    }
            }
        val minYminX =
            when (minX - 1) {
                -1 -> 0
                else -> totalArea[1499 - minY][minX - 1]
            }
        val maxYmaxX =
            when (maxY + 1) {
                MAX_Y -> 0
                else -> totalArea[1499 - maxY - 1][maxX]
            }

        val dots = totalArea[1499 - minY][maxX] + maxYminX - minYminX - maxYmaxX
        println(dots)
    }
}
