import kotlinx.coroutines.*
import kotlin.math.roundToInt

suspend fun main() = coroutineScope {
    val times = Array(3) {0}
    for (i in 0..2) {
        times[i] = getTime(i)
    }
    val sounds = arrayOf("Тик-Тик-Тик", "Так-Так-Так", "Ток-Ток-Ток")
    for (i in 0..2) {
        launch {
            for (j in 1..(times[i] / 1000.0).roundToInt()) {
                delay(1000L)
                println(sounds[i])
            }
            println("$i прозвенел")
        }
    }
    /*launch {
        for (i in 1..(times[0] / 1000.0).roundToInt()) {
            delay(1000L)
            println("Тик-Тик-Тик")
        }
        println("0 прозвенел")
    }
    launch {
        for (i in 1..(times[1] / 1000.0).roundToInt()) {
            delay(1000L)
            println("Так-Так-Так")
        }
        println("1 прозвенел")
    }
    launch {
        for (i in 1..(times[2] / 1000.0).roundToInt()) {
            delay(1000L)
            println("Ток-Ток-Ток")
        }
        println("2 прозвенел")
    }*/
    Unit
}

fun getTime(i: Int): Int {
    var time: Int?
    do {
        print("Введите время $i будильника: ")
        time = readlnOrNull()?.toIntOrNull()
    } while (time == null || time <= 0)
    return time * 1000
}