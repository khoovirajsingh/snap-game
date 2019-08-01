package deck

class SnapGameDeck : Deck {
    private val cards = mutableListOf<Card>()

    init {
        addCardsToDeck()
    }

    override fun nextCard(): Card {
        return cards.removeAt(0)
    }

    override fun hasCards(): Boolean {
        return cards.isNotEmpty()
    }

    override fun shuffle() {
        cards.shuffle()
    }

    private fun addCardsToDeck() {
        enumValues<Suits>().forEach {
                suit -> enumValues<Ranks>().forEach {
                rank -> cards.add(Card(rank, suit)) } }
    }
}
