import io.mockk.spyk
import io.mockk.verify
import io.mockk.verifySequence
import org.junit.Assert.assertTrue
import org.junit.Test

class AcceptanceTest {
    @Test
    fun `snap game displays winning message if last two cards match`() {
        val console: SnapGameConsole = spyk()

        verifySequence {
            console.print("Bob turns card 'KS'")
            console.print("John turns card 'AH'")
            console.print("Bob turns card '2D'")
            console.print("John turns card '2C'")
            console.print("SNAP! John is the winner!!")
        }

    }
}