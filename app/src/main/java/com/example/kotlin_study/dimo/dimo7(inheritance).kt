package com.example.kotlin_study.dimo

// 상속이 필요한 경우
// 1) 기존의 Class를 확장하여 새로운 Property나 Method를 추가한 Class를 만들어야 할 때
// 2) 여러 개의 Class를 만들었는데, Class들의 공통점을 뽑아 코드 관리를 편하게 해야 할 때

// 속성과 함수를 물려주는 쪽을 superclass,
// 물려받는 쪽을 subclass라고 한다.
// Kotlin은 상속 금지가 기본이므로, 상속을 하려면 open해줘야 한다.

// 상속에 대한 규칙
// 1) subclass는 superclass에 존재하는 속성과 '같은 이름'의 속성을 가질 수 없음.
// 2) subclass가 생성될 떄는 반드시 superclass의 생성자까지 호출해야 한다.
// 상속은 한 개에만 가능하다.

fun main() {

    var a = Animal("별이", 5, "개")
    var b = Dog("별이", 5)
    var c = Cat("달이", 5)

    // 두 인스턴스가 같음.

    a.introduce()
    b.introduce()

    b.bark()
    c.meow()

}

open class Animal (var name:String, var age:Int, var type:String) { // superclass
    open fun introduce() {
        println("저는 ${type} ${name}이고, ${age}살 입니다.")
    }
}

class Dog (name:String, age:Int) : Animal(name, age, "개") {
    fun bark() {
        println("멍멍")
    }
}

class Cat (name:String, age:Int) : Animal(name, age, "고양이") {
    fun meow() {
        println("냥")
    }
}
