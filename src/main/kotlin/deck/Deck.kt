package deck

interface Deck {
    fun nextCard(): Card
    fun hasCards(): Boolean
    fun shuffle()
}