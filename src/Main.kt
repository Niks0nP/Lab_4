import java.io.File

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    readFile()
}

fun readFile() {
    val file = File("task.txt")
    val text = file.readText()

    println(text)
}