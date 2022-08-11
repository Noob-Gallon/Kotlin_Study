package com.example.kotlin_study.joycey

fun main(args : Array<String>) {

    println("[ArrayList 데이터 추가, 부분 삭제, 전체 삭제 실시 - add, removeAt, clear]")

    //ArrayList 변수 선언 실시
    var list1 = ArrayList<String>()
    list1.add("하나")
    list1.add("둘")
    println("ArrayList 원본 : "+list1.toString())

    //removeAt 특정 데이터 삭제 실시
    list1.removeAt(0)
    println("ArrayList 특정 삭제 : "+list1.toString())

    //clear 전체 데이터 삭제 실시
    list1.clear()
    println("ArrayList 전체 삭제 : "+list1.toString())
}