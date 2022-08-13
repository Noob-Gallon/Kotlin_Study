package com.example.kotlin_study.myself

open class Animal(var name:String, var type:String) {
    open fun eat() {
        println("저는 ${type}이고, 이름은 ${name}이며, 음식을 먹습니다.")
    }
}

class Tiger(name:String) : Animal(name, "호랑이") {
    override fun eat() {
        println("저는 ${type}이고, 이름은 ${name}이며, 고기를 먹습니다.")
    }
    fun shout() {
        println("어흥어흥")
    }
}

fun main() {
    var a : Animal = Animal("사랑이", "동물")
    var b : Tiger = Tiger("호랭이")
    var c : Animal = Tiger("호랑말코")

    b.shout()
    c.eat()

    // c.shout()

    if (c is Tiger) {
        c.shout()
    }

    // c.shout()

    c as Tiger
    c.shout()
}