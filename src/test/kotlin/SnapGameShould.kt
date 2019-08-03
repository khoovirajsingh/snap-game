import deck.Card
import deck.Ranks.TWO
import deck.StubbedDeck
import deck.Suits.HEART
import deck.Suits.SPADE
import io.mockk.spyk
import io.mockk.verify
import org.amshove.kluent.`should be`
import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach


class SnapGameShould {
    private val console: SnapGameConsole = spyk()
    lateinit var deck: StubbedDeck
    lateinit var game: SnapGame

    private val playerOne = Player("Player One", thinkTime = 1000)
    private val playerTwo = Player("Player Two", thinkTime = 2000)

    @BeforeEach
    fun setUp() {
        deck = createStubbedDeck()
        game = SnapGame(deck, console)
        addPlayers()
    }

    @Test
    fun `not be played if we don't have enough players`() {
        addEmptyPlayers()
        game.play()
        verify { console.print("We need two players to start the game") }
    }

    @Test
    fun `shuffle deck before playing the game`() {
        game.play()
        deck.hasBeenShuffled `should be` true
    }

    @Test
    fun `set Player One with the next card that is drawn from the deck`() {
        game.play()
        playerOne.card `should equal` Card(TWO, HEART)
    }

    @Test
    fun `set Player One and Player Two with the next cards that are drawn from the deck`() {
        game.play()
        playerOne.card `should equal` Card(TWO, HEART)
        playerTwo.card `should equal` Card(TWO, SPADE)
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

    private fun createStubbedDeck(): StubbedDeck {
        val deck = StubbedDeck()
        deck.addCard(Card(TWO, HEART))
        deck.addCard(Card(TWO, SPADE))
        return deck
    }

    private fun addEmptyPlayers() {
        game.addPlayerOne(Player())
        game.addPlayerTwo(Player())
    }
}