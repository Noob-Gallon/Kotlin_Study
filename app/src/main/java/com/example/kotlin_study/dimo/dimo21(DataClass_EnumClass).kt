package com.example.kotlin_study.dimo

// Data Class는 데이터를 다루기에 적합한 Class로, 5가지 기능을 제공한다.
// 1) equals() : 내용의 동일성 판단
// 2) hashcode() : 객체의 내용에서 고유한 코드를 생성한다.
// 3) toString() : 포함된 속성을 보기 쉽게 나타내는 함수
// 4) copy() : 객체를 복사하여 똑같은 내용의 새 객체를 만든다.
// => 생성자를 통해 일부 속성을 변경할 수도 있고, 그대로 생성도 가능
// 5) componentX() : 속성을 순서대로 반환한다.

// Enumerated type. Enum Class (열거형)

enum class State(val message: String)
{

    SING("노래를 부릅니다."),
    EAT("밥을 먹습니다."),
    SLEEP("잠을 잡니다.");

    fun isSleeping() = this == State.SLEEP

}

enum class IntState(val _Int:Int) {

    BIRTHDAY(826),
    HEIGHT(171),
    WEIGHT(66);

    fun isBirthDay() = this == IntState.BIRTHDAY
}

fun main() {

    val a = General("보영", 212)
    println (a==General("보영",212))
    println(a.hashCode())
    println(a)

    val b = Data("루다", 306)
    println(b == Data("루다", 306))
    println(b.hashCode())
    println(b)

    println(b.copy())
    println(b.copy("아린"))
    println(b.copy(id = 618))


    val list = listOf(Data("보영", 212), Data("루다", 306), Data("아린", 618))

    // Data Class를 순회하려면, 이와 같이 속성을 받을 수 있는 for문을 생성한다.
    // 내부적으로 component1(), component2()라는 함수를 이용하여 순서대로 값을 불러오게 된다.

    for((a,b) in list) {
        println("${a}, ${b}")
    }

    var state = State.SING // enum은 선언시에 만든 객체를 이름으로 참조하여 그대로 사용한다.
    println(state) // toString() 함수를 통해 상태 객체의 이름이 출력된다.
    println(state.message)

    state = State.SLEEP
    println(state.isSleeping()) // 같은 객체끼리 비교했기 때문에 true 반환.
    println(state.message)


    state = State.EAT
    println(state.message)
    println()

    // enum class에 생성된 생성자가 값을 받는다?

    var intState = IntState.BIRTHDAY
    println(intState)
    println(intState._Int)
    println(intState.isBirthDay())
    println()

    intState = IntState.HEIGHT
    println(intState)
    println(intState._Int)
    println(intState.isBirthDay())
    println()


    intState = IntState.WEIGHT
    println(intState)
    println(intState._Int)
    println(intState.isBirthDay())
    println()

}

class General(val name: String, val id: Int)

data class Data(val name: String, val id: Int)