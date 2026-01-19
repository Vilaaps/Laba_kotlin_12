package actions
import modules.ResourceManager

interface ModuleAction {
    fun execute(manager: ResourceManager)
}