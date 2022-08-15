package com.example.kotlin_study.dimo

import kotlinx.coroutines.*

//fun main () {
//
//    runBlocking {
//
//        val a = launch {
//            for (i in 1..5) {
//                println(i)
//                delay(10)
//            }
//        }
//        val b = async {
//            "async 종료"
//        }
//
//        println("async 대기")
//        println(b.await()) // async의 반환값을 b에 입력받아 출력한다. async는 Deffered 객체.
//
//        println("launch 취소")
//        a.cancel() // for loop에서 delay()를 만나 종료.
//
//        println("launch 종료")
//    }
//}

// withTimeoutOrNull() : 제한시간 내에 수행되면 결과값을, 아니면 null을 반환하는 함수.
// =>

fun main() {

    runBlocking {
        var result = withTimeoutOrNull(50) {
            for (i in 1..2) {
                println(i)
                delay(1)
            }
        }

        println(result)
    }

}