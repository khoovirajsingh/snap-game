import deck.Card
import deck.Deck
import deck.Ranks.*
import deck.Suits.*
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

    private val playerOne = Player("Player One", thinkTime = 1000)
    private val playerTwo = Player("Player Two", thinkTime = 2000)

    @Before
    fun setUp() {
        game = SnapGame(deck, console)
        addPlayers()
        createStubbedDeck()
    }

    @Test
    fun `not be played if we don't have enough players`() {
        addEmptyPlayers()
        game.play()
        verify { console.print("We need two players to start the game") }
    }

    @Test
    fun `play if we have two players`() {
        game.play()
        verify (exactly = 0) { console.print(any()) }
    }

    @Test
    fun `set Player One with the next card that is drawn from the deck`() {
        game.play()
        playerOne.card shouldEqual Card(TWO, HEART)
    }

    @Test
    fun `set Player One and Player Two with the next cards that are drawn from the deck`() {
        game.play()
        playerOne.card shouldEqual Card(TWO, HEART)
        playerTwo.card shouldEqual Card(TWO, SPADE)
    }

    @Test
    fun `display Player One is a winner if the card matches and Player One has faster think time`() {
        game.play()
        verify { console.print("SNAP! Player One is the winner!!") }
    }

    private fun addPlayers() {
        game.addPlayerOne(playerOne)
        game.addPlayerTwo(playerTwo)
    }

    private fun createStubbedDeck() {
        every { deck.nextCard() } returns
                Card(TWO, HEART) andThen
                Card(TWO, SPADE)
    }

    private fun addEmptyPlayers() {
        game.addPlayerOne(Player())
        game.addPlayerTwo(Player())
    }
}