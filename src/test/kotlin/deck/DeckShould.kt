package deck

import org.amshove.kluent.`should be`
import org.amshove.kluent.`should not be`
import org.junit.jupiter.api.Test

class DeckShould {

    @Test
    fun `contain cards`() {
        val  deck = Deck()
        deck.hasCards() `should be` true
    }

        @Test
    fun `contain 52 unique cards`() {
        val deck = Deck()
        val previousCard = deck.nextCard()
        var numberOfCards = 1

        while (deck.hasCards()) {
            previousCard `should not be` deck.nextCard()
            numberOfCards++
        }

        numberOfCards `should be` 52
    }
}