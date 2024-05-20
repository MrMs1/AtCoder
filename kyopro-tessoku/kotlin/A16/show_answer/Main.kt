fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val b = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val perMinutes = mutableListOf<Int>()
    perMinutes.add(0)
    perMinutes.add(a[0])
    for (i in 1 until n - 1) {
        if (perMinutes[i] + a[i] <= perMinutes[i - 1] + b[i - 1]) {
            perMinutes.add(perMinutes[i] + a[i])
        } else {
            perMinutes.add(perMinutes[i - 1] + b[i - 1])
        }
    }
    println(perMinutes.last())
}
