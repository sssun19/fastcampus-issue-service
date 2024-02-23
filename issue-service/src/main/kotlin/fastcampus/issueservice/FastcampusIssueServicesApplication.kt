package fastcampus.issueservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing // AuditingEntityListener 를 감지해 동작시키는 annotation
class FastcampusIssueServicesApplication

fun main(args: Array<String>) {
	runApplication<FastcampusIssueServicesApplication>(*args)
}
