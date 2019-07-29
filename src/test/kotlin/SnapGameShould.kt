import deck.Deck
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class SnapGameShould {
    private val console: SnapGameConsole = spyk()
    private val deck: Deck = mockk()
    lateinit var game: SnapGame

    @Before
    fun setUp() {
        game = SnapGame(deck, console)
    }

    @Test
    fun `not be played if we don't have enough players`() {
        game.play()
        verify { console.print("We need two players to start the game") }
    }

    @Test
    fun `play if we have two players`() {
        game.addPlayerOne(Player("aTestPlayer1", thinkTime = 0))
        game.addPlayerTwo(Player("aTestPlayer2", thinkTime = 0))
        game.play()
        verify (exactly = 0) { console.print(any()) }
    }
}