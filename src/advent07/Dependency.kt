package advent07

class Dependency() {
    val dependencies: MutableSet<String> = mutableSetOf()

    fun add(dependency: String) {
        dependencies.add(dependency)
    }
}