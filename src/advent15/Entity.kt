package advent15

abstract class Entity(val printChar: String, val attackPower: Int) {
    var hp = 200
    var done = false

    abstract fun getEnemy(): String
}

class Elf(attackPower: Int) : Entity("E", attackPower) {

    override fun getEnemy(): String {
        return "G"
    }
}

class Goblin : Entity("G", 3) {
    override fun getEnemy(): String {
        return "E"
    }
}