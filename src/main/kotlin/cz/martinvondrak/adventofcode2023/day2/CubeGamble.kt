package cz.martinvondrak.adventofcode2023.day2

import java.io.FileReader

class CubeGamble(
    private val filePath: String
) {
    private val games: List<Game> = mutableListOf()

    fun calculateSumOfValidGames(): Int {
        loadGames()

        return games.filter {
            it.isValid()
        }.sumOf {
            it.id
        }
    }

    fun calculateSumOfPowerOfGames(): Int {
        loadGames()

        return games.map { game ->
            var minRed = 0
            var minGreen = 0
            var minBlue = 0

            game.moves.forEach { move ->
                minRed = if (minRed < move.redCount) move.redCount else minRed
                minGreen = if (minGreen < move.greenCount) move.greenCount else minGreen
                minBlue = if (minBlue < move.blueCount) move.blueCount else minBlue
            }

            minRed * minGreen * minBlue
        }.sumOf { it }

    }

    private fun loadGames() {
        FileReader(filePath).useLines { lines ->
            lines.forEach {
                val game = parseLineToGame(it)
                games.addLast(game)
            }
        }
    }

    private fun parseLineToGame(line: String): Game {
        val gameText = line.replace(" ", "").split(":")
        val game = Game(gameText[0].removePrefix("Game").toInt())
        gameText[1].split(";").forEach { moveText ->
            val colorsText = moveText.split(",")
            var redCount = 0
            var greenCount = 0
            var blueCount = 0

            for (colorText in colorsText) {
                when {
                    colorText.endsWith("red") -> redCount = colorText.removeSuffix("red").toInt()
                    colorText.endsWith("green") -> greenCount = colorText.removeSuffix("green").toInt()
                    colorText.endsWith("blue") -> blueCount = colorText.removeSuffix("blue").toInt()
                }
            }

            game.moves.addLast(Move(redCount, greenCount, blueCount))
        }

        return game
    }


}