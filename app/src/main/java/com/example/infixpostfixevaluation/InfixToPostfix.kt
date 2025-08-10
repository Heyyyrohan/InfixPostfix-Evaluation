package com.example.infixpostfixevaluation

fun infixToPostfix(infix : String) :String {
        val stack = java.util.Stack<Char>()
        val result = StringBuilder()

        for (ch in infix.replace(" ","")){
                when{
                        ch.isDigit() -> result.append(ch)
                        ch.isLetter() -> result.append(ch)
                        ch == '(' -> stack.push(ch)
                        ch == ')' -> {
                                while( stack.isNotEmpty() && stack.peek() != '('){
                                        result.append(' ').append(stack.pop())
                                }
                                if(stack.isNotEmpty() && stack.peek() == '('){
                                        stack.pop()
                                }
                        }

                        isOperator(ch) -> {
                                result.append(' ')
                                while(stack.isNotEmpty() && precedence(ch) <= precedence(stack.peek())){
                                        result.append(ch).append(' ')
                                }
                                stack.push(ch)
                        }


                }
        }
        while (stack.isNotEmpty() ){
                result.append(' ').append(stack.pop())
        }

        return result.toString()
}

fun isOperator( ch : Char) : Boolean {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^'
}

fun precedence(op : Char ) : Int = when(op){
        '+','-' -> 1
        '*','/' -> 2
        '^' -> 3
        else -> -1
}