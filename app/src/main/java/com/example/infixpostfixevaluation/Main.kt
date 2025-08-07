package com.example.infixpostfixevaluation

fun main(){
    val name = "(((5*3)+5)*6)/4"
    val res = infixToPostfix(name)
    println(res)
}