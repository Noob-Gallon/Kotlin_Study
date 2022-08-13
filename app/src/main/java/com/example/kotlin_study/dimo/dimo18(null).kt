package com.example.kotlin_study.dimo

var Sample: String? = null

// 1) null safe operator ?.
// 참조를 하기 전에 객체가 null인지 체크하고, null이라면 뒤따라오는 구문을 실행하지 않는다.

// 2) elvis operator ?:
// 객체가 null이 아니라면 그대로 사용하지만, null이라면 연산자 우측의 객체가 사용된다.

// 3) non-null assertion operator !!.
// 참조연산자를 사용할 때, null 여부를 컴파일 때 사용하지 않도록 한다. 의도적으로 방치.

fun main() {
    var a: String? = null

    println(a?.uppercase()) // scope 함수와 사용하면 더욱 편리하다.

    println(a?:"default".uppercase()) // "default" 문자열로 대체된다.

    // println(a!!.uppercase())

    a = "Hello"

    val b = a?.run { // a가 null 이므로, scope 함수 전체가 실행되지 않는다.
        println(uppercase())
        println(lowercase())
        "정상 작동"
    }

    // 변수의 동일성
    // 1) 내용의 동일성
    // 메모리 상에 서로 다른 곳에서 할당된 객체라고 해도 내용이 같으면 같다고 판단.
    // ==
    
    // 2) 객체의 동일성
    // 메모리 상에서 서로 같은 곳을 가리켜야 같은 객체라고 판단.
    // ===

    var aa = Product("콜라", 1000)
    var bb = Product("콜라", 1000)
    var cc = aa
    var dd = Product("사이다", 1000)

    println(aa == bb)
    println(aa === bb)

    println(aa == cc)
    println(aa === cc)

    println(aa == dd)
    println(aa === dd)

}

class Product(val name: String, val price: Int) {
    override fun equals(other : Any?): Boolean {
        if(other is Product) {
            return other.name == name && other.price == price
        } else {
            return false
        }
    }
}
