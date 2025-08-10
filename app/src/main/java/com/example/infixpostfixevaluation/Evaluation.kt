package com.example.infixpostfixevaluation

fun evaluation(postfix : String ) : Double {
    val stack = java.util.Stack<Double>()
    val tokens = postfix.trim().split(" ").filter{it.isNotEmpty()}

    for(token in tokens){

        when{
            token.toDoubleOrNull() != null -> stack.push(token.toDouble())
            else -> {
                val b = stack.pop()
                val a = stack.pop()

                val res = when(token){
                    "+" -> a + b
                    "-" -> a - b
                    "*" -> a * b
                    "/" -> a / b
                    "^" -> Math.pow(a,b)

                    else -> throw IllegalArgumentException("Invalid Operator")
                }

                stack.push(res)

            }
        }

    }

    return stack.pop()
}