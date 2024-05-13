fun main() {
    val n = readLine()!!.toDouble()
    val min = 1.0
    val max = 100000.0
    println(
        "%.6f".format(
            binarySearch(min, max, {
                n >= (Math.pow(it, 3.0) + it)
            }),
        ),
    )
}

private fun binarySearch(
    min: Double,
    max: Double,
    isOk: (Double) -> Boolean,
): Double {
    var ng = max
    var ok = min
    while (Math.abs(ng - ok) >= 0.001) {
        val mid = (ng + ok) / 2.0
        if (isOk(mid)) {
            ok = mid
        } else {
            ng = mid
        }
    }
    return ok
}
