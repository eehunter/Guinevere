package guineverebot

import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class GuinevereCommand : ListenerAdapter() {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    //This gets called when a slash command gets used.
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        logger.info("Recieved event called ${event.getFullCommandName()}")
		
        if (event.name == "guinevere") {
			if(event.subcommandName == "kill") jda.shutdown()
			else if (event.subcommandName == "ping") {
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