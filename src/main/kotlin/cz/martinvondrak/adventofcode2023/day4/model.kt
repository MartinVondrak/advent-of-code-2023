package cz.martinvondrak.adventofcode2023.day4

class ScratchCard(
    val id: Int,
) {
    val winningNumbers: List<Int> = mutableListOf()
    val scratchNumbers: List<Int> = mutableListOf()

    fun getMatches(): Int {
        var matches = 0
        winningNumbers.forEach { winningNumber ->
            scratchNumbers.forEach { scratchNumber ->
                if (winningNumber == scratchNumber) {
                    matches++
                }
            }
        }
        return matches
    }
}