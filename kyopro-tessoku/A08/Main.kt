fun main() {
    val (height, width) = readLine()!!.split(" ").map { it.toInt() }
    val square = mutableListOf<MutableList<Int>>()
    repeat(height) {
        val inputLine = readLine()!!.split(" ").map { it.toInt() }
        val line = mutableListOf<Int>()
        repeat(width + 1) {
            line.add(0)
        }
        var sum = 0
        repeat(inputLine.size) {
            sum += inputLine[it]
            line[it + 1] = sum
        }
        square.add(line)
    }

    val lines = readLine()!!.toInt()
    repeat(lines) {
        val (y1, x1, y2, x2) =
            readLine()!!.split(" ").map { it.toInt() }
        var result = 0
        for (i in y1..y2) {
            result += square[i - 1][x2] - square[i - 1][x1 - 1]
        }
        println(result)
    }
}
