package com.example.kotlin_study.dimo

fun main() {

    var test1 = "Test.Kotlin.String"

    println(test1.length)
    println(test1.lowercase())
    println(test1.uppercase())

    val test2 = test1.split(".") // .을 기준으로 문자열을 나눈 배열
    println(test2)

    // Kotlin은 Java와 달리 정규식이 아닌 문자열을 넣어도 동작한다.

    println(test2)
    println(test2.joinToString()) // 아무것도 넣지 않으면 그냥 합쳐지고
    println(test2.joinToString("-")) // 문자열을 넣으면 문자열을 사이에 넣어준다.

    println(test1.substring(5..10)) // 시작과 끝만 출력된다.

}