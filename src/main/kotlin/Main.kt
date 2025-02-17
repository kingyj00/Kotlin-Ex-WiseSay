package com.ll
// 등록, 목록, 삭제 , 종료
// 삭제 시, 삭제?id= 가 아니라 삭제를 입력하면 원하는 번호를 물어보고
// 번호를 입력하면 삭제되는 방식으로 변경
fun main() {
    println("===[ 명언 앱 ]===")

    val quotes = mutableListOf<Triple<Int, String, String>>()
    val deletedIds = mutableSetOf<Int>()
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

                while (deletedIds.contains(id)) {
                    id++
                }

                quotes.add(Triple(id, quote, author))
                println("${id}번 명언이 등록되었습니다.")
                id++
            }
            "목록" -> {
                println("번호 / 작가 / 명언")
                println("----------------------")
                quotes.reversed().forEach { (num, q, a) ->
                    println("$num / $a / $q")
                }
            }
            "삭제" -> {
                print("몇 번 명언을 삭제하시겠습니까? ")
                val deleteId = readlnOrNull()?.toIntOrNull()
                if (deleteId != null && quotes.removeIf { it.first == deleteId }) {
                    deletedIds.add(deleteId)
                    println("${deleteId}번 명언이 삭제되었습니다.")
                } else {
                    println("${deleteId}번 명언은 존재하지 않습니다.")
                }
            }
            "종료" -> {
                println("프로그램을 종료합니다.")
                break
            }
            else -> println("알 수 없는 명령어입니다.")
        }
    }
}
