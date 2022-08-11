package com.example.kotlin_study.myself

class Account1(val name : String, val birth : String, var balance : Int = 0){

    init {
        println("${name}(${birth})님의 계좌가 개설되었습니다. 현재 잔고 : ${balance}원")
    }

    constructor(name:String, birth:String) : this(name, birth, 0)

    fun check_balance() : Int {
        if (balance <= 0) {
            return 0
        }
        else {
            return balance
        }
    }

    fun save_money(money : Int) {
        if (money > 0) {
            balance+=money
        }
    }

    fun withdraw(amount : Int) {
        if (amount > balance) {
            return;
        }

        balance -= amount
    }
}

fun main() {

    val person = Account1("정동교", "2000-08-06", 10000)

    println("현재 잔고 "+person.check_balance())

    person.withdraw(5000)
    println("현재 잔고 "+person.check_balance())

    person.save_money(3000)
    println("현재 잔고 "+person.check_balance())

}