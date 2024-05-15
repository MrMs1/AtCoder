fun main() {
    val (_, k) = readLine()!!.split(" ").map { it.toInt() }
    val nums = readLine()!!.split(" ").map { it.toInt() }
    var result = 0
    for (i in 0 until nums.size) {
        for (j in i until nums.size) {
            if (j + 1 == nums.size) {
                continue
            }
            if (nums[j + 1] - nums[i] <= k) {
                result++
            }
        }
    }
    println(result)
}
