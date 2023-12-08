package cz.martinvondrak.adventofcode2023.aoc2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CubeGambleTest {
    @Test
    fun `Task 2_1 example data should produce 8`() {
        val result = CubeGamble("src/test/resources/aoc2/input.txt").calculateSumOfValidGames()
        assertEquals(8, result)
    }

    @Test
    fun `Task 2_2 example data should produce 2286`() {
        val result = CubeGamble("src/test/resources/aoc2/input.txt").calculateSumOfPowerOfGames()
        assertEquals(2286, result)
    }
}