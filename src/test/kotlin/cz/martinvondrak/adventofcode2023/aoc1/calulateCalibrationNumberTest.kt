package cz.martinvondrak.adventofcode2023.aoc1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculateCalibrationNumberTest {
    @Test
    fun `Example data should produce 142`() {
        val result = calculateCalibrationNumber("src/test/resources/aoc1/input.txt")
        assertEquals(142, result)
    }
}
