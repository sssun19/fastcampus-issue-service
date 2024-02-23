package fastcampus.issueservice.exception

import com.auth0.jwt.exceptions.TokenExpiredException
import mu.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice // controller 에서 발생하는 모든 예외를 감지할 수 있는 annotation
class GlobalExceptionHandler {

    private val logger = KotlinLogging.logger {  }

    @ExceptionHandler(ServerException::class)
    fun handleServerException(ex: ServerException) : ErrorResponse {
        logger.error { ex.message }

        return ErrorResponse(code = ex.code, message = ex.message)
    }

    @ExceptionHandler(TokenExpiredException::class)
    fun handleTokenExpiredException(ex: TokenExpiredException) : ErrorResponse {
        logger.error { ex.message }

        return ErrorResponse(code = 401, message = "Token Expired Error")
    }

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception) : ErrorResponse {
        logger.error { ex.message }

        return ErrorResponse(code = 500, message = "Internal Server Error") // ex.message!! 로 받으면 해킹 당하기 쉽기 때문에 서버 응답으로 내리지 말고 로깅만 확인할 것
    }
}