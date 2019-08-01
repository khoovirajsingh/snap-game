import deck.Card
import deck.Ranks
import deck.Ranks.*
import deck.Suits
import deck.Suits.*
import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Test

class PlayerShould {
    @Test
    fun `be valid if it has a name`() {
        val player = Player("Bob")
        player.isValid() `should be` true
    }

    @Test
    fun `be invalid if the name is empty`() {
        val player = Player()
        player.isValid() `should be` false
    }

    @Test
    fun `win if card matches and has faster think time`() {
        val player = createPlayer("Bob", 1000, Card(TWO, HEART))
        val anotherPlayer = createPlayer("Joe", 2000, Card(TWO, SPADE))

        player.hasWonAgainst(anotherPlayer) `should be` true
    }

    @Test
    fun `lose if card matches and has slower think time`() {
        val player = createPlayer("Bob", 2000, Card(TWO, HEART))
        val anotherPlayer = createPlayer("Joe", 1000, Card(THREE, SPADE))

        player.hasWonAgainst(anotherPlayer) `should be` false
    }

    private fun createPlayer(name: String, thinkTime: Int, card: Card): Player {
        val player = Player(name, thinkTime)
        player.card = card
        return player
    }
}