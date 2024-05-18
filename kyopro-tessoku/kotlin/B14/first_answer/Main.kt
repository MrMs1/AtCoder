

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val cards = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    val beforeCards = cards.sliceArray(0 until n / 2)
    val afterCards = cards.sliceArray(n / 2 until n)
    val beforeSum = bitSearch(beforeCards.size, beforeCards)
    val afterSum = bitSearch(afterCards.size, afterCards)
    beforeSum.sort()

    for (i in 0 until afterSum.size) {
        val x = binarySearch(0, beforeSum.size - 1) { afterSum[i] + beforeSum[it] <= k }
        if (afterSum[i] + beforeSum[x] == k) {
            println("Yes")
            return
        }
    }
    println("No")
}

private fun binarySearch(
    min: Int,
    max: Int,
    isOk: (Int) -> Boolean,
): Int {
    var ng = max
    var ok = min
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

private fun bitSearch(
    n: Int,
    intArray: IntArray,
): IntArray {
    val res = IntArray(1 shl n) { 0 }
    for (bit in 1 until (1 shl n)) {
        if (bit == 1) {
            res[bit] = intArray[0]
            continue
        }
        var sum = 0
        for (i in 0 until n) {
            if (bit and (1 shl i) != 0) {
                sum += intArray[i]
            }
        }
        res[bit] = sum
    }
    return res
}
