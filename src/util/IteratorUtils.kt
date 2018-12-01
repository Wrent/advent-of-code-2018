package util

class IteratorUtils {
    companion object {
        fun <T : Any> endlessIterator(input: List<T>): Iterator<T> {
            var index = 0
            return generateSequence { input.get(index++ % input.size) }.iterator()
        }
    }
}