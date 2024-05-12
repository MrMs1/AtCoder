fun main() {
    val (_, k) = readLine()!!.split(" ").map { it.toLong() }
    val printers = readLine()!!.split(" ").map { it.toInt() }
    val min = 1
    val max = Math.pow(10.0, 9.0).toInt()
    println(
        binarySearch(min, max, {
            var sum = 0L
            val sec = it
            printers.forEach { el ->
                sum += sec / el
            }
            sum >= k
        }),
    )
}

private fun binarySearch(
    min: Int,
    max: Int,
    isOk: (Int) -> Boolean,
): Int {
    var ng = min
    var ok = max
    while (Math.abs(ng - ok) > 1) {
        val mid = (ng + ok) / 2
        if (isOk(mid)) {
            ok = mid
        } else {
            ng = mid
        }
    }
    return ok
}
