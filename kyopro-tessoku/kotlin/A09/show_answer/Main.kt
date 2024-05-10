fun main() {
    val (height, width, days) = readLine()!!.split(" ").map { it.toInt() }
    val square = MutableList(height + 2) { MutableList(width + 2) { 0 } }

    repeat(days) {
        val (leftH, LeftW, rightH, rightW) = readLine()!!.split(" ").map { it.toInt() }
        square[leftH][LeftW] += 1
        square[rightH + 1][LeftW] -= 1
        square[leftH][rightW + 1] -= 1
        square[rightH + 1][rightW + 1] += 1
    }

    // 縦方向の累積和
    for (w in 1..width) {
        for (h in 1..height) {
            square[h][w] += square[h - 1][w]
        }
    }
    // 横方向の累積和
    for (h in 1..height) {
        for (w in 1..width) {
            square[h][w] += square[h][w - 1]
            print("${square[h][w]}")
            if (w < width) {
                print(" ")
            }
        }
        println("")
    }
}
