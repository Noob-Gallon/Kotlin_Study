package com.example.kotlin_study.joyce

// 비행기 Ticket을 담는 Class
// 타는 사람 이름
// 언제 가는지
// 좌석 번호
// 항공사 이름

data class Ticket(val companyName : String, val name : String, var date : String, var seatNumber : Int)
// data class를 이용하면 toString(), hashCode(), eqauls(), copy() method가 자동으로 만들어진다. body 생성이 필요 없음.
// Java로는 한 파일에 data class를 여러 개 만들 수 없지만, Kotlin에서는 한 파일에 여러 개 만들 수 있다.

class TicketNormal(val companyName : String, val name : String, var date : String, var seatNumber : Int)

fun main() {
    val ticketA = Ticket("koreanAir", "joyceHone", "2020-02-16", 14)
    // class가 생성됨.

    val ticketB = TicketNormal("koreanAir", "joyceHone", "2020-02-16", 14)

    println(ticketA) // println하면, dataClass는 object의 내용이 나온다.
    println(ticketB) // 주소값이 나온다.
}