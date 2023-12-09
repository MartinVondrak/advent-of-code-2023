package cz.martinvondrak.adventofcode2023.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EnginePartCalculatorTest {
    @Test
    fun `Example data should produce 142`() {
        val result = EnginePartCalculator("src/test/resources/day3/input.txt").calculateSumOfEnginePartNumbers()
        assertEquals(4361, result)
    }
}