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
        deck.shuffle()
        while (deck.hasCards()) {
            turnCardForPlayers()
            checkForWinner()
        }
    }

    private fun turnCardForPlayers() {
        turnCardFor(playerOne)
        turnCardFor(playerTwo)
    }

    private fun checkForWinner() {
        if (playerOne.hasWonAgainst(playerTwo)) {
            console.print(playerOne.won())
        }
        if (playerTwo.hasWonAgainst(playerOne)) {
            console.print(playerTwo.won())
        }
    }

    private fun turnCardFor(player: Player) {
        player.card = deck.nextCard()
        console.print(player.turn())
    }

    private fun validatePlayers() {
        if (playerOne.name.isEmpty() || playerTwo.name.isEmpty()) {
            console.print(playerOne.missing())
            return
        }
    }
}
