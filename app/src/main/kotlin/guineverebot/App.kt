package guineverebot

import dev.minn.jda.ktx.interactions.commands.subcommand
import dev.minn.jda.ktx.interactions.commands.upsertCommand
import java.nio.file.*
import java.io.File
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData

val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
val resourcesPath = Paths.get(projectDirAbsolutePath, "/src/main/resources")

val token = File("$resourcesPath/token").readLines()[0].trim()
val jda = JDABuilder.createDefault(token).addEventListeners(GuinevereCommand()).build()

fun main(args: Array<String>) {
    if(args.contains("-u")) upsert()
    jda.presence.activity = Activity.playing("Testing...")
}

fun upsert(){
    jda.upsertCommand("guinevere", "Send guinevere a command") {
        subcommand("kill", "Kill the bot application.")
        subcommand("ping", "Ping the bot for testing.")
    }.queue()
    /*jda.upsertCommand("guinevere", "Send guinevere a command").addSubcommands(
        SubcommandData("kill", "Kill the bot application."),
        SubcommandData("ping", "Ping the bot for testing.")
    ).queue()*/
}