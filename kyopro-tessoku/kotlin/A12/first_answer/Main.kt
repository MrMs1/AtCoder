fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val printers = readLine()!!.split(" ").map { it.toInt() }
    var sum = MutableList(k) { 0 }
    repeat(n) {
        for (i in 0 until sum.size) {
            if ((i + 1) % printers[it] == 0) {
                sum[i]++
            }
        }
    }
    val csum = sum.scan(sum[0], Int::plus)
    println(binarySearch(0, csum.size, { csum[it] >= k }) + 1)
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
