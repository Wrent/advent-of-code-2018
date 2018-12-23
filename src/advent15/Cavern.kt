package advent15

abstract class Cavern(val printChar: String) {

    fun print(): String {
        if (entity == null) {
            return printChar
        } else {
            return entity!!.printChar
        }
    }

    abstract fun hasEntity(): Boolean
    abstract fun hasEntity(entity: String): Boolean
    abstract fun isEmpty(): Boolean

    var entity: Entity? = null

}

class Cave : Cavern(".") {

    override fun hasEntity(): Boolean {
        return entity != null
    }

    override fun hasEntity(entity: String): Boolean {
        if (this.entity == null) {
            return false
        }
        return entity.equals(this.entity?.printChar)
    }

    override fun isEmpty(): Boolean {
        return entity == null
    }
}

class Wall : Cavern("#") {
    override fun hasEntity(entity: String): Boolean {
        return false
    }

    override fun isEmpty(): Boolean {
        return false
    }

    override fun hasEntity(): Boolean {
        return false
    }
}