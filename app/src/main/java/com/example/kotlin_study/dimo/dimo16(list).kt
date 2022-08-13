package com.example.kotlin_study.dimo

// List는 데이터를 모아 관리하는 Collection Class를 상속받는 subclass중 가장 단순한 형태이다.
// 1) List<out T> : 생성시에 넣은 객체를 대체, 추가, 삭제할 수 없음.
// 2) MutableList<T> : 가능함.

// listOf(), mutableListOf()

// mutableListOf

// add(data), add(idx, data)
// remove(data), removeAt(idx)

// shuffle(), sort()
// list[idx] = data

fun main() {

    val a = listOf("사과", "딸기", "배")
    println(a[1])

    for (fruit in a) {
        print("${fruit}:")
    }

    print("\n")
    a.forEach {
        println(it)
    }

    var b = mutableListOf(6, 3, 1)
    println(b)

    b.add(4)
    println(b)

    b.add(2,8)
    println(b)

    b.removeAt(1)
    println(b)

    b.shuffle()
    println(b)

    b.sort()
    println(b)

}