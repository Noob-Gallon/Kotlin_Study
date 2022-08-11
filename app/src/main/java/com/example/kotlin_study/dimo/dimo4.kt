package com.example.kotlin_study.dimo

fun main() {

    loop@
    for (i in 1..10) {
        for (j in 1..10) {
            if (i == 1 && j == 2) break@loop

            println ("i : ${i}, j : ${j}")
        }

        // 이중 for문을 탈출하려면 여기서도 break가 필요하다.
    }

    // 외부 반복문에 레이블 이름과 @ 기호를 달고
    // break에서 @과 label 이름을 달아주면
    // 레이블이 달린 반복문을 기준으로 즉시 break를 시켜준다.
    // 물론, continue도 마찬가지이다.
}