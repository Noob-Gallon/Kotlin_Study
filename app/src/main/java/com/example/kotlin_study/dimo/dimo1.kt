package com.example.kotlin_study.dimo

// 변수의 이름
// 1. Class 내에서 선언되면 Property
// 2. 그 외의 scope에서 언언되면 Local variable

// 기본 자료형(Primitive Type)

// 정수형...
// Byte : 8 bits
// Short : 16 bits
// Int : 32 bits
// Long : 64 bits

// 실수형...
// Float : 32 bits
// Double : 64 bits



fun main() {

    // -----------------------------------------------------------------------

    var a: Int? = null // nullable variable. 값이 null이 될 수 있는 variable.
    // lateinit, lazy : 변수의 초기화를 늦춘다. => 이는 Class에 대한 지식이 필요하다.

    println(a)
    println("\n\n\n")

    // -----------------------------------------------------------------------

    var intValkue: Int = 1234
    var longValue: Long = 1234L // Long을 표기해줘야 한다.
    var intValueByHex: Int = 0x1af // 16진수
    var intValueByBin: Int = 0b10110110 // 2진수
    // 8진수 표기는 지원하지 않는다.

    var doubleValue: Double = 123.5
    var doubleValueWithExp: Double = 123.5e10
    var floatValue: Float = 123.5f // f를 붙이면 16 bit의 float형으로 취급한다?

    // -----------------------------------------------------------------------

    // 코틀린은 문자 인코딩 방식을 유니코드 인코딩 방식의 한 방식인 UTF-16 BE로 관리한다.
    // 따라서, 글자 하나하나가 2 Bytes(16 bits)이다.

    var charValue: Char = 'a'
    var koreanCharValue: Char = '가'

    val stringValue = "one line string test"
    val multiLineStringValue = """multiline
 string
  test"""

    println(multiLineStringValue)

    // -----------------------------------------------------------------------
}