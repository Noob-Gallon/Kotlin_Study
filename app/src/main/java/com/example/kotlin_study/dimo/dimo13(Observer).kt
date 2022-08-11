package com.example.kotlin_study.dimo

// Observer : 이벤트가 일어나는 것을 감시하는 감시자의 역할을 한다.
// Android는 키의 입력, 터치, 데이터의 수신 등을 함수로 직접 요청하지 않았지만
// 시스템, 혹은 루틴으로 인해 발생하는 동작을 이벤트라고 하며,
// 이런 이벤트가 생겼을 때 즉각적으로 대처하도록 만드는 프로그래밍 패턴을 'Observer Pattern'이라고 한다.

// 이를 구현할 때는 두 개의 Class가 필요하다.
// 1) 이벤트를 수신
// 2) 이벤트의 발생 및 전달

// Kotlin에서는 Observer를 listener라고 하며,
// Event를 넘겨주는 행위를 callback이라고 한다.

fun main() {

    EventPrinter().start()

}

interface EventListener {
    fun onEvent(count:Int)
    // listener를 통해 이벤트를 반환하는 함수 이름은 관례적으로
    // 'on(행위)'라는 규칙을 따른다.
}

// interface를 why argument로 주는가?!
// Event가 발생되는 Counter Class
// Event를 발생시키기 위해 생성자에서 EventListener를 속성으로 받는다.
class Counter(var listener : EventListener) {

    fun cnt() {
        for (i in 1..100) {
            if (i % 5 == 0) listener.onEvent(i)
        }
    }
}

//class EventPrinter() : EventListener {
//    override fun onEvent(count: Int) {
//        print("${count}-")
//    }
//
//    fun start() {
//        val counter = Counter(this) // Counter instance 생성.
//
//        // 여기서 this는, EventPrinter 객체 자신을 나타내지만,
//        // (this는 키워드가 사용된 '객체 자신'을 참조하는 키워드이다.)
//        // 받는 쪽에서 EventListner만 요구했기 때문에, EventListener의 구현부만 넘겨주게 된다.
//
//        // 객체지향의 다형성.
//        // 상속받아 만들어진 Class는 superclass의 기능을 포함하여 만들어지므로,
//        // superclass에서 정의한 부분만 넘겨줄 수 있다.
//
//        counter.count()
//    }
//}

// 익명 객체(Anonymous Object)

class EventPrinter() {
    fun start() {
        val counter = Counter(object: EventListener {
            override fun onEvent(count: Int) {
                print("${count}-")
            }
        })
        counter.cnt()
    }
}