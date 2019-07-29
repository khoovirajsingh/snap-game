import deck.Deck

class SnapGame(val deck: Deck, val console: SnapGameConsole) {
    var playerOne: Player? = null
    var playerTwo: Player? = null

    fun addPlayerOne(player: Player) {
        playerOne = player
    }

    fun addPlayerTwo(player: Player) {
        playerTwo = player
    }

    fun play() {
        validatePlayers()
    }

    private fun validatePlayers() {
        if (playerOne == null || playerTwo == null) {
            console.print("We need two players to start the game")
            return
        }
    }

}
