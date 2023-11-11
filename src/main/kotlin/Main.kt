import kotlinx.coroutines.*
suspend fun main() = coroutineScope {
    val times = Array(3) {0}
    for (i in 0..2) {
        times[i] = getTime(i)
    }
    val sounds = arrayOf("Тик-Тик-Тик", "Так-Так-Так", "Ток-Ток-Ток")
    for (i in 0..2) {
        launch {
            for (j in 1..times[i] / 1000) {
                delay(1000L)
                println(sounds[i])
            }
            println("$i прозвенел")
        }
    }
}

fun getTime(i: Int): Int {
    var time: Int?
    do {
        print("Введите время $i будильника: ")
        time = readlnOrNull()?.toIntOrNull()
    } while (time == null || time <= 0)
    return time * 1000
}