package fastcampus.issueservice.exception

data class ErrorResponse( // http status code 만으로 모든 에러를 잡을 수 없기 때문에 실무에서 자주 사용하는 방법
    val code: Int,
    val message: String, // 너무 많은 정보가 노출되면 안 되기 때문에 커스텀한 오류 메세지 작성
) {

}
