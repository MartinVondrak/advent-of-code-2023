package cz.martinvondrak.adventofcode2023.day1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculateCalibrationNumberTest {
    @Test
    fun `Example data should produce 142`() {
        val result = calculateCalibrationNumber("src/test/resources/day1/input1.txt")
        assertEquals(142, result)
    }
}
