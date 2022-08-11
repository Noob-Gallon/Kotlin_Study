package com.example.kotlin_study.joyce

// Run은 Ctrl+Shift+F10

fun main() {
    helloWorld();

    println(add(4,5));

    // 3. String 템플릿

    val name = "Joyce"
    val lastName = "Hong"
    println("My name is ${name} ${lastName} I'm 23"); // 문자열 속에 변수를 넣는 법, Javascript와 유사
    println("is this true? ${1==0}");
    println("this is 2\$");


    checkNum(5)

    forAndWhile()

    nullcheck()

    ignoreNulls("I'm a boy")
}

// 1. 함수
// kotlin은 무엇을 return 하는 지에 관계없이 앞에는 항상 function의 줄임말 fun을 작성한다.

fun helloWorld() : Unit { // return 하는 것이 없으면 return 형으로 Unit 이라고 써준다. 굳이 안써도 되긴 함.
    println("Hello World!");
}

fun add(a : Int, b : Int) : Int { // (변수명 : 변수 타입, 변수명 : 변수 타입) : 반환형
    return a+b;
}

// 2. val vs var
// val = value

fun hi() {
    val a : Int = 10; // 변하지 않는 값, value Javascript의 const
    var b : Int = 9; // 변할 수 있는 값, variable Javascript의 let
    var e : String; // 바로 할당은 하지 않아도 되지만, 변수형은 선언해줘야 한다.

    b = 100;
    val c : Int = 100;
    var d = 100; // : Int는 쓰지 않아도 된다.

    var name = "joyce";
}

fun maxBy(a:Int, b:Int) : Int {
    if (a > b) {
        return a;
    }
    else {
        return b;
    }
}

fun MaxBy2(a : Int, b : Int) = if(a>b) a else b

fun checkNum(score : Int) {
    when(score) { // when은 다른 언어의 switch를 대체한다.
        0 -> println("this is 0")
        1 -> println("this is 1")
        2, 3 -> println("this is 2 or 3")
        else -> println("I don't know") // else는 쓰지 않아도 된다.
    }

    var b : Int = when(score) {
        1 -> 1
        2 -> 2
        else -> 3
    }

    println("b : ${b}")

    when(score) { // switch
        in 90..100 -> println("You are genius")
        in 10..80 -> println("Not bad")
        else -> println("okay") //
    }
}

// Expression vs Statement
/*
값을 만들면 표현식. (return)
Kotlin의 모든 함수는 Expression이다.
아무것도 리턴하지 않더라도, 사실은 fun newFunc(a : Int) : Unit { ... } 이므로,
return이 존재한다. (Unit) 즉, 값을 반환하면 Expression

명령을 제시하는 문장같은 경우는 Statement
 */

// 5. Array vs List

// Array는 처음에 크기를 지정해주어야 한다.
// List 1. List 2. Mutable List
// Mutable List는 수정이 가능하며, List는 수정이 불가능.

fun array() {
    val array = arrayOf(1, 2, 3) // arrayOf로 array 초기화
    val list = listOf(1, 2, 3)

    val array2 : Array<Any> = arrayOf(1, "d", 3.4f)
    val list2 : List<Any> = listOf(1, "d", 11L)

    // 기본적으로 array는 size를 변경하지 않는다면, 수정이 가능하다.
    array[0] = 3
    // list[0] = 2
    var res : Int = list.get(0)

    val arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
    arrayList[0] = 20

    // val로 선언할 경우, re-assign 불가 arrayList = arrayListOf()
}

// 6. for / while

fun forAndWhile() {

    val students = arrayListOf("joyce", "james", "jenny", "jennifer")

    for (name in students) {
        println("${name}")
    }

    //withIndex() Function을 사용하면 이름과 idx를 함께 사용 가능하다.
    for ((index, name) in students.withIndex()) { // js는 forEach가 elem, idx 순인데, 이건 반대
        println("${index+1}번째 학생 : ${name}")
    }

    var sum : Int = 0
    for (i in 1..10 step 2) {
        sum+=i
    }
    println(sum)
    sum = 0

    for (i in 10 downTo 1) {
        sum+=i
    }
    println(sum)
    sum = 0

    for (i in 1 until 10) {
        // 10을 포함하지 않는다.
        // 1..10은 10을 포함한다.
        sum+=i
    }
    println(sum)

    var index = 0
    while (index < 10) {
        println("current index : ${index++}")
    }
}

// 7. Nullable / NonNull

fun nullcheck() {
    //NPE : Null Pointer Exception
    // Java에서는 Compile 시점에서 잡을 수 없고, Runti  me에서만 잡을 수 있는 오류
    // 그래서 Kotlin에서는 Complie에서 잡기 위해 나옴.

    var name : String = "joyce" // null이면 안되는 타입. nonNull
    // var nullName : String = null ===> Error!

    var nullName : String? = null
    // 물음표를 넣으면 null이 될 수 있고, 안넣으면 null이 안된다.
    // variable type을 생략할 수 없다.

    var nameInUpperCase =  name.uppercase()
    var nullNameInUpperCase = nullName?.uppercase()
    // 물음표를 붙이는 것의 의미.
    // ?를 붙이면 nullName이 null일 수도 있고, 아닐 수도 있다는 뜻.
    // 만약 nullName이 null이라면 null을 반환, 아니면 값을 반환.

    // ?: Elvis 연산자, 자주 사용됨.
    val lastName : String? = null // nullable type
    val lastName2 : String? = "Caroline"

    val fullName = name+" "+(lastName?: "No lastName")
    // lastName이 null이 아니면 출력, 만약 null이면 default value로 출력
    val fullName2 = name+" "+(lastName2?: " No lastName")

    println(nameInUpperCase)
    println(nullNameInUpperCase)
    println("fullName1 : ${fullName}")
    println("fullName2 : ${fullName2}")
}

fun ignoreNulls(str : String?) {
    val mNotNull : String = str!! // 하늘이 두 쪽 나도 절대 null이 될 수 없는 값.
    val upper = mNotNull.uppercase() // 굳이 ?를 쓰지 않아도 된다. 왜냐면 위에서 !!로 체크 했기때문.
    println(upper)

    val lower = mNotNull.lowercase()
    println(lower)

    // 단, !!는 100% 확실하지 않은 이상 사용을 지양해야 하며,
    // nullName?.toUpperCase()와 같이 ?를 자주 사용,
    // Elvis operator를 이용해 null 판단 자주 사용.

    val email : String? = "joycehongXXXX@nana.vom"

    // let 함수는 자신의 receiver 객체를 lambda 식 내부로 옮겨서 실행한다.
    email?.let{ // 만약 email이 null일 경우, 안에 있는 println은 실행되지 않는다.
        println("my email is ${email}") // email대신 it 사용 가능. this와 비슷함?
        println("my email is ${it}")
    }

    // Null은 Kotlin에서 굉장히 많이 쓸 수 밖에 없다.
}