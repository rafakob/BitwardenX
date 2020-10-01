import io.reactivex.Scheduler
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.TestScheduler
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.util.concurrent.TimeUnit

class RxRule(private val testScheduler: TestScheduler = TestScheduler()) : Scheduler(), TestRule {
    override fun apply(base: Statement, description: Description): Statement =
        object : Statement() {
            override fun evaluate() {
                // Override all of the default schedulers so we can use our testScheduler when testing.
                RxJavaPlugins.setComputationSchedulerHandler { testScheduler }
                RxJavaPlugins.setIoSchedulerHandler { testScheduler }
                RxJavaPlugins.setSingleSchedulerHandler { testScheduler }
                RxJavaPlugins.setNewThreadSchedulerHandler { testScheduler }

                try {
                    base.evaluate()
                } finally {
                    RxJavaPlugins.reset()
                }
            }
        }

    override fun createWorker() = testScheduler.createWorker()

    fun advanceTimeBy(delayTime: Long, unit: TimeUnit) =
        testScheduler.advanceTimeBy(delayTime, unit)

    fun triggerActions() = testScheduler.triggerActions()
}