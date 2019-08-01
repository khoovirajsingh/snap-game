import deck.Card
import deck.Deck
import deck.Ranks.*
import deck.StubbedDeck
import deck.Suits.*
import io.mockk.spyk
import io.mockk.verifySequence
import org.junit.Test

class AcceptanceTest {
    @Test
    fun `snap game displays winning message if last two cards match`() {
        val console: SnapGameConsole = spyk()
        val deck = createStubbedDeck()
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

    private fun createStubbedDeck(): Deck {
        val deck = StubbedDeck()
        deck.addCard(Card(KING, SPADE))
        deck.addCard(Card(ACE, HEART))
        deck.addCard(Card(TWO, DIAMOND))
        deck.addCard(Card(TWO, CLUB))
        return deck
    }

    private fun createSnapGame(deck: Deck, console: SnapGameConsole): SnapGame {
        val game = SnapGame(deck, console)
        game.addPlayerOne(Player("Bob", thinkTime = 2000))
        game.addPlayerTwo(Player("John", thinkTime = 1000))
        return game
    }
}