package com.example.kotlin_study.joyce

// 1. lamda

// 람다. 함수형 프로그래밍의 핵심. 마치 value 처럼 다룰 수 있는 익명 함수.
// 1) method의 parameter로 넘겨줄 수 있다. fun maxBy(a : Int) : Unit { ... }
// 여기의 a : Int 자리에 function을 줄 수 있는 것이다. (functional programming?)
//
// 2) return 값으로 사용할 수가 있다. (lamda = higer-order function, closure)
//

// lamda의 기본 정의
// val/var lamdaName : Type = {argumentList -> codeBody}
// Javascript의 화살표 함수와 동일하다.

val square : (Int) -> (Int) = {number -> number*number}
//           input    output  타입 추론      타입 추론
//           => 앞에서 (Int) -> (Int)를 써줬기 때문에 타입 추론 가능.
//           => 만약 이걸 쓰지 않으면, {number : Int -> number*number}를 해줘야 한다.

// 한 줄의 function이면 return을 적지 않아도 된다?
// lamda 식에서는 항상 마지막 줄이 return 값이다.

val nameAge = {name : String, age : Int ->
    "my name is ${name}, and I'm ${age}"
}

fun main() {

    println(square(12))
    println(nameAge("Joyce", 99))

    val a = "joyce said"
    val b = "mac said"

    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())

    println(extendString("ariana", 27))

    println(calculateGrade(97))
    println(calculateGrade(30))
    println(calculateGrade(55))
    println(calculateGrade(150))



     val lamda = {number : Double -> number == 4.3213}

    // val lamda : (Double) -> (Boolean) = {number ->
    //      number == 4.3213
    // }

    println(invokeLamda(lamda))
    println(invokeLamda({it > 3.22}))
    // => lamda literal, 여기서 it은 넣는 parameter가 하나일 때 지칭하는 대명사가 됨.

    println(invokeLamda { it > 3.22 })
    // function의 마지막 parameter가 lamda 식이면, 이와 같이 표현 가능하다.

}

// 1-2. 확장 함수 (expanded function)
// 어떠한 클래스에 method를 추가하고 싶을 때 사용한다.

val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}

fun extendString(name : String, age : Int) : String {
    val introduceMyself : String.(Int) -> String = { "I am ${this}, and ${it} years old" }
    return name.introduceMyself(age)
    // this : 시작함수를 call하는 object를 가리킨다.
    // it : 한 개 들어가는 parameter의 경우에는 it으로 생략이 가능하다.
    // this가 가리키는 것은 확장 함수가 가르키는 object, it은 parameter Int.

    // name은 String type이고, String class의 확장 함수를 이용하여 introduceMyself라는 method를 추가했으므로,
    // name.introduceMyself(parameter : Int)를 return한다. 해당 함수는 String을 return하므로,
    // 함수가 올바르게 동작한다.
}

// 1-3. lamda의 return

val calculateGrade : (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 1-4. lamda를 표현하는 여러 가지 방법

fun invokeLamda(lamda : (Double) -> Boolean) : Boolean {
    return lamda(5.234)
}