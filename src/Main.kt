import java.io.File

fun main() {
    val inputText = readFile()

    val normalizePhoneNumber = normalizePhoneNumbers(text = inputText, newCountryCode = "+1")

    File("task.txt").writeText(normalizePhoneNumber)

    val formattedText = readFile()
    println(formattedText)
}

fun readFile(): String {
    val file = File("task.txt")
    val text = file.readText()

    return text
}

fun normalizePhoneNumbers(text: String, newCountryCode: String): String {
    val phoneRegex = Regex("""(?:\+?\d[\d\s\-\(\)]{9,}\d)""")

    return phoneRegex.replace(text) { matchResult ->
        val raw = matchResult.value

        val digits = raw.filter { it.isDigit() }

        if (digits.length < 10) return@replace raw

        val localNumber = digits.takeLast(10)

        val formatted = "$newCountryCode (${localNumber.substring(0,3)}) " +
                "${localNumber.substring(3,6)}-" +
                "${localNumber.substring(6,8)}-" +
                localNumber.substring(8,10)

        formatted
    }
}