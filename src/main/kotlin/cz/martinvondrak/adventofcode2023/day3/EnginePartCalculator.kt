package cz.martinvondrak.adventofcode2023.day3

import java.io.FileReader

class EnginePartCalculator(
    private val filePath: String
) {
    private val matrix: List<String> = mutableListOf()

    fun calculateSumOfEnginePartNumbers(): Int {
        loadMatrix()
        return MatrixToPartNumbersParser(matrix).parse().sumOf { it }
    }

    fun calculateSumOfGearRatios(): Int {
        loadMatrix()
        TODO()
    }

    private fun loadMatrix() {
        FileReader(filePath).useLines { lines ->
            lines.forEach {
                matrix.addLast(it)
            }
        }
    }
}