import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.System.`in`
import java.util.*

fun main(args: Array<String>) {
    val map = Data(TreeMap())
    var exit = false
    while (!exit) {
        println("Введите вид действия:\n1.Добавление пары\n2.Удаление пары\n3.Поиск пары\n4.Завершить программу")
        when (nextInt()) {
            1 -> {
                println("Введите пару в одной строке:")
                val (key, value) = nextLine().split(" ")
                map.add(key, value)
                println("Добавлено!")
            }
            2 -> {
                println("Введите ключ для удаления:")
                val key = nextLine().trim()
                println("Введите значение для удаления:")
                val value = nextLine().trim()
                println(decline(map.delete(key, value)))
            }
            3 -> {
                println("Введите ключ для поиска:")
                val key = nextLine().trim()
                println("Введите значение для поиска:")
                val value = nextLine().trim()
                map.find(key, value).forEach { el -> println("Ключ: ${el.key}, Значение: ${el.value}") }
            }
            4 -> {
                exit = true
                println("До встречи!")
            }
        }
    }
}

fun decline(n: Int) = when (n) {
    in 11..19 -> "Удалено ${n} пар!"
    else -> when (n % 10) {
        1 -> "Удалена ${n} пара!"
        in 2..4 -> "Удалены ${n} пары!"
        else -> "Удалено ${n} пар!"
    }
}

//Scan
var br = BufferedReader(InputStreamReader(`in`))
var st = StringTokenizer("")

fun nextLine() = br.readLine()
fun nextInt() = nextToken().toInt()

fun nextToken(): String {
    while (!st.hasMoreTokens()) {
        st = StringTokenizer(br.readLine())
    }
    return st.nextToken()
}