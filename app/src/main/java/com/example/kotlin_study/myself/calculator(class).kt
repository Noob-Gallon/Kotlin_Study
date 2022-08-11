package com.example.kotlin_study.myself

class Calculator1() {

    fun add(a : Int, b : Int) : Int {
        return a+b
    }

    fun sub(a: Int, b : Int) : Int {
        return a-b
    }

    fun mult(a: Int, b : Int) : Int {
        return a*b
    }

    fun div(a: Int, b : Int) : Int {
        return a/b
    }
}

fun main() {

    var cal = Calculator1()
    println(cal.add(1,2))
    println(cal.sub(2,1))
    println(cal.mult(3,2))
    println(cal.div(4,2))

}