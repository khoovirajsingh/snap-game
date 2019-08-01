import deck.Card

class Player(val name: String = "", val thinkTime: Int = 0) {
    var card: Card? = null

    fun isValid() = name.isNotEmpty()

    private fun cardMatches(anotherPlayer: Player) = card?.ranks == anotherPlayer.card?.ranks

    private fun isFaster(anotherPlayer: Player) = thinkTime < anotherPlayer.thinkTime

    fun hasWonAgainst(anotherPlayer: Player) = cardMatches(anotherPlayer) && isFaster(anotherPlayer)

    fun turn() = "$name turns card '${card?.ranks?.value}${card?.suits?.value}'"

    fun won() = "SNAP! ${name} is the winner!!"

    fun missing() = "We need two players to start the game"
}
