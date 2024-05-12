fun main() {
    val (n, x) = readLine()!!.split(" ").map { it.toInt() }
    val nums = readLine()!!.split(" ").map { it.toInt() }
    println(binarySearch(1, n, nums, x))
}

private fun binarySearch(
    start: Int,
    max: Int,
    list: List<Int>,
    target: Int,
): Int? {
    val harf = (max + start) / 2
    if (list[harf] > target) {
        return binarySearch(start, harf - 1, list, target)
    }
    if (list[harf] == target) {
        return harf + 1
    }
    if (list[harf] < target) {
        return binarySearch(harf + 1, max, list, target)
    }
    return null
}
