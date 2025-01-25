import com.example.Choice
import com.example.Player
import com.example.determineWinner
import com.example.getRandomChoices
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RockPaperScissorsTest {

    @Test
    fun `test determineWinner for Player A wins`() {
        assertEquals(Player.PLAYER_A, determineWinner(Choice.ROCK, Choice.SCISSOR))
        assertEquals(Player.PLAYER_A, determineWinner(Choice.PAPER, Choice.ROCK))
        assertEquals(Player.PLAYER_A, determineWinner(Choice.SCISSOR, Choice.PAPER))
    }

    @Test
    fun `test determineWinner for Player B wins`() {
        assertEquals(Player.PLAYER_B, determineWinner(Choice.SCISSOR, Choice.ROCK))
        assertEquals(Player.PLAYER_B, determineWinner(Choice.ROCK, Choice.PAPER))
        assertEquals(Player.PLAYER_B, determineWinner(Choice.PAPER, Choice.SCISSOR))
    }

    @Test
    fun `test determineWinner for Draw`() {
        assertEquals(Player.NONE, determineWinner(Choice.ROCK, Choice.ROCK))
        assertEquals(Player.NONE, determineWinner(Choice.PAPER, Choice.PAPER))
        assertEquals(Player.NONE, determineWinner(Choice.SCISSOR, Choice.SCISSOR))
    }

    @Test
    fun `test getRandomChoices generates valid choices`() {
        val choice = getRandomChoices()
        assert(choice in Choice.entries.toTypedArray()) { "Generated choice is not valid: $choice" }
    }

    @Test
    fun `test main game simulation logic`() {
        var playerAWins = 0
        var playerBWins = 0
        var draws = 0

        for (i in 1..100) {
            val playerA = getRandomChoices()
            val playerB = getRandomChoices()
            when (determineWinner(playerA, playerB)) {
                Player.PLAYER_A -> playerAWins++
                Player.PLAYER_B -> playerBWins++
                Player.NONE -> draws++
            }
        }

        // Assert total games add up to 100
        val totalGames = playerAWins + playerBWins + draws
        assertEquals(100, totalGames, "Total rounds should equal 100")
    }

}
