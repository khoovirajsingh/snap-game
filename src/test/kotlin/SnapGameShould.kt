import deck.Card
import deck.Deck
import deck.Ranks.TWO
import deck.Suits.HEART
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test

class SnapGameShould {
    private val console: SnapGameConsole = spyk()
    private val deck: Deck = mockk()
    lateinit var game: SnapGame

    private val playerOne = Player("PlayerOne", thinkTime = 1000)
    private val playerTwo = Player("PlayerTwo", thinkTime = 2000)

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
        addPlayers()

        game.play()

        verify (exactly = 0) { console.print(any()) }
    }

    @Test
    fun `set player one with the next card that is drawn from the deck`() {
        addPlayers()
        every { deck.nextCard() } returns Card(TWO, HEART)

        game.play()

        playerOne.card shouldEqual Card(TWO, HEART)
    }

    private fun addPlayers() {
        game.addPlayerOne(playerOne)
        game.addPlayerTwo(playerTwo)
    }
}