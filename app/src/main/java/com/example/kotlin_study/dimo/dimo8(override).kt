package com.example.kotlin_study.dimo

// 상속 시에는 기본적으로, superclass와 같은 이름과 같은 형태를 갖는 subclass를 만들 수 없다.
// 하지만, 수퍼클래스에서 허용하면 서브클래스에서 overriding을 통해 같은 이름과 형태를 구현할 수 있다.

open class Animal2 {
    open fun eat() {
        println("음식을 먹습니다.")
    }
}

class Tiger : Animal2() {
    override fun eat() {
        println("고기를 먹습니다.")
    }
}

// Abstraction : 함수의 구체적인 구현은 없고, 단지 특정 수퍼클래스의 서브클래스에는 반드시 어떤 method가 있어야 한다는
// 점만 명시하여 각 서브클래스가 비어있는 함수의 내용을 필요에 따라 구현하도록 할 때 사용되는 개념.
//
// 추상함수 : 선언부만 있고, 기능이 구현되지 않은 함수.
// 추상 클래스 : 추상함수를 포함하는 추상 클래스
// 추상화를 하는 또 다른 방법, interface

// interface : 코틀린에서는 interface 역시 속성, 추상함수, 일반함수 모두를 가질 수 있다.
// 다만, 추상함수(abstract)는 생성자를 가질 수 있는 반면, interface는 생성자를 가질 수는 없으며(parameter x),
// 인터페이스에서 구현부가 있는 함수는 open 함수,
// 구현부가 없는 함수는 abstract 함수로 간주한다.
// 따라서, 별도의 키워드(open, abstract)가 없어도 subclass에서 구현 및 재정의가 가능하다.
// 또한, 한 개의 subclass가 여러 개의 interface를 상속받을 수 있어 유연한 설계가 가능하다.

abstract class Animal3(val times : Int, val play : Int) {
    abstract fun eat()// 추상 함수는 비어있는 껍데기라고 생각하자.

    fun sniff() {
        println("킁킁")
    }
    fun hey() {
        for (i in 1..times) {
            println("Hey")
        }
    }
}

abstract class Animal4(val times : Int, val play : Int) {

}

class Rabbit(times : Int, play : Int) : Animal3(times, play) { // 좌측, 내가 받을 매개변수, 오른쪽, superclass의 매개변수?
                                                     // 매개 변수로 받아야만 사용 변수를 직접 사용 가능.
                                                     // play는 default로 받으므로 3으로 지정.

    override fun eat() { // overrides는 parameter가 변해서는 안된다.
        for (i in 1..play) {
            println("당근을 먹습니다.")
        }
    }
}

fun main() {

    var t = Tiger()
    t.eat()

    var r = Rabbit(10, 5)

    r.eat()
    r.sniff()
    r.hey()

}















