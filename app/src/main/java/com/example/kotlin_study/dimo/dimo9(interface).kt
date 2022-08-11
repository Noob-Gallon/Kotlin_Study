package com.example.kotlin_study.dimo

fun main() {

    var inter_ex = Dog2()

    inter_ex.run()
    inter_ex.eat()
    inter_ex.hey(3)
}

interface Runner {
    fun run()
    fun hey(a : Int) {
        println("hey : ${a}")
    }
}

interface Eater {
    abstract fun eat()
}

class Dog2 : Runner, Eater {

    override fun run() {
        println("우다다다 뜁니다.")
    }

    override fun eat() {
        println("허겁지겁 먹습니다.")
    }
}

// overriding : 이미 구현이 끝난 함수의 기능을 subclass에서 변경해야 할 때
// 추상화 : 형식만 선언하고, 실제 구현은 서브클래스에 일임할 때
// 인터페이스 : 서로 다른 기능들을 여러 개 물려주어야 할 때 유용한 기능