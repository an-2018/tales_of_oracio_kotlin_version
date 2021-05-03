package com.kotxiposix.talesoforacio

import com.kotxiposix.talesoforacio.gameobject.Sprite
import java.awt.Canvas
import java.awt.Toolkit
import java.awt.image.BufferStrategy
import java.awt.image.BufferedImage
import java.io.IOException
import java.net.URL
import javax.imageio.ImageIO

class Game: Canvas(), Runnable {
    private var running:Boolean = false
    private var delta:Long = 0
    private var hero:Sprite? = null

    override fun run() {
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
        hero!!.draw(g, 20, 20)
    }

    fun start(){
        running =  true
        Thread(this).start()
    }

    fun render(){
        val bs:BufferStrategy? = bufferStrategy

        if(bs == null){
            createBufferStrategy(2)
            requestFocus()
            return
        }

        val gfx = bs.drawGraphics
        gfx.fillRect(0,0, width, height)
        gfx.dispose()
        bs.show()
    }

    fun update(delta:Long){

    }

    fun getSprite(path:String):Sprite{
        var sourceImage:BufferedImage? = null

        try{
            val url: URL? = this.javaClass.classLoader.getResource(path)
            sourceImage = ImageIO.read(url)
        }catch (e:IOException){
            e.printStackTrace()
        }

        val sprite: Sprite = Sprite(Toolkit.getDefaultToolkit().createImage(sourceImage?.source))

        return sprite
    }
}