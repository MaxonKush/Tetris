package com.batonchiksuhoi.tetris.models

import com.batonchiksuhoi.tetris.helpers.arrayOfByte


class Frame (private val width: Int) {
    val data: ArrayList<ByteArray> = ArrayList()

    fun addRow(byteString: String): Frame{
        val row = ByteArray(byteString.length)

        for (index in byteString.indices){
            row[index] = "${byteString[index]}".toByte()
        }
        data.add(row)
        return this
    }

    fun asByteArray(): Array<ByteArray>{
        val bytes = arrayOfByte(data.size, width)
        return data.toArray(bytes)
    }



}