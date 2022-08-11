package com.example.kotlin_study.dimo

// 1) lambda 함수도 일반 함수처럼 여러 구문의 사용이 가능하다.
// lambda 함수가 여러 줄이 되는 경우, 마지막 줄에서 결과값이 반환된다.

// 2) 람다함수에 parameter가 없다면, 실행할 구문들만 나열하면 된다.

val a:() -> Unit = {println("No parameters")}

// 3) parameter가 하나뿐이라면, it을 사용한다.

val c: (String) -> Unit = {println("${it} 람다함수")}



// scope 함수 : 기본 제공되는 함수들.
// 클래스의 인스턴스들을 Scope 함수에 전달하면, 인스턴스의 속성이나 함수를 좀 더 깔끔하게 불러 쓸 수 있다.

// 1) apply : 인스턴스를 생성한 후, 변수에 담기 전에 초기화 과정을 수행할 때 많이 사용된다.


// 2) run : apply처럼, run scope 안에서 참조연산자를 사용하지 않아도 된다는 점은 같지만,
// 일반 람다함수처럼 인스턴스 대신 마지막 구문에 결과값을 반환한다.
// 따라서, 이미 인스턴스가 만들어진 이후에 인스턴스의 함수나 속성을 스코프 내에서 사용해야 할 때 유용하다.


// 3) with : run과 동일한 기능을 가지지만, 단지 인스턴스를 참조연산자 대신 parameter로 받는다.

// 4) also/let : 처리가 끝나면 인스턴스를 반환, apply/also
//               처리가 끝나면 최종값을 반환, run/let
// 다만, 한가지 공통적인 '차이점'이 있다.
// apply와 run이 참조연산자 없이 인스턴스의 변수와 함수를 사용할 수 있었다면,
// also와 let은 마치 패러미터로 인스턴스를 넘긴것처럼, it을 통해 인스턴스를 사용할 수 있다.

// 같은 이름의 변수나 함수가 scope 바깥에 중복되어 있는 경우에 혼란을 방지하기 위해서 만들어짐.




// scope 함수는 인스턴스의 속성이나 함수를 scope 내에서 깔끔하게 분리하여 사용할 수 있다는 점 때문에
// 코드의 가독성을 향상 시킬 수 있다는 장점이 있다.


class Book(var name: String, var price: Int) {
    fun discount() {
        price -= 2000
    }
}

fun main() {

    var price = 5000

    // ------------------------------------------------------------------ 1

    var a = Book("디모의 코틀린", 10000)

    // 이 때, 책 이름에 [초특가]란른 문자열을 넣어주고, discount를 바로 수행.
    // a.name = "[초특가]" + a.name
    // a.discount()
    // 참조연산자 사용 X

    var b = Book("디모의 코틀린", 10000).apply {
        name = "[초특가]" + name
        discount()
        println("price is : ${price}, scope function : apply\n\n")
    }
    // apply는 인스턴스 자신을 다시 반환한다. 그래서, 생성되자마자 조작된 인스턴스를
    // 변수에 반환할 수 있다.

    println(b.name+" "+(b.price)+"\n\n")

    // ------------------------------------------------------------------ 2

    var c = b.run {
        println("상품명 : ${name}, 가격 : ${price}원")
        // return 해주는 것을 적지 않으면, c에는 kotlin.Unit, (JS의 Undefined)가 들어간다.
        //  run은 scope 함수 중에서 return을 해주는 특별한 함수이므로, return하는 것을 적어준다.
        name+' '+price+" scope function : run\n\n"
    }

    println(c)

    // ------------------------------------------------------------------ 3

    c = with(b) {
        println("상품명 : ${name}, 가격 : ${price}원")
        name+' '+price+" scope function : with\n\n"
    }

    println(c)

    // ------------------------------------------------------------------ 4

   c = b.let {
       println("상품명 : ${it.name}, 가격 : ${it.price}원")
       it.name+' '+it.price+" scope function : let\n\n"
   }

    println(c)
    // => instance의 값이 정상적으로 출력되는 것을 확인 가능.

    b = Book("동교의 코틀린", 30000).also {
        it.name = "[초특가]" + it.name
        it.discount()
        println("price is : ${it.price}, scope function : also\n\n")
    }

    println(b.name+" "+(b.price)+"\n\n")
}