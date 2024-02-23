package fastcampus.issueservice.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class) // entity 에 특정한 이벤트가 발생하면 정해진 콜백 (createdDate,... 를 처리하는 annotation)
abstract class BaseEntity(

    @CreatedDate // entity 생성될 때 자동으로 값을 대입
    var createdAt: LocalDateTime? = null,

    @LastModifiedDate // 수정될 때마다 저장
    var updatedAt: LocalDateTime? = null,
    )