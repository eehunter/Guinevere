package guineverebot

import java.nio.file.*
import java.io.File
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity

val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
val resourcesPath = Paths.get(projectDirAbsolutePath, "/src/main/resources")

val token = File("$resourcesPath/token").readLines()[0].trim()
val jda = JDABuilder.createDefault(token).addEventListeners(GuinevereCommand()).build()

fun main(args: Array<String>) {
    if(args.contains("-u")) upsert()
    jda.presence.activity = Activity.playing("Testing...")
}

fun upsert(){
    jda.upsertCommand("guinevere", "Send guinevere a command").queue()
	
}