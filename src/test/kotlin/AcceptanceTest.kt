import deck.Card
import deck.Deck
import deck.Suits.*
import deck.Ranks.*
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verifySequence
import org.junit.Test

class AcceptanceTest {
    @Test
    fun `snap game displays winning message if last two cards match`() {
        val console: SnapGameConsole = spyk()
        val deck = setupDeck()
        val game = createSnapGame(deck, console)

        game.play()

        verifySequence {
            console.print("Bob turns card 'KS'")
            console.print("John turns card 'AH'")
            console.print("Bob turns card '2D'")
            console.print("John turns card '2C'")
            console.print("SNAP! John is the winner!!")
        }
    }

    private fun setupDeck(): Deck {
        val deck: Deck = mockk()
        every { deck.nextCard() } returns
                Card(KING, SPADE) andThen
                Card(ACE, HEART) andThen
                Card(TWO, DIAMOND) andThen
                Card(TWO, CLUB)
        return deck
    }

    private fun createSnapGame(deck: Deck, console: SnapGameConsole): SnapGame {
        val game = SnapGame(deck, console)
        game.addPlayerOne(Player("Bob", thinkTime = 2000))
        game.addPlayerTwo(Player("John", thinkTime = 1000))
        return game
    }
}