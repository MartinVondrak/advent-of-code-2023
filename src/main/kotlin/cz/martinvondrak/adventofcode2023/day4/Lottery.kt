package cz.martinvondrak.adventofcode2023.day4

import java.io.FileReader
import kotlin.math.pow


class Lottery(
    private val filePath: String
) {
    private val cards: List<ScratchCard> = mutableListOf()

    fun calculateWinningPoints(): Int {
        loadCards()

        return cards.map {
            it.getMatches()
        }.map { matches ->
            when (matches) {
                0 -> 0.0
                else -> 2.0.pow(matches - 1)
            }
        }.sumOf { it.toInt() }
    }

    fun calculateTotalScratchCardsCount(): Int {
        loadCards()
        val map: Map<Int, Int> = mutableMapOf()

        cards.reversed().forEach { card ->
            val cardId = card.id

            if (card.getMatches() == 0) {
                map[cardId] = 1
            } else {
                var count = 0
                card.winningNumbers.forEach { winningNumber ->
                    cards.reversed().forEach { otherCard ->
                        if (otherCard.id != cardId && otherCard.scratchNumbers.contains(winningNumber)) {
                            count += map[otherCard.id]!!
                        }
                    }
                }
                map[cardId] = count
            }
        }

        return cards.size
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