package deck

class Deck {
    private val cards = mutableListOf<Card>()

    init {
        addCardsToDeck()
    }

    fun nextCard(): Card {
        return cards.removeAt(0)
    }

    fun hasCards(): Boolean {
        return cards.isNotEmpty()
    }

    fun shuffle() {
        cards.shuffle()
    }

    private fun addCardsToDeck() {
        enumValues<Suits>().forEach {
                suit -> enumValues<Ranks>().forEach {
                rank -> cards.add(Card(rank, suit)) } }
    }
}
