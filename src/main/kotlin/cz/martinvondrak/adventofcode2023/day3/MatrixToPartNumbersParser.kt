package cz.martinvondrak.adventofcode2023.day3

class MatrixToPartNumbersParser(private val matrix: List<String>) {
    private var parsingPartNumber = false
    private var partNumberBuilder = StringBuilder()
    private var isPartNumberValid = false

    fun parse(): List<Int> {
        val partNumbers: List<Int> = mutableListOf()

        for (i in matrix.indices) {
            setNonParsingState()

            for (j in 0 until matrix[i].length) {
                if (isPositionDigit(i, j)) {
                    parsingPartNumber = true
                    partNumberBuilder.append(matrix[i][j])

                    if (!isPartNumberValid && hasPositionAdjacentCharacter(i, j)) {
                        isPartNumberValid = true
                    }
                }

                if (isPositionNonDigitButParsingInProgress(i, j) || isLastPositionInRow(i, j)) {
                    if (isPartNumberValid) {
                        partNumbers.addLast(partNumberBuilder.toString().toInt())
                    }

                    setNonParsingState()
                }
            }
        }

        return partNumbers
    }

    private fun hasPositionAdjacentCharacter(i: Int, j: Int): Boolean {
        return when {
            // first row
            i == 0 -> {
                when (j) {
                    // first column
                    0 -> {
                        isPositionNotDigitOrDot(i, j + 1) ||
                                isPositionNotDigitOrDot(i + 1, j + 1) ||
                                isPositionNotDigitOrDot(i + 1, j)
                    }
                    // last column
                    matrix[i].length - 1 -> {
                        isPositionNotDigitOrDot(i, j - 1) ||
                                isPositionNotDigitOrDot(i + 1, j - 1) ||
                                isPositionNotDigitOrDot(i + 1, j)

                    }
                    // j > 0 && j < matrix[i].length - 1
                    else -> {
                        isPositionNotDigitOrDot(i, j - 1) ||
                                isPositionNotDigitOrDot(i, j + 1) ||
                                isPositionNotDigitOrDot(i + 1, j - 1) ||
                                isPositionNotDigitOrDot(i + 1, j + 1) ||
                                isPositionNotDigitOrDot(i + 1, j)
                    }
                }
            }
            // last row
            i == matrix.size - 1 -> {
                when (j) {
                    // first column
                    0 -> {
                        isPositionNotDigitOrDot(i - 1, j) ||
                                isPositionNotDigitOrDot(i - 1, j + 1) ||
                                isPositionNotDigitOrDot(i, j + 1)
                    }
                    // last column
                    matrix[i].length - 1 -> {
                        isPositionNotDigitOrDot(i - 1, j) ||
                                isPositionNotDigitOrDot(i - 1, j - 1) ||
                                isPositionNotDigitOrDot(i, j - 1)
                    }
                    // j > 0 && j < matrix[i].length - 1
                    else -> {

                        isPositionNotDigitOrDot(i, j - 1) ||
                                isPositionNotDigitOrDot(i, j + 1) ||
                                isPositionNotDigitOrDot(i - 1, j - 1) ||
                                isPositionNotDigitOrDot(i - 1, j + 1) ||
                                isPositionNotDigitOrDot(i - 1, j)

                    }
                }
            }
            // first column
            j == 0 -> {
                isPositionNotDigitOrDot(i - 1, j) ||
                        isPositionNotDigitOrDot(i - 1, j + 1) ||
                        isPositionNotDigitOrDot(i, j + 1) ||
                        isPositionNotDigitOrDot(i + 1, j + 1) ||
                        isPositionNotDigitOrDot(i + 1, j)
            }
            // last column
            j == matrix[i].length - 1 -> {
                isPositionNotDigitOrDot(i - 1, j) ||
                        isPositionNotDigitOrDot(i - 1, j - 1) ||
                        isPositionNotDigitOrDot(i, j - 1) ||
                        isPositionNotDigitOrDot(i + 1, j - 1) ||
                        isPositionNotDigitOrDot(i + 1, j)
            }
            // i > 0 && i < matrix.size - 1 && j > 0 && j < matrix[i].length - 1
            else -> {
                isPositionNotDigitOrDot(i - 1, j - 1) ||
                        isPositionNotDigitOrDot(i - 1, j) ||
                        isPositionNotDigitOrDot(i - 1, j + 1) ||
                        isPositionNotDigitOrDot(i, j - 1) ||
                        isPositionNotDigitOrDot(i, j + 1) ||
                        isPositionNotDigitOrDot(i + 1, j - 1) ||
                        isPositionNotDigitOrDot(i + 1, j) ||
                        isPositionNotDigitOrDot(i + 1, j + 1)
            }
        }
    }

    private fun isPositionNotDigitOrDot(i: Int, j: Int): Boolean {
        return isPositionNotDigit(i, j) && matrix[i][j] != '.'
    }

    private fun isPositionNonDigitButParsingInProgress(i: Int, j: Int): Boolean {
        return parsingPartNumber && isPositionNotDigit(i, j)
    }

    private fun isPositionDigit(i: Int, j: Int): Boolean {
        return matrix[i][j].isDigit()
    }

    private fun isPositionNotDigit(i: Int, j: Int): Boolean {
        return !isPositionDigit(i, j)
    }

    private fun isLastPositionInRow(i: Int, j: Int): Boolean {
        return j == matrix[i].length - 1
    }

    private fun setNonParsingState() {
        parsingPartNumber = false
        partNumberBuilder.clear()
        isPartNumberValid = false
    }
}