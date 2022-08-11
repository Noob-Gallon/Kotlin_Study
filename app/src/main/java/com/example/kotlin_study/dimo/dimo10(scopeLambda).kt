package com.example.kotlin_study.dimo

// scope : 범위
// 변수나 함수, 클래스 같은 '멤버'들을 서로 공유할 수 있는 범윌을 지정해 둔 단위.
// 패키지, 클래스, 함수 내부 등을 하나의 scope로 본다.

// 스코프에 대한 세 가지 규칙

// 1) 스코프 외부에서는 스코프 내부의 멤버를 참조연산자로만 참조가 가능하다.
// a.eat() 하나의 패키지에서 다른 패키지 내의 멤버를 참조할 때도 com.google.dimo.A 등을 작성해야 한다.

// 2) 동일 scope 내에서는 member를 공유할 수 있다.

// 3) 하위 scope에서는 상위 scope의 member를 re-assign 할 수 있다.
// 하위 scope에서는 같은 이름의 member를 만들어 사용할 수 있다.


// 접근 제한자
// scope 외부에서 scope 내부로 접근할 때 그 권한을 개발자가 제어할 수 있는 기능이다.
// public, internal, private, protected가 있다.
// 변수, 함수, class 선언 시에 맨 앞에 붙여 사용 가능하다.

// 패키지 스코프에서는,
// public이 기본값 : 어떤 패키지에서도 접근 가능
// internal : 같은 모듈 내에서만 접근 가능
// private : 같은 파일 내에서만 접근 가능
// proteted는 패키지 스코프에서는 사용하지 않는다.

// 클래스 스코프에서는,
// public이 기본값 : 클래스 외부에서 늘 접근 가능
// private : 클래스 내부에서만 접근 가능
// protected : 클래스 자신과 상속받은 클래스에서 접근 가능
// internal은 사용하지 않는다.



// higher-order function : 함수를 클래스에서 만들어낸 '인스턴스처럼' 취급하는 방법
// 함수를 'parameter'로 넘겨줄 수도 있고, return 할 수도 있음.
// kotlin에서는 모든 함수를 higer-order function으로 구현할 수 있다.

fun main() {

    b(::a) // 일반함수를 고차 함수로 변경해 주는 연산자, JS가 그립다...

    // 마치 JS에서 const doIt = () => { } ... 와 같이, 함수임을 표현해주는 특별한 방식.
    val c : (String) -> Unit = { str -> println("${str} lambda 함수")}
    // lambda 함수의 선언

    b(c)
    // lambda 함수의 사용

    val d = {str:String -> println("${str} 람다함수")}
    b(d)
}

fun a (str: String) {
    println("${str} 함수 a")
}

fun b (function : (String)->Unit) {
    function("b가 호출한")
}

// parameter로 넘길 함수에 굳이 이름까지 붙여야 할까?
// lambda function. lambda function은 그 자체로 고차함수이므로, 별도의 연산자 없이도 변수에 담을 수 있다.

