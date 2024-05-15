fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val nums = readLine()!!.split(" ").map { it.toInt() }
    var results = LongArray(n) { 0 }
    for (i in 0 until n - 1) {
        if (i != 0) {
            results[i] = results[i - 1]
        }
        while (results[i] < n && nums[ results[i].toInt()] - nums[i] <= k) {
            results[i] += 1L
        }
    }
    var result = 0L
    for (i in 0..n - 1) {
        result += (results[i] - i).toLong()
    }
    results.map { it.toLong() }.sum()
    println(result)
}
