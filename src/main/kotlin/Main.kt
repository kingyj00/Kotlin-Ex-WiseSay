package com.ll

fun main() {
    println("===[ 명언 앱 ]===")

    val quotes = mutableListOf<Pair<String, String>>()

    while (true) {
        print("명령) ")
        val command = readlnOrNull()?.trim()

        when (command) {
            "등록" -> {
                print("명언 : ")
                val quote = readlnOrNull() ?: ""
                print("작가 : ")
                val author = readlnOrNull() ?: ""
                quotes.add(Pair(quote, author))
                println("${quotes.size}번 명언이 등록되었습니다.")
            }
            "종료" -> {
                println("프로그램을 종료합니다.")
                break
            }
            else -> println("알 수 없는 명령어입니다.")
        }
    }
}