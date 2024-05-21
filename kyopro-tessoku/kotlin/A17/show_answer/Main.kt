fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val b = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val perMinutes = mutableListOf<Int>()
    perMinutes.add(0)
    perMinutes.add(a[0])
    for (i in 1 until n - 1) {
        perMinutes.add(minOf(perMinutes[i] + a[i], perMinutes[i - 1] + b[i - 1]))
    }
    val route = mutableListOf<Int>()
    var room = n
    route.add(room)
    while (room > 1) {
        if (perMinutes[room - 2] + a[room - 2] == perMinutes[room - 1]) {
            room--
        } else {
            room -= 2
        }
        route.add(room)
    }

    route.reverse()
    println(route.size)
    println(route.joinToString(" "))
}
