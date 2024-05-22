// ダウンロードした問題サンプルでは不正解になるが、提出すると正解になる
fun main() {
    val n = readLine()!!.toInt()
    val h = (mutableListOf(0) + readLine()!!.split(" ").map { it.toInt() }).toIntArray()
    val costs = IntArray(n + 1) { 0 }
    val route = mutableListOf<Int>()
    costs[2] = Math.abs(h[2] - h[1])
    for (i in 3..n) {
        costs[i] =
            minOf(
                costs[i - 1] + Math.abs(h[i] - h[i - 1]),
                costs[i - 2] + Math.abs(h[i] - h[i - 2]),
            )
    }
    var nowPosition = n
    while (true) {
        route.add(nowPosition)
        if (nowPosition <= 1) {
            break
        }
        if (costs[nowPosition - 1] + Math.abs(h[nowPosition - 1] - h[nowPosition]) == costs[nowPosition]) {
            nowPosition--
        } else {
            nowPosition -= 2
        }
    }
    println(route.size)
    println(route.reversed().joinToString(" "))
}
