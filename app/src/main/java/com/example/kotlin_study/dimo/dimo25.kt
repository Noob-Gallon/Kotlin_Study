package com.example.kotlin_study.dimo

// 변수의 고급 기술

// val은 할당된 객체를 바꿀 수 없는 것이지, 할당된 객체를 변경할 수 없는 것은 아니라는 것을 기억해야 한다.

// 절대 변경이 불가능 한 것? => const.
// const val CONST_A = 1234...

// string을 포함한 기본 자료형만 가능하며, class는 될 수 없다.
// class의 property나 local variable로는 사용할 수 없다.

// class에서 사용하려면 반드시 companion object 안에 선언하여
// 객체의 생성과 관계없이 class와 관계된 고정적인 값으로만 사용해야 한다.
// 상수를 만들때는 의례적으로 대문자 + underbar로 선언한다.

// 왜 변수를 사용하지 않고, 상수를 사용할까?
// 변수의 경우 런타임 시 객체를 생성하는데 시간이 더 소요되어 성능이 하락된다.
// 따라서, 늘 고정적으로 사용할 값은 상수를 통해 객체의 생성없이 메모리에 고정하여 성능을 향상시킬 수 있다.




// 늦은 초기화 (lateinit, lazy)
// 경우에 따라서는 변수에 객체를 할당하는 것을 선언과 동시에 할 수 없을 때도 있다.
// => lateinit : 초기값을 나중에 설정한다.

// 제한사항 :
// 1) 초기값 할당 전까지 변수를 사용할 수 없음.
// 2) 기본 자료형에는 사용할 수 없음.
// => lateinit 변수의 초기화를 하였는지 여부를 확인할 때는 ::variableName.initilized 를 통해 확인할 수 있다.

// => lazy : 변수가 사용되는 시점까지 초기화를 늦춰준다.

// val a: Int by lazy { 7 }
// 코드에서는 선언시 즉시 객체를 선언 및 할당하여 변수를 초기화하는 형태, 그러나 실제 사용 시에 초기화된다.
// 코드의 실행 시간을 최적화.
// 람다함수로 초기화가 실행되므로, 여러 줄의 구문 작성 가능하며 맨 마지막 줄의 값이 변수에 할당된다.

fun main() {

    val foodCourt = FoodCourt()

    foodCourt.searchPrice(FoodCourt.FOOD_CREAM_PASTA)
    foodCourt.searchPrice(FoodCourt.FOOD_STEAK)
    foodCourt.searchPrice(FoodCourt.FOOD_PIZZA)

    val a = LateInitSample()

    println(a.getLateInitText())
    a.text = "새로 할당한 값"
    println(a.getLateInitText())

    val number: Int by lazy {
        println("초기화를 합니다")
        7
    }

    println("코드를 시작합니다.")
    println(number)
    println(number)

}

class FoodCourt {

    fun searchPrice(foodName: String) {
        val price = when(foodName) { // when에서 선택되는 값을 변수로 바로 받을 수 있음.
            FOOD_CREAM_PASTA -> 13000
            FOOD_STEAK -> 25000
            FOOD_PIZZA -> 15000
            else -> 0
        }

        println("${foodName}의 가격은 ${price}원 입니다.")
    }

    companion object {
        const val FOOD_CREAM_PASTA = "크림파스타"
        const val FOOD_STEAK = "스테이크"
        const val FOOD_PIZZA = "피자"
    }
}

class LateInitSample {
    lateinit var text: String

    fun getLateInitText(): String {
        if(::text.isInitialized) {
            return text
        }
        else
        {
            return "기본값"
        }
    }
}