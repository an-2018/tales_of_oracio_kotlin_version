package com.kotxiposix.talesoforacio

import com.kotxiposix.talesoforacio.TalesOfOracio.gameSettings.HEIGHT
import com.kotxiposix.talesoforacio.TalesOfOracio.gameSettings.WIDTH
import java.awt.Dimension
import javax.swing.JFrame

class TalesOfOracio {
    object gameSettings {
        const val WIDTH:Int = 400
        const val HEIGHT:Int = 400
        const val NAME:String = "Tales of Oracio"
    }
    fun main(args:Array<String>){
        val game  = Game()
        game.preferredSize = Dimension(WIDTH, HEIGHT)

        val frame: JFrame = JFrame()
    }
}