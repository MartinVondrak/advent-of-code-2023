package cz.martinvondrak.adventofcode2023.aoc1

import java.io.FileReader

fun calculateCalibrationNumber(filePath: String): Int {
    FileReader(filePath).useLines { lines ->
        return lines.map {
            val firstDigit = it.first { c -> c.isDigit() }
            val lastDigit = it.last { c -> c.isDigit() }
            "$firstDigit$lastDigit".toInt()
        }.sum()
    }
}

fun calculateCalibrationNumberWithSpelledDigits(filePath: String): Int {
    TODO()
}