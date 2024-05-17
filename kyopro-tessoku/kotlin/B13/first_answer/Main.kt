fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val items = readLine()!!.split(" ").map { it.toInt() }

    var result = 0
    for (i in 0 until n) {
        var sum = 0
        var index = i
        while (index < n && sum + items[index] <= k) {
            sum += items[index]
            index++
            result++
        }
    }
    println(result)
}
