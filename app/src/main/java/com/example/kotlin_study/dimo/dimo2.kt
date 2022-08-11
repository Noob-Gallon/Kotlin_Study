package com.example.kotlin_study.dimo

// 형변환 함수
// toByte()
// toShort()
// toInt()
// toLong()
// toFloat()
// toDouble()
// toChar()

// 형변환시 발생할 수 있는 오류를 막기 위해 implicit type casting을 지원하지 않는다.
// explicit type casting을 이용.

// Array(배열)

fun main() {

    var intArr = arrayOf(1, 2, 3, 4, 5)
    var nullArr = arrayOfNulls<Int>(5) // Null로 Array를 채울 수 있음.
    // < >를 Generic이라고 한다. Any 입력시 아무 자료형이나 넣을 수 있음.

    intArr[2] = 8
    println(intArr[4])
    println(intArr[2])
    // 배열은 전체 크기를 변경할 수 없다. 단, 빠른 입출력이 가능하다.

}