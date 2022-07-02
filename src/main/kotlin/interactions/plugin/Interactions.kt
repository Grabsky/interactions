package interactions.plugin

import org.bukkit.plugin.java.JavaPlugin

object InteractionsProvider {
    internal lateinit var INS: Interactions
}

class Interactions : JavaPlugin() {

    override fun onEnable() {
        super.onEnable()
        // Creating instance(s)
        InteractionsProvider.INS = this
        // ...
    }

    override fun onDisable() {
        super.onDisable()
        // ...
    }

}