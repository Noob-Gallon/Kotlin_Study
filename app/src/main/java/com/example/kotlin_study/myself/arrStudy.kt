package com.example.kotlin_study.myself

fun main(args:Array<String>) { // 명령 행 인자
// args:Array<String> : String을 n개 가질 수 있는 배열

    val a = Array(2, {0}) // Array(n, {fun{}) => 배열의 요소마다 fun을 이용해서(통해서) 값을 초기화 한다는 뜻.
    val b = Array<Char>(3, {'_'}) // Generic : Type Parameter, Type을 제한한다.
    val c = Array<Int?>(4, {null})
    val d : Array<String> = args
    // args는 아직 초기화되지 않았으므로 사이즈 0

    println("a.size = ${a.size}")
    println("b.size = ${b.size}")
    println("c.size = ${c.size}")
    println("d.size = ${d.size}")

    println("a.get(0) = ${a.get(0)}")
    println("b.get(0) = ${b.get(0)}")
    println("c.get(0) = ${c.get(0)}")

    a.set(0, 10)
    b.set(0, 'A')
    c.set(0, 123)

    a[0] = 10
    b[0] = 'A'
    c[0] = 123

    println("a.get(0) = ${a.get(0)}")
    println("b.get(0) = ${b.get(0)}")
    println("c.get(0) = ${c.get(0)}")

    println("a[0]] = ${a[0]}")
    println("b[0] = ${b[0]}")
    println("c[0] = ${c[0]}")
}