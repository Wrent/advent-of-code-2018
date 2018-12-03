package advent03

class FabricProcessor(val input: String) {
    fun getOverlapCount(): Int {
        val cutPlans = getCutPlans()
        val fabric = fillFabric(cutPlans)

        return fabric.values
            .flatMap { it.values }
            .filter { it > 1 }
            .count()

    }

    fun getNotOverlappingId(): String {
        val cutPlans = getCutPlans()
        val fabric = fillFabric(cutPlans)

        for (cutPlan in cutPlans) {
            if (!cutPlan.overlaps(fabric)) {
                return cutPlan.id
            }
        }
        throw RuntimeException("Nothing was found.")
    }

    private fun fillFabric(cutPlans: List<CutPlan>): MutableMap<Int, MutableMap<Int, Int>> {
        val fabric: MutableMap<Int, MutableMap<Int, Int>> = mutableMapOf()
        cutPlans
            .forEach { it.fillFabric(fabric) }
        return fabric
    }

    private fun getCutPlans(): List<CutPlan> {
        val cutPlans = input.split("\n")
            .map { CutPlan(it) }
        return cutPlans
    }
}
