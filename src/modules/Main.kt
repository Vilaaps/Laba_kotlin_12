package modules

import example.Messenger

fun main() {
    val manager = ResourceManager()
    manager.add(OutpostResource(1, "Minerals", 300))
    manager.add(OutpostResource(2, "Gas", 100))

    val generator = EnergyGenerator()
    val lab = ResearchLab()
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handleModuleResult(generatorResult)
    handleModuleResult(labResult)
    println()
    manager.printAll()

    logger.log("Запуск базы")

}
fun handleModuleResult(result: ModuleResult) {
    when (result) {
        is ModuleResult.Success -> println("УСПЕХ: ${result.message}")
        is ModuleResult.ResourceProduced -> println("Произведено: ${result.resourceName} + ${result.amount}")
        is ModuleResult.NotEnoughResources -> println("Недостаточно ресурсов ${result.resourceName}. Нужно ${result.required}, есть: ${result.available}")
        is ModuleResult.Error -> println("ОШИБКА: ${result.reason}")
        }
    }
object SystemLogger {
    init {
        println("SystemLogger инициализирован")
    }
    fun log(messenger: String) {
        println("[LOG] $messenger")
    }
}
val logger by lazy {
    SystemLogger
}
