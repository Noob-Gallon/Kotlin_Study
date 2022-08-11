package com.example.kotlin_study.dimo

// 타입 추론.
// 변수가 선언될 때 할당된 값의 형태로 해당 변수가
// 어떤 자료형을 갖는지 추측할 수 있다.
// 기본 자료형들은 선언시에 값을 할당만 해주면
// 굳이 자료형을 써주지 않아도 된다.

fun add(a: Int, b: Int, c: Int) : Int {
    return a+b+c
}
// 두 함수가 같다.

fun add2(a: Int, b: Int, c: Int) = a+b+c
// 단일 표현식은 위와 같이 표현 가능.

fun doWhen (a: Any) {
    var result = when(a) {
        1 -> println("정수 1입니다.")
        "DiMo" -> println("디모의 코틀린 강좌입니다.")
        is Long -> println("Long 타입 입니다.")
        !is String -> println("String 타입이 아닙니다")
        else -> println ("어떤 조건도 만족하지 않는다.")
        // println을 지우면 when의 값을 결과로 반환하거나, 변수에 할당할 수 있다.
    }

    println(result) // println을 지우지 않으면 result는 Uint이다.
}

fun main() {

    doWhen(1)

}