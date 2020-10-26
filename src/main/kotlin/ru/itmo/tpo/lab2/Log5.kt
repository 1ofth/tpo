package ru.itmo.tpo.lab2

class Log5(private val ln: Ln) : Calculator {

    @Throws(IllegalArgumentException::class)
    override fun calc(param: Double): Double {
        return ln.calc(param) / ln.calc(5.0)
    }
}
