package org.abhijitsarkar.touchstone.execution.junit

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

/**
 * @author Abhijit Sarkar
 */
@ExtendWith(SpringExtension::class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase
@ActiveProfiles("test")
class JUnitExecutionSummaryRepositoryTest {
    @Autowired
    private lateinit var repo: JUnitExecutionSummaryRepository

    @Test
    fun `should find previously persisted summary`() {
        val id = TestExecutionId(1, 1)
        val summary = JUnitExecutionSummary().apply {
            this.id = id
            timeStarted = OffsetDateTime.now()
            timeFinished = timeStarted.plusMinutes(1)
            failures = listOf(
                    TestFailure().also { tf ->
                        tf.testId = "test"
                        tf.message = "test"
                    }
            )
        }

        repo.save(summary)

        val saved = repo.findById(id)

        assertThat(saved).isNotEmpty
        assertThat(saved.get().failures).isNotEmpty
    }
}