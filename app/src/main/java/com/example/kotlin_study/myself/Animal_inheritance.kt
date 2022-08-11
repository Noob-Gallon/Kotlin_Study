package com.example.kotlin_study.myself

// interface는 parameter를 받지 않는다.

open class BreedAnimal(val name : String, val species : String, var weight : Int = 10) { // 주 생성자는 class의 property로 생성된다.

    init {
        println("New animal appeared.")
        println("Name : ${name}, Species : ${species}\n\n")
    }

    fun introduce() {
        println("Name : ${this.name}\nspecies : ${this.species}\nweight : ${this.weight}\n")
    }

    open fun feedAnimal(amount : Int) {
        if (amount <= 0) {
            println("Wrong amount. Try again.\n")
            return;
        }

        println("Feed ${this.name}, Amount : ${amount}\n")
        this.weight += amount
        println("${this.name}'s weight : ${this.weight}\n")
    }

    open fun sleepAnimal(amount : Int) {
        if (amount <= 0) {
            println("Wrong amount. Try again.\n")
            return;
        }

        println("${this.name} has slept for ${amount} hours\n")
    }

    open fun walkAnimal(amount : Int) {
        if (this.weight > 10) {
            this.weight -= amount
        }

        println("${this.name} has walked for ${amount} hours\n")
    }
}

class BreedAstone(name:String, weight:Int) : BreedAnimal(name, "돌", weight) {

    override fun feedAnimal(amount: Int) {
        println("Stones don't need to eat")
    }

    override fun sleepAnimal(amount: Int) {
        println("stones don't need to sleep")
    }

    override fun walkAnimal(amount: Int) {
        println("stones don't need to take a walk")
    }

    fun endureForever() {
        println("This stone is enduring")
    }
}

fun main() {

    val myAnimal = BreedAnimal("주꿀꿀", "돼지")
    myAnimal.introduce()

    myAnimal.feedAnimal(30)
    myAnimal.sleepAnimal(8)

    myAnimal.walkAnimal(10)

    myAnimal.introduce()

    val myStone = BreedAstone("돌돌이", 1)
    myStone.introduce()

    myStone.sleepAnimal(10)
    myStone.feedAnimal(10)
    myStone.walkAnimal(10)
    myStone.endureForever()
}