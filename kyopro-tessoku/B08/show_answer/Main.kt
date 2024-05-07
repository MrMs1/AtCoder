fun main() {
    val totalArea = mutableListOf<MutableList<Int>>()
    val (MAX_X, MAX_Y) = 1501 to 1501
    repeat(MAX_Y) {
        totalArea.add(MutableList(MAX_X) { 0 })
    }

    val dotCount = readLine()!!.toInt()
    // 座標の記録
    repeat(dotCount) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        totalArea[MAX_Y - y][x] += 1
    }
    // x方向の累積和
    for (y in 1 until MAX_Y) {
        for (x in 1 until MAX_X) {
            totalArea[MAX_Y - y][x] += totalArea[MAX_Y - y][x - 1]
        }
    }
    // y方向の累積和
    for (x in 1 until MAX_X) {
        for (y in 1 until MAX_Y) {
            totalArea[y][x] += totalArea[y - 1][x]
        }
    }

    val question = readLine()!!.toInt()
    repeat(question) {
        var (minX, minY, maxX, maxY) = readLine()!!.split(" ").map { it.toInt() }

        val dots = totalArea[MAX_Y - minY][maxX] + totalArea[MAX_Y - maxY - 1][minX - 1] - totalArea[MAX_Y - minY][minX - 1] - totalArea[MAX_Y - maxY - 1][maxX]

        println(dots)
    }
}
