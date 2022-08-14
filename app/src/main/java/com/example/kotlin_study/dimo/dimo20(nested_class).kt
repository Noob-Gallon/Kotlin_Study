package com.example.kotlin_study.dimo

// 하나의 클래스가 다른 클래스의 기능과 강하게 연관되어 있다는 의미를 전달하고자 만들어짐.
// Outer.Nested()...

// Nested or Inner.
// 중첩 클래스는 형태만 내부에 존재할 뿐, 내용을 서로 공유하지는 않는다.
// 내부 클래스는 외부 클래스의 객체 안에서 사용되는 클래스이므로, 외부 클래스의 속성이나 함수를 사용할 수 있다.

fun main() {

    Outer.Nested().introduce()

    val outer = Outer()
    val inner = outer.Inner() // inner는 Outer의 instance outer의 inner class를 참조한다.

    inner.introduceInner()
    inner.introduceOuter()

    outer.text = "Changed Outer Class"
    inner.introduceInner()
    inner.introduceOuter()
}

class Outer {
    var text = "Outer Class"

    class Nested {
        fun introduce() {
            println("Nested Class")
        }
    }

    inner class Inner {
        var text = "Inner Class"

        fun introduceInner() {
            println(text)
        }

        fun introduceOuter() {
            println(this@Outer.text)
        }
    }
}
