package com.example.kotlin_study.dimo

// 다형성
// 클래스의 상속 관계에서 오는
// 인스턴스의 호환성을 적극 활용할 수 있는 기능이다.
// superclass가 같은 인스턴스를 한 번에 관리하거나
// interface를 구현하여 사용하는 코드에서도 활용된다.

// 자식 class의 instance 변수를 자신(superclass)에 변수로 넣을 수 있는 것.

// up-casting, down-casting
// up-casting : 자료형을 상위의 자료형으로 바꾸는 것
// down-casintg : 자료형을 하위의 자료형으로 바꾸는 것

// as : 변수를 호환되는 자료형으로 변환해주는 casting 연산자
// is : 변수가 자료형에 호환되는지를 체크 후, 변경해주는 casting 연산자

fun main() {

    var a = Drink()
    a.drink()

    var b: Drink = Cola()
    b.drink()
    // 이렇게 하면, b는 Drink 변수이므로, 이대로는 washDishes 함수의 호출이 불가능.

    // b.washDishes() => 참조 불가능.

    if (b is Cola) // b가 Cola와 호환되는지 체크
    {
        b.washDishes()
    } // is는 조건문 안에서만 잠시 다운캐스팅 된다.

    // b.washDishes() 똑같이 실행 불가능.

    var c = b as Cola // down-casting
    c.washDishes()
    b.washDishes() // 여기서는 b.washDishes() 사용가능, why?
    // as를 사용하여 down-casting으로 값을 할당하면, 변수 자체 (여기서는 b)도 down-casting되기 때문이다.
}

open class Drink {
    var name = "음료"

    open fun drink() {
        println("${name}를 마십니다.")
    }
}

class Cola: Drink() {
    var type = "콜라"

    override fun drink() {
        println("${name}중에 ${type}를 마십니다.")
    }

    fun washDishes() {
        println("${type}로 설거지를 합니다")
    }
}