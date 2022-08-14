package com.example.kotlin_study.dimo

// 컬렉션 함수
// list, set, map과 같은 collection or array에 일반 함수, 혹은 람다 함수 형태를 사용하여
// for문 없이도 아이템을 참조하거나 조건을 걸고 요소의 변경까지 가능한 함수들을 지칭한다.

// ex)
// collection.forEach {
// println(it)
// }

// collection.filter { => 다시 collection으로 만들어준다.
// it < 4
// }

// collection.map { => 일괄적으로 collection 요소들의 값을 변경해준다.
// it*2
// }

// collection.any {it == 0}, collection.all {it == 0}, collection.none {it == 0} => Boolean 반환.
// collection.first() => 첫 번째 아이템 반환
// collection.first {it > 3} => 조건에 맞는 첫 번째 요소 반환

// first -> find 대체 가능.
// last -> findLast 대체 가능.
// 이 함수들을 사용할 때 발생하는 문제.
// NoSuchElementException. Error 발생 가능.
// firstOrNull, last OrNull => 객체가 없는 경우 Null을 반환.

// collection.count() : 컬렉션의 모든 아이템의 개수를 반환
// collection.count{it>7} : 조건에 맞는 요소의 개수 반환

fun main() {

    val nameList = listOf("박수영", "김지수", "김다현", "신유나", "김지우")

    nameList.forEach{ print(it + " ")}
    println()
    
    println(nameList.filter{ it.startsWith("김")})

    println(nameList.map{"이름 : " + it})

    println("김지연이 있는가? :"+nameList.any{ it == "김지연"})

    println(nameList.all{it.length == 3})
    println(nameList.none{it.startsWith("이")})
    println(nameList.first{it.startsWith("김")})
    println(nameList.last{it.startsWith("김")})
    println(nameList.firstOrNull{it.startsWith("정")})
    println(nameList.lastOrNull{it.startsWith("정")})
    println(nameList.count{it.contains("지")}) // contains는 스트링만 포함?
    // collection 함수는 경우에 따라 조건문과 반복문 대신 사용하면 아주 편리하다.
}