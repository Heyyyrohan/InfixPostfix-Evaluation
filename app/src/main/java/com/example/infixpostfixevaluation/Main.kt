package com.example.infixpostfixevaluation

fun main(){

    println("Enter an Infix Expression : ") //(((5*3)+5)*6)/4
    val name = readLine().toString()
    val res = infixToPostfix(name)
    println( "The Postfix of $name is : " + res) // 5 3 * 5 + 6 * 4 /
    val finalAns = evaluation(res)
    println("The Answer of $name is : "+finalAns) // 30.0
}