package com.example.kotlin_study.dimo

import kotlinx.coroutines.*

// 비동기로 여러개의 루틴을 동시에 처리하는 방법.
// import kotlinx.coroutines.*
// 코루틴은 제어 범위 및 실행 범위를 조절할 수 있다. => coroutine scope

// GloabalScope : 프로그램 어디서나 제어, 동작이 가능한 기본 범위
// CoroutineScope : 특정한 목적의 Dispatcher를 지정하여 제어 및 동작이 가능한 범위.

// => Dispacher :
// Dispatchers.Default : 기본적인 백그라운드 동작
// Dispatchers.IO : I/O에 최적화 된 동작
// Dispatchers.Main : 메인(UI) 스레드에서 동작

// 코루틴 생성
// val scope = CoroutineScope(Dispatcher.Default)
// val coroutineA = scope.launch{}
// val coroutineB = scope.async{}

// launch vs async : 반환값이 있는지 여부
// launch는 반환값이 없는 Job 객체
// async는 반환값이 있는 Deffered 객체

// launch와 async는 모두 람다 함수의 형태이다. 따라서 async는 마지막 구문의 실행 결과가 반환된다.

fun main () {

    val scope = GlobalScope

//    scope.launch {
//        for (i in 1..5) //Job 객체의 코루틴 생성
//        {
//            println(i)
//        }
//    }

    runBlocking {
//        launch {
//            for (i in 5 downTo 1) {
//                println(i)
//            }
//        }

        val a = launch {
            for (i in 1..5) {
                println(i)
                delay(10)
            }
        }
            val b = async {
                "async 종료"
            }

            println("async 대기")
            println(b.await()) // async의 반환값을 b에 입력받아 출력한다. async는 Deffered 객체.

            println("launch 대기")
            a.join() // join, await은 반드시 suspend 안에서만 실행된다.

            println("launch 종료")
    }
}

    // 코루틴은 프로그램 전체가 종료되면 함께 종료된다.
    // 코루틴이 끝까지 실행되는 것을 보장하려면 일정한 범위에서 코루틴이 모두 실행될 때까지 잠시 기다려줘야 한다.

    // runBlocking() {
    // launch{}
    // async{}
    // }
    // => 이와 같이 잠시 대기시켜 주어야 한다.

    // Android에서는 메인 스레드에서 runBlocking을 걸어주면,
    // 일정 시간 이상 응답이 없는 경우 ANR(Application Node Responding)이 발생해
    // 앱이 강제로 종료된다.



    // routine의 대기를 위한 추가적인 함수
    // delay(), join(), awiat()

    // 1) delay : ms 단위로 루틴 대기
    // 2) join : Job 객체의 실행이 끝날 때까지 대기하는 함수
    // 3) await : Deffered 객체의 실행이 끝날 때까지 대기하는 함수
    // => await은 Deffered 객체의 결과도 반환함

    // 이 세 함수는 coroutine 내부 또는 runBlocking과 같은 루틴의 대기가 가능한 구문
    // 안에서만 동작이 가능하다.

    // coroutine 실행 중 중단하는 방법. cancel()
    // 코루틴에 cancel을 걸어주면 다음 두가지 조건이 발생한다.
    // 1) 코루틴 내부의 delya() 함수 or yield() 함수가 사용된 위치까지 수행된 뒤 종료됨.
    // 2) coroutine cancel()로 인해 속성인 isActive가 false가 되므로, 이를 확인하여 수동으로 종료.