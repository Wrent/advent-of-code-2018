package advent15

abstract class Entity(val printChar: String) {
    val attackPower = 3
    var hp = 200
    var done = false;

    abstract fun getEnemy(): String
}

class Elf : Entity("E") {
    override fun getEnemy(): String {
        return "G"
    }
}

class Goblin : Entity("G") {
    override fun getEnemy(): String {
        return "E"
    }
}