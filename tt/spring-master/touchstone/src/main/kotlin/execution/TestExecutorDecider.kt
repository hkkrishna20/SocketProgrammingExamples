package org.javacode.touchstone.execution

import org.javacode.touchstone.TouchstoneProperties
import org.slf4j.LoggerFactory
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.job.flow.FlowExecutionStatus
import org.springframework.batch.core.job.flow.JobExecutionDecider

/**
 * @author Abhijit Sarkar
 */
class TestExecutorDecider(private val touchstoneProperties: TouchstoneProperties) : JobExecutionDecider {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(TestExecutorDecider::class.java)
    }

    override fun decide(jobExecution: JobExecution, stepExecution: StepExecution): FlowExecutionStatus {
        return when (stepExecution.exitStatus.compareTo(ExitStatus.FAILED)) {
            0 -> {
                LOGGER.warn("One or more preconditions failed. Skipping test execution")
                FlowExecutionStatus("SKIPPED")
            }
            else -> {
                LOGGER.info("Test executor: {}", touchstoneProperties.testExecutor)
                return FlowExecutionStatus(touchstoneProperties.testExecutor.name)
            }
        }
    }
}