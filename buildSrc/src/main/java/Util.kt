import java.io.File

fun String.exec(rootDir: File): Process = Runtime.getRuntime().exec(this, null, rootDir)

val Process.text
    get() = inputStream.bufferedReader().use { it.readLine() }.trim()
