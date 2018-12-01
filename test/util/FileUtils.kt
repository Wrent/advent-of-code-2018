package util

import java.io.File

class FileUtils {
    companion object {
        fun readFileDirectlyAsText(fileName: String): String = File(fileName).readText(Charsets.UTF_8)
    }
}