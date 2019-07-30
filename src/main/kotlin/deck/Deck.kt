package deck

import deck.Ranks.*
import deck.Suits.*

class Deck {
    private val cards = mutableSetOf<Card>()

    fun nextCard(): Card {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun hasCards(): Boolean {
        return cards.isNotEmpty()
    }

    fun shuffle() {
        cards.add(Card(ACE, HEART))
    }
}
