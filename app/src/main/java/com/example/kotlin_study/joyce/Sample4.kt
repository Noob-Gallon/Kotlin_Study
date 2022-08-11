package com.example.kotlin_study.joyce

//Singleton Pattern.
//모든 앱을 실행할 때 딱 한번만 생성되는 객체. object.

object CarFactory {
    val cars = mutableListOf<Car>()
    fun makeCar(horsePower: Int) : Car { // data class Car를 return한다.
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}
// object는 앱 실행 시에 한 번만 생성하기 때문에, mutableList를 만들어두면 계속 유지된다.
// 어디서 사용되건 간에 처음 Compile 될 때 만들어진 instance 하나 뿐이다.

data class Car(val horsePower : Int)

fun main() {

    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(200)
    // CarFactory를 따로 만들지 않아도 사용 가능?

    println(car)
    println(car2)
    println(CarFactory.cars.size.toString())
}