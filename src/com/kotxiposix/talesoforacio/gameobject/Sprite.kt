package com.kotxiposix.talesoforacio.gameobject

import java.awt.Graphics
import java.awt.Image

class Sprite(image:Image) {
    private val image:Image
        get() {
            return this.image
        }
    fun getWidth():Int{
        return this.image.getWidth(null)
    }

    fun getHeight():Int{
        return this.image.getHeight(null)
    }

    fun draw(g: Graphics, x:Int, y:Int){
        println("img"+image)
        g.drawImage(image, x, y, null)
        println("image draw")
    }
}