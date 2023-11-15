package com.batonchiksuhoi.tetris.models

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Point
import androidx.annotation.NonNull
import com.batonchiksuhoi.tetris.constants.FieldConstants
import kotlin.random.Random

class Block(
    val shapeIndex: Int = Random.nextInt(Shape.values().size),
    val blockColor: BlockColor = BlockColor.values()[Random.nextInt(BlockColor.values().size)],
    var frameNumber: Int = 0,
    var position: Point = Point(FieldConstants.COLUMN_COUNT.value / 2, 0),
) {
/*    private var blockColor: BlockColor? = null
    private var position: Point? = null
    private var shapeIndex: Int? = null
    private var frameNumber: Int? = null*/

    fun setPosX(){
        position.x = position.x.minus(Shape.values()[shapeIndex].startPosition)
    }

    enum class BlockColor (rgbValue: Int, byteValue: Byte){
        PINK(Color.rgb(255,105,180),2),
        GREEN(Color.rgb(0,128,0),3),
        ORANGE(Color.rgb(0,128,0),4),
        YELLOW(Color.rgb(255,255,0),5),
        CYAN(Color.rgb(0,255,255),6);

        private var rgbValue : Int? = null
        var byteValue: Byte? = null

        @SuppressLint("NotConstructor")
        fun BlockColor(rgbValue: Int, value: Byte) {
            this.rgbValue = rgbValue
            this.byteValue = value
        }

    }

    fun getStaticValue(): Byte? {
        return blockColor.byteValue
    }

    @NonNull
    fun getShape(frameNumber: Int): Array<ByteArray> {
        return Shape.values()[shapeIndex].getFrame(frameNumber).asByteArray()
    }

    fun getFrameCount(): Int {
        return Shape.values()[shapeIndex].frameCount
    }

    fun setState(frameNumber: Int, position: Point?) {
        this.frameNumber = frameNumber
        this.position = position!!
    }

/*    fun createBlock(): Block {
        val shapeIndex = Random.nextInt(Shape.values().size)

        val blockColor = BlockColor.values()[Random.nextInt(
            BlockColor.values().size
        )]
        val block = Block(shapeIndex, blockColor)

        block.position?.x = block.position?.x?.minus(Shape.values()[shapeIndex].startPosition)
        return block
    }*/
/*    constructor(shapeIndex: Int, blockColor: BlockColor, position: Point,frameNumber: Int){
        this.shapeIndex = Random.nextInt(Shape.values().size)
        this.blockColor = BlockColor.values()[Random.nextInt(BlockColor.values().size)]
        this.position?.x = position?.x?.minus(Shape.values()[shapeIndex].startPosition)
        this.frameNumber = 0
    }*/
}