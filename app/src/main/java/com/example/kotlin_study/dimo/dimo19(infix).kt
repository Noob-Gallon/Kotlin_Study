package com.example.kotlin_study.dimo

// overloading
// default arguments

// named arguments : parameter의 순서에 관계없이 이름을 사용하여 직접 값을 할당하는 기능.

// infix function : 함수 정의 시 앞에 infix라고 붙인다.

fun main() {

    read(7)
    read("감사합니다")

    deliveryItem("짬뽕")
    deliveryItem("책", 3)
    deliveryItem("노트북", 30, "학교")
    deliveryItem("선물", destination = "친구집") // named arguments

    sum(1, 2, 3, 4, 5)

    println(6 multiply 4)
}

fun read(x: Int) {
    println("숫자 $x 입니다.")
}

fun read(x: String) {
    println(x)
}

fun deliveryItem(name: String, count: Int = 1, destination: String = "집") {
    println("${name}, ${count}개를 ${destination}에 배달하였습니다.")
}

fun sum(vararg numbers: Int) {
    // vararg가 붙은 parameter는 마치 배열처럼 for loop로 참조할 수 있다.
    // 개수가 지정되지 않은 parameter이므로, 다른 parameter와 쓴다면 가장 마지막에 위치해야 한다.

    var sum = 0

    for (i in numbers) {
        sum += i
    }

    println(sum)
}

infix fun Int.multiply(x:Int): Int = this*x