package com.example.kotlin_study.dimo

// constructor : 새로운 인스턴스를 만들기 위해 호출하는 특수한 함수.
// 인스턴스의 속성을 초기화, 인스턴스 생성시 구문을 수행
// (init, parameter나 반환형이 없다. 생성자를 통해 instance가 만들어질 때 호출된다.)

fun main() {

    var a = Person2("박보영", 1990)
    var b = Person2("전정국", 1997)
    var c = Person2("장원영", 2004)

    println("\n\n\n")

    var d = Person2("이루다")
    var e = Person2("차은우")
    var f = Person2("류수정")

}

class Person2 (var name:String, val birthYear:Int) { // 주 생성자

    // 보조 생성자, 보조 생성자를 만들 때는 반드시 주 생성자를 통해 속성을 초기화해줘야 한다.

    constructor (name:String) : this(name, 1997) { // 이름은 받은 그대로 넘겨주고, 년도는 1997년으로 고정
        println("보조 생성자가 사용되었습니다.")
    }

    init {
        println("${this.birthYear}년생 ${this.name}님이 생성되었습니다.")
    }
    // 여기서 this는 인스턴스 자신의 속성이나 함수를 호출하기 위해 클래스 내부에서 사용되는 키워드.
}

