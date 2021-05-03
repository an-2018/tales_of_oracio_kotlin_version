package com.kotxiposix.talesoforacio

import com.kotxiposix.talesoforacio.TalesOfOracio.GameSettings.HEIGHT
import com.kotxiposix.talesoforacio.TalesOfOracio.GameSettings.WIDTH
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JFrame

fun main(args:Array<String>){
    val game  = Game()
    game.preferredSize = Dimension(WIDTH, HEIGHT)

    val frame: JFrame = JFrame(TalesOfOracio.GameSettings.NAME)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

    frame.layout = BorderLayout()
    frame.add(game, BorderLayout.CENTER)
    frame.pack()
    frame.isResizable = false
    frame.isVisible  = true

    game.start()
}

class TalesOfOracio {
    object GameSettings {
        const val WIDTH:Int = 400
        const val HEIGHT:Int = 300
        const val NAME:String = "Tales of Oracio"
    }
}