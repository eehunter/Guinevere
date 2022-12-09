package guineverebot

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.OnlineStatus.OFFLINE

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class GuinevereCommand : ListenerAdapter() {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    //This gets called when a slash command gets used.
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        logger.info("Recieved event called ${event.name}")
		
        if (event.name == "guinevere") {
			if(event.subcommandName == "kill") {
				event.reply("Shutting down...").queue()
				jda.presence.setStatus(OFFLINE)
				runBlocking{
					launch(Dispatchers.Default){
						delay(5000)
						jda.shutdown()
					}
				}
			} else if (event.subcommandName == "ping") {
				logger.info("Command /ping got used")

				//Reply to the user
				val startTime = System.currentTimeMillis()
				event.reply("Ping ...").setEphemeral(true).queue {
					it.editOriginal("Pong: ${System.currentTimeMillis() - startTime}ms").queue()
				}
			}
		}
    }
}