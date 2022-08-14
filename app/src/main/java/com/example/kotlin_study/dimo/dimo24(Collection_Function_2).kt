package com.example.kotlin_study.dimo

// associateBy : 객체에서 아이템 key를 뽑아내서 map으로 만드는 함수.
// groupBy : 특정한 값을 key로 지정하여 해당 값을 가진 객체끼리 묶은 배열을 value로 하는 map을 만드는 기능
// partition : 아이템에 조건을 걸어 true인지 false인지에 따라 두 collection으로 나누고, Pair라는 class 객체로 나뉘므로,
// first, second로 참조하여 사용하면 된다. 아니면 두 개의 객체로 class를 전달 받는다.

// flatMap() : 아이템마다 만들어진 컬렉션을 합쳐서 반환하는 함수
// getOrElse() : 인덱스 위치에 아이템이 있으면 아이템을 반환하고, 아닌 경우 지정한 기본값을 반환하는 함수{중괄호 안의 함수}
// zip : 두 컬렉션 안에 포함된 아이템을 1:1로 매칭하여 새 컬렉션을 만들어준다.
// => 결과 List의 Item의 개수는 더 작은 컬렉션을 따라가게 된다.

fun main() {

    data class Person(val name: String, val birthYear: Int)

    val personList = listOf(Person("유나", 1992), Person("조이", 1996), Person("츄", 1999), Person("유나", 2003))

    println(personList.associateBy{it.birthYear})
    // {1992=Person(name=유나, birthYear=1992), 1996=Person(name=조이, birthYear=1996), 1999=Person(name=츄, birthYear=1999), 2003=Person(name=유나, birthYear=2003)}

    println(personList.groupBy{it.name})
    // {유나=[Person(name=유나, birthYear=1992), Person(name=유나, birthYear=2003)], 조이=[Person(name=조이, birthYear=1996)], 츄=[Person(name=츄, birthYear=1999)]}

    val (over98, under98) = personList.partition { it.birthYear > 1998 } // 좌측이 true,  우측이 false

    println(over98)
    // [Person(name=츄, birthYear=1999), Person(name=유나, birthYear=2003)]

    println(under98)
    // [Person(name=유나, birthYear=1992), Person(name=조이, birthYear=1996)]

    println()

    val numbers = listOf(-3, 7, 2, -10, 1)

    println(numbers.flatMap { listOf(it * 10, it + 10, it / 3)})
    // [-30, 7, -1, 70, 17, 2, 20, 12, 0, -100, 0, -3, 10, 11, 0]

    println(numbers.getOrElse(1) {50}) // 7
    println(numbers.getOrElse(10) {50}) // 50

    val names = listOf("A", "B", "C", "D")

    println(names zip numbers)
    // [(A, -3), (B, 7), (C, 2), (D, -10)]

}