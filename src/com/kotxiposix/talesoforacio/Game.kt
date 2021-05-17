package com.kotxiposix.talesoforacio

import com.kotxiposix.talesoforacio.gameobject.Sprite
import java.awt.Canvas
import java.awt.Toolkit
import java.awt.image.BufferStrategy
import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO

class Game: Canvas(), Runnable {
    private var running:Boolean = false
    private var delta:Long = 0
    private var hero:Sprite? = null

    override fun run() {
        println("running")
        var lastTime: Long = System.currentTimeMillis()

        init()

        while(running){
            delta = System.currentTimeMillis() - lastTime
            lastTime = System.currentTimeMillis()
            update(delta)
            render()
        }
    }

    fun init(){
        hero = getSprite("oracio.png")
    }

    fun start(){
        running =  true
        Thread(this).start()
        println("Game started")
    }

    fun render(){
        println("rendring")
        val bs:BufferStrategy? = bufferStrategy

        if(bs == null){
            createBufferStrategy(2)
            requestFocus()
            println("done rendering")
            return
        }

        println("drwagfx")
        val gfx = bs.drawGraphics
        gfx.fillRect(0,0, width, height)

        println("hero")
        hero?.draw(gfx, 20, 20)

        println("dispose")
        gfx.dispose()

        println("show")
        bs.show()
println("done rendering")
    }

    fun update(delta:Long){
println(delta)
    }

    fun getSprite(path:String):Sprite?{
        val sourceImage:BufferedImage
        val sprite: Sprite
        return try{

            val url = this.javaClass.classLoader.getResource(path)
            val imgFile = File("resources/oracio.png")
            println(imgFile)
            sourceImage = ImageIO.read(imgFile)
            println(sourceImage)
            sprite = Sprite(Toolkit.getDefaultToolkit().createImage(sourceImage?.source))
println(sprite)
            sprite
        }catch (e:IOException){
            e.printStackTrace()
            null;
        }
    }
}