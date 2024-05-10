fun main() {
    val (height, width, days) = readLine()!!.split(" ").map { it.toInt() }
    val square = MutableList(height + 1) { MutableList(width + 1) { 0 } }

    repeat(days) {
        val (leftH, LeftW, rightH, rightW) = readLine()!!.split(" ").map { it.toInt() }
        for (i in leftH..rightH) {
            for (j in LeftW..rightW) {
                square[i][j] += 1
            }
        }
    }

    for (i in 1..height) {
        for (j in 1..width) {
            print("${square[i][j]}")
            if (j < width) {
                print(" ")
            }
        }
        println("")
    }
}
