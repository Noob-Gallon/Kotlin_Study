package com.example.kotlin_study.joyce

// kotlin이 자바와 다른점, 파일 이름과 class 이름이 달라도 된다.
// 여러 클래스를 한 파일에 넣을 수 있다.
// class의 종류 1) data class, 2) abstrace class, 3) interface ...
// => 3강에서 앱을 만들면서 사용

// default value도 설정 가능.

var cnt = 0

open class Human (val name : String = "Anonymous") /* 주 생성자 */ {

    // 부 생성자 constructor, 부 생성자는 반드시 주 생성자의 위임을 받아야 한다.
    // 주 생성자가 없으면 위임을 해줄 필요가 없다.
    // 하지만, 부 생성자만 사용하면 추천이 뜬다. 주 생성자가 없으므로, 굳이 부 생성자를 쓸 이유가 없다.
    // 따라서, overriding을 할 이유가 없으므로, compiler가 추천을 해주는 것이다.

    constructor(name : String, age : Int) : this(name) {
        println("my name is ${name}, ${age} years old")
    }

    init { // init block이 constructor, 부 생성자보다 먼저 생성된다.
        println("New human has been appeared")
        cnt++
    }

    fun eatingCake() {
        println("${name} : Cake is so yummy!")
    }
    open fun singASong() {
        println("lalala")
    }
}

// 상속
// kotlin에서 class는 기본적으로 class가 final이므로, 같은 파일에 있어서 접근할 수 없다.
// 따라서 open을 해야한다.
// class에 open을 함으로써 상속할 수 있도록 해줘야 한다.

class Korean() : Human() { // 상속은 하나만 가능하다.
    // 상속받은 class(korean)에서 method를 특징적으로 사용하고 싶다.

    // 만약 Korean Class에서 사용한다면 라라라로 나간다.
    override fun singASong() {
        super.singASong() // super를 쓰면 override를 하지 않은 method도 사용 가능?
        println("라라라")
        println("my name is : ${name}")
    }
}

fun main() {

    val human = Human("minsu") // class 선언을 이렇게 함.
    val stranger = Human()
    print("\n\n")

    human.eatingCake()
    stranger.eatingCake()
    print("\n\n")

    val mom = Human("Kuri", 52)

    println("cnt : ${cnt}")
    print("\n\n")

    println("this human's name is ${human.name}")
    println("new human's name is ${stranger.name}")
    println("new human's name is ${mom.name}")
    print("\n\n")

    val korean = Korean()
    korean.singASong()
}
