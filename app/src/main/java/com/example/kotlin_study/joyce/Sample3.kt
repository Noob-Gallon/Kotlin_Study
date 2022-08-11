package com.example.kotlin_study.joyce

// 3. Companion Object
// Java의 static 대신 사용됨. 정적인 method나 변수 선언에 사용

// private constructor : 다른 곳에서는 class 생성이 불가능하게 만든다.
// 이 안에 있는 것들은 모두 static property, static method이다.
class Book private constructor(val id : Int, val name : String) {

    companion object BookFactory : IdProvider { // 상속도 받을 수 있다.

        override fun getID(): Int { // interface에서 정의되지 않은 method는 반드시 override 필요.
            return 444
        }

        val myBook = "new book" // Property

        fun create() = Book(getID(), myBook)
    }
}

// Companion Object가 하는 일?
// Private Property나 method를 읽어올 수 있도록 하는 것.
// Java의 Static의 역할을 한다.

interface IdProvider {
    fun getID() : Int // 여기서 선언도 가능하다.
}

fun main() {
    // val book = Book() 은 불가능하다. why? private constructor이므로,
    //                                반드시 내부에서 companion object에서 method를 선언해서 초기화 해준다.

    val book = Book.create() // 중간 companion은 생략 가능.

    val bookId = Book.BookFactory.getID()
    println("${book.id} ${book.name}")
}