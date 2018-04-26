import java.util.*

infix fun String.inl(other: String) = this.toLowerCase() in other.toLowerCase()

class Data(val elements: TreeMap<String, String>) {

    fun add(key: String, value: String) {
        if (key !in elements) elements.put(key, value)
    }

    fun find(key: String, value: String) = elements.filter { el -> key inl el.key && value inl el.value }

    fun delete(key: String, value: String) = find(key, value).keys.map { key -> elements.remove(key) }.count()

}