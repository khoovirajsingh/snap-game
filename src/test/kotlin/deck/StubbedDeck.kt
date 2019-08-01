package deck

class StubbedDeck: Deck {
    var hasBeenShuffled = false
    private var cards = mutableListOf<Card>()

    override fun nextCard(): Card {
        return cards.removeAt(0)
    }

    override fun hasCards(): Boolean {
        return cards.isNotEmpty()
    }

    override fun shuffle() {
        hasBeenShuffled = true
    }

    fun addCard(card: Card) {
        cards.add(card)
    }
}