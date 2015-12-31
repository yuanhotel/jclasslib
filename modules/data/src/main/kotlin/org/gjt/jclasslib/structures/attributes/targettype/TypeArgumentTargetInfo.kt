/*
 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public
 License as published by the Free Software Foundation; either
 version 2 of the license, or (at your option) any later version.
 */

package org.gjt.jclasslib.structures.attributes.targettype

import org.gjt.jclasslib.structures.InvalidByteCodeException

import java.io.DataInput
import java.io.DataOutput
import java.io.IOException

/**
 * Target info for a TypeAnnotation structure with an offset and an argument index.
 */
class TypeArgumentTargetInfo : TargetInfo() {
    var offset: Int = 0
    var typeArgumentIndex: Int = 0

    @Throws(InvalidByteCodeException::class, IOException::class)
    override fun read(input: DataInput) {
        offset = input.readUnsignedShort()
        typeArgumentIndex = input.readByte().toInt()
    }

    @Throws(InvalidByteCodeException::class, IOException::class)
    override fun write(output: DataOutput) {
        output.writeShort(offset)
        output.writeByte(typeArgumentIndex)
    }

    override val length: Int
        get() = 3

    override val verbose: String
        get() = "offset $offset, type argument index $typeArgumentIndex"

    override val debugInfo: String
        get() = "with $verbose"
}