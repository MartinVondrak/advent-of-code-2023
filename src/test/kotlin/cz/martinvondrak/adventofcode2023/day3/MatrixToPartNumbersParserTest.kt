package cz.martinvondrak.adventofcode2023.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MatrixToPartNumbersParserTest {
    @Test
    fun `Example data parsing`() {
        val matrix = listOf(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598.."
        )
        val result = MatrixToPartNumbersParser(matrix).parse()
        assertEquals(8, result.size)
        assertEquals(467, result[0])
        assertEquals(35, result[1])
        assertEquals(633, result[2])
        assertEquals(617, result[3])
        assertEquals(592, result[4])
        assertEquals(755, result[5])
        assertEquals(664, result[6])
        assertEquals(598, result[7])
    }

    @Test
    fun `Custom data parsing`() {
        val matrix = listOf(
            "-180.......27.25%.........230@",
            "..............................",
            "/415.....%..730.5*330.....+238",
            "..............................",
            "...47....................752..",
            "..*......*520..../............",
            "964#..........166...........-3"
        )
        val result = MatrixToPartNumbersParser(matrix).parse()
        assertEquals(12, result.size)
        assertEquals(180, result[0])
        assertEquals(25, result[1])
        assertEquals(230, result[2])
        assertEquals(415, result[3])
        assertEquals(5, result[4])
        assertEquals(330, result[5])
        assertEquals(238, result[6])
        assertEquals(47, result[7])
        assertEquals(520, result[8])
        assertEquals(964, result[9])
        assertEquals(166, result[10])
        assertEquals(3, result[11])
    }

    @Test
    fun `Test corners`() {
        val matrix = listOf(
            "180.......27.25%...........230",
            "...?......................:...",
            "/........%......5*........+...",
            "..............................",
            ".........................752..",
            "...*520..../................-.",
            "964...........166............3"
        )
        val result = MatrixToPartNumbersParser(matrix).parse()
        assertEquals(8, result.size)
        assertEquals(180, result[0])
        assertEquals(25, result[1])
        assertEquals(230, result[2])
        assertEquals(5, result[3])
        assertEquals(752, result[4])
        assertEquals(520, result[5])
        assertEquals(964, result[6])
        assertEquals(3, result[7])
    }
}