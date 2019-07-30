import deck.Card

class Player(val name: String = "", val thinkTime: Int = 0) {
    fun isValid() = name.isNotEmpty()

    private fun cardMatches(anotherPlayer: Player) = card == anotherPlayer.card

    private fun isFaster(anotherPlayer: Player) = thinkTime < anotherPlayer.thinkTime

    fun hasWonAgainst(anotherPlayer: Player) = cardMatches(anotherPlayer) && isFaster(anotherPlayer)

    var card: Card? = null
}
