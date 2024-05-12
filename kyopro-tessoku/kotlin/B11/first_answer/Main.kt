fun main() {
    readLine()
    val nums = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val q = readLine()!!.toInt()
    repeat(q) {
        val x = readLine()!!.toInt()
        val count = nums.lowerBound(x)
        println(count)
    }
}

fun List<Int>.lowerBound(value: Int): Int {
    val result = this.binarySearch(value)
    return if (result < 0) {
        -result - 1
    } else {
        result
    }
}
