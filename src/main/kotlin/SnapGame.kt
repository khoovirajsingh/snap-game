import deck.Deck

class SnapGame(private val deck: Deck, private val console: SnapGameConsole) {
    private var playerOne: Player = Player()
    private var playerTwo: Player = Player()

    fun addPlayerOne(player: Player) {
        playerOne = player
    }

    fun addPlayerTwo(player: Player) {
        playerTwo = player
    }

    fun play() {
        validatePlayers()
        playerOne.card = deck.nextCard()
        playerTwo.card = deck.nextCard()
        if (playerOne.hasWonAgainst(playerTwo)) {
            console.print("SNAP! ${playerOne.name} is the winner!!")
        }
    }

    private fun validatePlayers() {
        if (playerOne.name.isEmpty() || playerTwo.name.isEmpty()) {
            console.print("We need two players to start the game")
            return
        }
    }
}
