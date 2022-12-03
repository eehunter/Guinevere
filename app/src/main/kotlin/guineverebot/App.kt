/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package guineverebot

import java.nio.file.*
import java.io.File
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity

val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
val resourcesPath = Paths.get(projectDirAbsolutePath, "/src/main/resources")

val token = File("$resourcesPath/token").readLines()[0]
val jda = JDABuilder.createDefault(token).build()

fun main() {
    jda.presence.activity = Activity.playing("Testing...")
}