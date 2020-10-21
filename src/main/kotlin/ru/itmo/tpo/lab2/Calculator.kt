package ru.itmo.tpo.lab2

import java.io.File
import java.io.FileNotFoundException
import java.io.PrintWriter

interface Calculator {

    @Throws(IllegalArgumentException::class)
    fun calc(param: Double): Double

    @Throws(FileNotFoundException::class)
    fun printCsv(filename: String, startX: Double, step: Double, endX: Double) {
        val pw = PrintWriter(File(filename))
        pw.write("x,res\n")
        var currX = startX
        while (currX < endX) {
            pw.write("$currX,${calc(currX)}\n")
            currX += step
        }
        pw.close()
    }
}
