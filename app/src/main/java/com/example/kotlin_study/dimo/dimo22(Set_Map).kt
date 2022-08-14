package com.example.kotlin_study.dimo

// Collection Class, (List), Set, Map.

// 1) Set
// Set은 List와 달리 순서가 정렬되지 않으며, 중복이 허용되지 않는다. Index로 객체 참조 불가능. Contents로 확인해야한다.
// Set<Out T> MutableSet<T>
// add, remove

// 2) Map
// Key & Value
// 객체의 위치가 아닌 고유한 Key를 통해 객체를 참조한다.
// 같은 Key에 다른 객체를 넣으면 기존 객체가 덮어 쓰기 된다.
// Map<K, out V> MutableMap<K, V>
// put, remove

fun main() {
    
    val a =mutableSetOf("귤", "바나나", "키위")
    
    for (item in a)
    {
        println ("${item}")
    }
    
    a.add("자몽")
    println(a)
    
    a.remove("바나나")
    println(a)
    
    println(a.contains("귤"))



    val b = mutableMapOf("레드벨벳" to "음파음파",
                         "트와이스" to "FANCY",
                         "ITZY" to "ICY")

    for (entry in b) {
        println("${entry.key} : ${entry.value}")
    }

    b.put("오마이걸", "BUNGIE")
    println(b)

    b.remove("ITZY")
    println(b)

    println(b["레드벨벳"])
}
