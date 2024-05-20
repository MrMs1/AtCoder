fun main() {
    readLine()!!.toInt()
    val costs = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val perCosts = IntArray(costs.size + 1) { 0 }
    perCosts[0] = 0
    perCosts[1] = 0
    perCosts[2] = Math.abs(costs[1] - costs[0])
    for (i in 2 until costs.size) {
        perCosts[i + 1] =
            minOf(
                perCosts[i] + Math.abs(costs[i] - costs[i - 1]),
                perCosts[i - 1] + Math.abs(costs[i] - costs[i - 2]),
            )
    }
    println(perCosts.last())
}
