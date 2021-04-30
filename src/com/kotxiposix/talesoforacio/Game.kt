package com.kotxiposix.talesoforacio

import java.awt.Canvas
import java.awt.image.BufferStrategy

class Game: Canvas(), Runnable {
    private var running:Boolean = false
    private var delta:Long = 0

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

    }

    fun start(){
        running =  true
        Thread(this).start()
    }

    fun render(){
        val bs:BufferStrategy = bufferStrategy

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
}