package edu.binghamton.cs

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils
import java.awt.Rectangle

class AimTraining : ApplicationAdapter() {
    var batch: SpriteBatch? = null
    var img: Texture? = null

    var x: Float? = null
    var y: Float? = null

    var dx: Float? = null
    var dy: Float? = null

    var w: Float? = null
    var h: Float? = null

    override fun create() {
        batch = SpriteBatch()
        img = Texture("crosshair.png")
        x = 0f
        y = 0f
        dx = 17f
        dy = 29f

    }

    override fun render() {
        // Clearing the background
        ScreenUtils.clear(1f, 0f, 0f, 1f)
        x = x!! + dx!!
        y = y!! + dy!!

        if ( (x!! > w!!) || (x!!<0))
            dx = -dx!!

        if ( (y!! > h!!) || (y!!<0) )
            dy = -dy!!

        batch!!.begin()
        batch!!.draw(img, x!!, y!!)
        batch!!.end()
    }

    override fun dispose() {
        batch!!.dispose()
        img!!.dispose()
    }

    override fun resize(width: Int, height: Int) {
        w = width.toFloat()
        h = height.toFloat()
    }
}