package com.ll

fun main() {
    println("===[ 명언앱 ]===")

    while (true) {
        print("명언 : ")

        val input = readlnOrNull()

        if (input== "종료"){
            break
        }
        println("입련한 명언 : $input")
    }
}