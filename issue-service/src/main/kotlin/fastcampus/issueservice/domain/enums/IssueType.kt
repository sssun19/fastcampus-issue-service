package fastcampus.issueservice.domain.enums

enum class IssueType {

    BUG, TASK;

    companion object {
//        fun of(type: String) = valueOf(type.uppercase())
        operator fun invoke(type: String) = valueOf(type.uppercase())

    }
}

fun main() {

//    val type = IssueType.of("BUG")
    val type = IssueType("BUG") // 코틀린에서는 operator invoke 를 사용해 마치 생성자에 직접 파라미터를 대입한 것처럼 편리하게 사용할 수 있다.
    IssueType.BUG == type
}
