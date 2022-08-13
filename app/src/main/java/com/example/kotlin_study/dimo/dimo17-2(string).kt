package com.example.kotlin_study.dimo

fun main() {

    val nullString: String? = null
    val emptyString = ""
    val blankString = " "
    val normalString = "A"

    // String이 비어있는지 체크 emptyCheck
    println(nullString.isNullOrEmpty())
    println(emptyString.isNullOrEmpty())
    println(blankString.isNullOrEmpty())
    println(normalString.isNullOrEmpty())

    println()

    println(nullString.isNullOrBlank())
    println(emptyString.isNullOrBlank())
    println(blankString.isNullOrBlank())
    println(normalString.isNullOrBlank())

    println()

    // 공백문자는 Space, Tab, Line Feed, Carriage Return 등의 눈에 보이지 않는 문자들도 포함.

}