package characters

class OutpostWorker(val name: String) {
//    var energy: Int = 100
//        set(value){
//            field = value.coerceIn(0,100)
//        }
    var mood: Int = 50
        get() = field + (energy / 10)
    var level: Int = 1
        private set
    var maxEnergy: Int = 100
        private set
    var energy: Int = maxEnergy
        set(value){
            field = value.coerceIn(0,maxEnergy)
        }

    fun work() {
        println("$name выполняет работу ...")
        energy -= 15
        if (energy < 20) println ("$name устал!")

    }
    fun levelUp(){
        level++
        maxEnergy +=20
        energy = maxEnergy
        println("$name повышает уровень: $level | Макс. энергия увеличина до: $maxEnergy")
    }
    fun rest() {
        println("$name отдыхает...")
        energy += 20
    }
}
fun main(){
    val worker = OutpostWorker("Никита")
    println("Энергия: ${worker.energy}")
    println("Настроение: ${worker.mood}")
    worker.work()
    worker.work()
    worker.work()
    println("Энергия: ${worker.energy}")
    println("Настроение: ${worker.mood}")
    worker.rest()
    worker.energy = 150
    //worker.level = 5
    worker.levelUp()
}