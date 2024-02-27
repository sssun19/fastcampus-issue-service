package fastcampus.issueservice.model

import fastcampus.issueservice.domain.Comment

data class CommentRequest(
    val body : String,
)

data class CommentResponse(
    val id : Long,
    val issueId : Long,
    val userId : Long,
    val body : String,
    val userName : String? = null,
)

// operator invoke 와 동일한 기능, 코틀린의 확장 함수 기능을 이용해 구현
fun Comment.toResponse() = CommentResponse(
    id = id!!,
    issueId = issue.id!!,
    userId = userId,
    body = body,
    userName = username,
)