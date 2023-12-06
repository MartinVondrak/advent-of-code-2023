package cz.martinvondrak.adventofcode2023.aoc2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CubeGambleTest {
    @Test
    fun `Example data should produce 8`() {
        val gameGamble = CubeGamble("src/test/resources/aoc21/input.txt")
        gameGamble.loadGames()
        val result = gameGamble.calculateSumOfValidGames()
        assertEquals(8, result)
    }
}