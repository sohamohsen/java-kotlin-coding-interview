package com.example
import kotlin.random.Random

fun main() {
    var playerAWins = 0
    var playerBWins = 0
    var draws = 0
    var playerA: Choice
    for (i in 1..100) {
        playerA = getRandomChoices()
        val result = determineWinner(playerA = playerA)
        when(result) {
            Player.PLAYER_A -> playerAWins++
            Player.PLAYER_B -> playerBWins++
            Player.NONE -> draws++
        }
    }
    println("Player A wins $playerAWins of 100 games")
    println("Player B wins $playerBWins of 100 games")
    println("Draws: $draws of 100 games")
}

fun getRandomChoices(): Choice = when(Random.nextInt(3)){
    0 -> Choice.ROCK
    1 -> Choice.PAPER
    else -> Choice.SCISSOR
}

fun determineWinner(
    playerA: Choice,
    playerB: Choice = Choice.ROCK
): Player = when (playerA) {
    playerB -> Player.NONE
    Choice.ROCK -> when(playerB){
        Choice.PAPER -> Player.PLAYER_B
        Choice.SCISSOR -> Player.PLAYER_A
        else -> Player.NONE
    }
    Choice.SCISSOR -> when(playerB){
        Choice.PAPER -> Player.PLAYER_A
        Choice.ROCK -> Player.PLAYER_B
        else -> Player.NONE
    }
    Choice.PAPER -> when(playerB){
        Choice.SCISSOR -> Player.PLAYER_B
        Choice.ROCK -> Player.PLAYER_A
        else -> Player.NONE
    }
}