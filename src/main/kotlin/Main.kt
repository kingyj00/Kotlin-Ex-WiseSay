package com.ll

fun main() {
    println("===[ 명언 앱 ]===")

    val quotes = mutableListOf<Triple<Int, String, String>>()
    val deletedIds = mutableSetOf<Int>()
    var id = 1

    while (true) {
        print("명령) ")
        val command = readlnOrNull()?.trim()

        when {
            command == "등록" -> {
                print("명언 : ")
                val quote = readlnOrNull() ?: ""
                print("작가 : ")
                val author = readlnOrNull() ?: ""

                while (deletedIds.contains(id)) {
                    id++
                }

                quotes.add(Triple(id, quote, author))
                println("${id}번 명언이 등록되었습니다.")
                id++
            }
            command == "목록" -> {
                println("번호 / 작가 / 명언")
                println("----------------------")
                quotes.reversed().forEach { (num, q, a) ->
                    println("$num / $a / $q")
                }
            }
            command?.startsWith("삭제?id=") == true -> {
                val deleteId = command.substringAfter("삭제?id=").toIntOrNull()
                if (deleteId != null && quotes.removeIf { it.first == deleteId }) {
                    deletedIds.add(deleteId)
                    println("${deleteId}번 명언이 삭제되었습니다.")
                } else {
                    println("${deleteId}번 명언은 존재하지 않습니다.")
                }
            }
            command == "종료" -> {
                println("프로그램을 종료합니다.")
                break
            }
            else -> println("알 수 없는 명령어입니다.")
        }
    }
}
