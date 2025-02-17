package com.ll

fun main() {
    println("===[ 명언 앱 ]===")

    val quotes = mutableListOf<Triple<Int, String, String>>()
    var id = 1

    while (true) {
        print("명령) ")
        val command = readlnOrNull()?.trim()

        when (command) {
            "등록" -> {
                print("명언 : ")
                val quote = readlnOrNull() ?: ""
                print("작가 : ")
                val author = readlnOrNull() ?: ""

                quotes.add(Triple(id, quote, author))
                println("${id}번 명언이 등록되었습니다.")
                id++
            }
            "종료" -> {
                println("프로그램을 종료합니다.")
                break
            }
            else -> println("알 수 없는 명령어입니다.")
        }
    }
}
