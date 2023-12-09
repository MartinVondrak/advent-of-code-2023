package cz.martinvondrak.adventofcode2023.day4

import java.io.FileReader
import kotlin.math.pow


class Lottery(
    private val filePath: String
) {
    private val cards: List<ScratchCard> = mutableListOf()

    fun calculateWinningPoints(): Int {
        loadCards()

        return cards.map { card ->
            var matches = 0
            card.winningNumbers.forEach { winningNumber ->
                card.scratchNumbers.forEach { scratchNumber ->
                    if (winningNumber == scratchNumber) {
                        matches++
                    }
                }
            }
            matches
        }.map { matches ->
            when (matches) {
                0 -> 0.0
                else -> 2.0.pow(matches - 1)
            }
        }.sumOf { it.toInt() }
    }

    private fun loadCards() {
        FileReader(filePath).useLines { lines ->
            lines.forEach {
                val card = parseLineToCard(it)
                cards.addLast(card)
            }
        }
    }

    private fun parseLineToCard(line: String): ScratchCard {
        val matches = CARD_LINE_REGEX.matchEntire(line)
        val card = ScratchCard(matches!!.groupValues[1].toInt())

        matches.groupValues[2].split(SPLIT_REGEX).forEach { winningNumber ->
            card.winningNumbers.addLast(winningNumber.toInt())
        }

        matches.groupValues[3].split(SPLIT_REGEX).forEach { scratchNumber ->
            card.scratchNumbers.addLast(scratchNumber.toInt())
        }

        return card
    }

    companion object {
        private val CARD_LINE_REGEX = Regex("Card\\s+(\\d+):\\s+(\\d+(?:\\s+\\d+)*)\\s+\\|\\s+(\\d+(?:\\s+\\d+)*)\\s?")
        private val SPLIT_REGEX = Regex("\\s+")
    }
}