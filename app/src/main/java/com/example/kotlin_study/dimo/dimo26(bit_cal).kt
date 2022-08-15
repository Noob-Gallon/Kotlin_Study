package com.example.kotlin_study.dimo

// bit 연산 : 2진법으로 연산.
// 실무에서 비트연산은 계산으로 거의 사용하지 않고, 정수형을 비트 단위로 나눠 데이터를 더 작은 단위로 담아 경제성을 높임.
// flag 값 처리에 주로 사용됨.
// Kotlin은 모든 정수형이 부호를 포함. 최상위 비트가 부호 비트이며, unsigned는 선언할 수 없음.

// bitwise shift operators
// 부호비트를 제외한 모든 비트를 좌측, 우측으로 밀어줌. shl shr, 부호비트를 포함하여 우측으로 밀기 ushr (unsigned shift right)

// bitwise operators
// and : 원하는 부분을 0으로 만들 때, 값 확인
// or : 원하는 부분을 1로 만들 때
// xor : 값이 다르면 1, 같으면 0
// inv : bit 반전시키기

fun main() {

    var bitData: Int = 0b10000

    bitData = bitData or(1 shl 2) // 1을 shl을 사용해 2번 좌측으로 밀고, or 연산 실행. 10100이 된다.
    println(bitData.toString(2)) // 이진수로 출력

    var result = bitData and(1 shl 4)
    println(result.toString(2)) // 이진수로 출력

    println(result shr 4)

    bitData = bitData and((1 shl 4).inv())
    println(bitData.toString(2)) // 이진수로 출력

    println((bitData xor(0b10100)).toString(2))
}
