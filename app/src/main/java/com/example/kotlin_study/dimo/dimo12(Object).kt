package com.example.kotlin_study.dimo

// Singleton Pattern. (단 하나만 생성되는 공용 객체)

// Class의 Instance를 단 하나만 만들어 사용하도록 하는
// 코딩 아키텍쳐 패턴(Object or Companion Obejct를 통해 구현)

// Object.

// 기존 Class 안에도 Object를 만들 수 있다.
// 바로, Companion Object.
// Class의 instance는 사용하면서 instance 간에 공용으로 사용할 속성과 함수를 만드는 것이다.
// => Static 멤버랑 유사하다.
// Class 내부에서 별도의 영역에 고정적으로 존재하여 인스턴스를 생성하지 않아도 공용으로 사용 가능한 속성이나 함수

fun main() {

    println(Counter2.count)

    Counter2.countUp()
    Counter2.countUp()

    println(Counter2.count)

    var a = FoodPoll("짜장")
    var b = FoodPoll("짬뽕")

    a.vote()
    a.vote()

    b.vote()
    b.vote()
    b.vote()

    println("${a.name} : ${a.count}")
    println("${b.name} : ${b.count}")
    println("총계 : ${FoodPoll.total}")
    // 서로 다른 object 임에도, companion object에서 생성된 total을 공유하기 때문에, 투표수를 누적할 수 있다.
    // object를 사용하는 방법
    // 1) object 생성. => 따로 인스턴스를 생성하지 않아도 사용할 수 있는 class 공간
    // 2) companion object => 인스턴스를 생성하더라도 그 인스턴스들이 공유하여 사용할 수 있는 공간, property, method
}

object Counter2 { // instance를 생성하지 않고, 그 자체로 객체이다. 따라서 생성자를 사용하지 않는다.

    var count = 0

    fun countUp() {
        count++
    }
    fun clear() {
        count = 0
    }

}

class FoodPoll (val name: String) {
    companion object {
        var total = 0
    }

    var count = 0

    fun vote() {
        total++
        count++
    }
}