

fun main() {
    val (height, width) = readLine()!!.split(" ").map { it.toInt() }
    val square = mutableListOf<MutableList<Int>>()
    repeat(height) {
        val h = it
        val inputLine = readLine()!!.split(" ").map { it.toInt() }
        val line = MutableList(width) { 0 }

        var sum = 0
        repeat(inputLine.size) {
            val squareSum =
                when (h) {
                    0 -> 0
                    else -> square[h - 1][it]
                }
            sum += inputLine[it]
            line[it] = sum + squareSum
        }
        square.add(line)
    }

    val lines = readLine()!!.toInt()
    repeat(lines) {
        var (y1, x1, y2, x2) =
            readLine()!!.split(" ").map { it.toInt() - 1 }
        val sumY2X1 =
            when (x1 - 1) {
                -1 -> 0
                else -> square[y2][x1 - 1]
            }
        val sumY1X1 =
            when (y1 - 1) {
                -1 -> 0
                else ->
                    when (x1 - 1) {
                        -1 -> 0
                        else -> square[y1 - 1][x1 - 1]
                    }
            }
        val sumY1X2 =
            when (y1 - 1) {
                -1 -> 0
                else -> square[y1 - 1][x2]
            }
        val result = square[y2][x2] + sumY1X1 - sumY2X1 - sumY1X2

        println(result)
    }
}
