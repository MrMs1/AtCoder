fun main() {
    val papers = readLine()!!.toInt()
    val (maxHeight, maxWidth) = 1501 to 1501
    val area = MutableList(maxHeight) { MutableList(maxWidth) { 0 } }

    repeat(papers) {
        val (leftBottomW, leftBottomH, rightTopW, rightTopH) = readLine()!!.split(" ").map { it.toInt() }
        area[leftBottomH][leftBottomW] += 1
        area[rightTopH][leftBottomW] -= 1
        area[leftBottomH][rightTopW] -= 1
        area[rightTopH][rightTopW] += 1
    }
    for (h in 0 until maxHeight) { // 座標は0がありうる
        for (w in 1 until maxWidth) { // 累積和はインデックス番号1からで良い
            area[h][w] += area[h][w - 1]
        }
    }
    for (w in 0 until maxWidth) {
        for (h in 1 until maxHeight) {
            area[h][w] += area[h - 1][w]
        }
    }
    var result = 0
    for (w in 0 until maxWidth) {
        for (h in 0 until maxHeight) {
            if (area[h][w] >= 1) result++
        }
    }
    println(result)
}
