package fastcampus.issueservice.service

import fastcampus.issueservice.domain.Issue
import fastcampus.issueservice.domain.IssueRepository
import fastcampus.issueservice.domain.enums.IssueStatus
import fastcampus.issueservice.model.IssueRequest
import fastcampus.issueservice.model.IssueResponse
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class IssueService(
    private val issueRepository: IssueRepository,
) {

    @Transactional
    fun create(userId : Long, request: IssueRequest) : IssueResponse {

        val issue = Issue(
            summary = request.summary,
            description = request.description,
            userId = userId,
            type = request.type,
            priority = request.priority,
            status = request.status,
        )
        return IssueResponse(issueRepository.save(issue))
    }

    @Transactional(readOnly = true)
    fun getAll(status: IssueStatus) =
        issueRepository.findAllByStatusOrderByCreatedAtDesc(status)
            ?.map { IssueResponse(it) } // 반복문을 돌며 IssueResponse 타입으로 각각 받음

    @Transactional(readOnly = true)
    fun get(id: Long): IssueResponse {
        val issue = issueRepository.findByIdOrNull(id) ?: throw fastcampus.issueservice.exception.NotFoundException("이슈가 존재하지 않습니다.")
        return IssueResponse(issue)
    }

    @Transactional
    fun edit(userId: Long, id: Long, request: IssueRequest): IssueResponse {
        val issue : Issue = issueRepository.findByIdOrNull(id) ?: throw fastcampus.issueservice.exception.NotFoundException("이슈가 존재하지 않습니다.")

        return with(issue) {
            summary = request.summary
            description = request.description
            this.userId = userId
            type = request.type
            priority = request.priority
            status = request.status
            IssueResponse(issueRepository.save(this))
        }

    }
}