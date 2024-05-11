fun main() {
    val roomNumber = readLine()!!.toInt()
    val rooms = readLine()!!.split(" ").map { it.toInt() }
    val days = readLine()!!.toInt()
    val leftMax = rooms.toMutableList()
    val rightMax = rooms.toMutableList()
    repeat(roomNumber) {
        val max =
            if (it == 0) {
                leftMax[it]
            } else if (leftMax[it] > leftMax[it - 1]) {
                leftMax[it]
            } else {
                leftMax[it - 1]
            }
        leftMax[it] = max
    }
    for (i in roomNumber - 1 downTo 0) {
        val max =
            if (i == roomNumber - 1) {
                rightMax[i]
            } else if (rightMax[i] > rightMax[i + 1]) {
                rightMax[i]
            } else {
                rightMax[i + 1]
            }
        rightMax[i] = max
    }
    repeat(days) {
        val (L, R) = readLine()!!.split(" ").map { it.toInt() }
        val result =
            if (leftMax[L - 2] > rightMax[R]) {
                leftMax[L - 2]
            } else {
                rightMax[R]
            }
        println(result)
    }
}
