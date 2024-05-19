fun main() {
    val n = readLine()!!.trim().toInt()
    val a = readLine()!!.trim().split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()
    val b = a.copyOf().distinct().sorted()
    val results = mutableListOf<Int>()

    for (i in 0 until n) {
        val index = binarySearch(-1, b.size, { a[i] <= b[it] })
        results.add(index + 1)
    }
    results.forEachIndexed { index, result ->
        print(result)
        if (index != results.size - 1) {
            print(" ")
        } else {
            print("\n")
        }
    }
}

private fun binarySearch(
    min: Int,
    max: Int,
    isOk: (Int) -> Boolean,
): Int {
    var ng = min
    var ok = max
    while (Math.abs(ok - ng) > 1) {
        val mid = (ok + ng) / 2
        if (isOk(mid)) {
            ok = mid
        } else {
            ng = mid
        }
    }
    return ok
}
