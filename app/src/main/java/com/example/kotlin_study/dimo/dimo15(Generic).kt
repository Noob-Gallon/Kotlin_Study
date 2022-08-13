package com.example.kotlin_study.dimo

// class A와 class A를 상속받은 class B가 존재.
// 이 두 클래스의 instance를 공용으로 사용하는 하나의 함수에 패러미터로 받으려면 어떻게 해야할까?

// ex)
// fun castingExam(var a: A) 인 함수에 class B를 넣어도
// 다형성에 의해 class A로 up-cating된다.
// 두 클래스 모두 함수의 parameter로 사용할 수 있다.
// 하지만, casting 연산을 거치는 것은 프로그램의 속도를 저하시킬 수 있다는 단점이 존재한다.
// => 그래서 Generic이라는 개념이 나왔다.

// Generic은 함수나 클래스를 선언할 때 고정적인 자료형 대신 실제 자료형으로 대체되는 타입 패러미터를 받아 사용하는 방법
// Generic을 특정한 superclass를 상속받은 class type으로만 제한하려면, <: SuperclassName>을 명시한다.



fun main() {

    UsingGeneric(A()).doShouting() // A의 instance를 넘김
    UsingGeneric(B()).doShouting() // B의 instance를 넘김
    UsingGeneric(C()).doShouting() // C의 instance를 넘김

    doShouting(B()) // B의 instance를 넘김
}

fun <T:A> doShouting(t: T) { // superclass를 A로 제한한 Generic T를 선언.
    t.shout() // casting없이 B의 객체 그대로 함수에서 사용하게 된다.
}

open class A {
    open fun shout() {
        println("A가 소리칩니다.")
    }
}

class B : A() {
    override fun shout() {
        println("B가 소리칩니다.")
    }
}

class C : A() {
    override fun shout() {
        println("C가 소리칩니다.")
    }
}

class UsingGeneric<T:A> (val t: T) {
    // superclass를 A로 제한한 Generic T를 선언. => 다형성을 이용하여 B나 C를 전달받아도 A로 up-casting을 해줄 수 있는데, Generic이용해서 간편화?
    // Constructor에서는 Generic T에 맞는 Instance property 't'로 받는다.
    fun doShouting() {
        t.shout()
    }
}

// Generic이 자료형을 대체하게 되어 캐스팅을 방지할 수 있으므로 성능을 높일 수 있다.

class UsingGeneric2 (val t: A) { // => Generic을 사용하지 않고, parameter t를 A로 casting해도 된다.

    fun doShouting() {
        t.shout()
    }
}
