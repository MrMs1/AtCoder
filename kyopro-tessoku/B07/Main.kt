fun main() {
    val endTime = readLine()!!.toInt()
    val menberNum = readLine()!!.toInt()
    val nums = mutableListOf<Int>()
    repeat((endTime + 2) * 2) {
        nums.add(0)
    }
    for (i in 1..menberNum) {
        val (entry, exit) = readLine()!!.split(" ").map { it.toInt() }
        nums[entry * 2] += 1
        nums[entry * 2 + 1] += 1
        nums[exit * 2 + 1] -= 1
        nums[exit * 2 + 2] -= 1
    }
    var result = 0
    for (i in 0 until endTime) {
        result += nums[i * 2 + 1]
        println(result)
    }
}
