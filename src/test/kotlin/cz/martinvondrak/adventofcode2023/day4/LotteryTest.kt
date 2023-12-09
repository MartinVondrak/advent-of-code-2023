package cz.martinvondrak.adventofcode2023.day4

import kotlin.test.Test
import kotlin.test.assertEquals

class LotteryTest {
    @Test
    fun `Task 4_1 example data should produce 13`() {
        val result = Lottery("src/test/resources/day4/input.txt").calculateWinningPoints()
        assertEquals(13, result)
    }
}