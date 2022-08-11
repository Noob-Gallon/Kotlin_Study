package com.example.kotlin_study.dimo

// Class : 고유의 특징값을 갖는 속성(Property) + 기능의 구현 함수(Method)로 이루어짐.

fun main() {

    var a = Person("박보영", 1990)
    var b = Person("전정국", 1997)
    var c = Person("장원영", 2004)

    a.introduce()
    b.introduce()
    c.introduce()
}

class Person(var name:String, val birthYear:Int) {
    fun introduce() {
        println("안녕하세요. ${birthYear}년생 ${name}입니다.")
    }
}
// 함수없이 속성만으로 구성되는 class는 이와 같이 만들어질 수 있다.
// => class Person(var name:String, val birthYear:Int)
// class는 instance를 만드는 틀이다.

// instance란?
// class를 이용하여 만들어 내는 서로 다른 속성의 객체를 지칭하는 용어
// ex) 1990년생 박보영, 1997년생 전정국, 2004년생 장원영
// 세 사람의 instance를 만들어 사용하게 된다.

