package cz.martinvondrak.adventofcode2023.aoc2

class Game(val id: Int) {
    val moves: List<Move> = mutableListOf()

    fun isValid(): Boolean {
        return moves.all { move ->
            move.redCount <= MAX_RED_CUBE_COUNT &&
                    move.greenCount <= MAX_GREEN_CUBE_COUNT &&
                    move.blueCount <= MAX_BLUE_CUBE_COUNT
        }
    }

    companion object {
        private const val MAX_RED_CUBE_COUNT = 12
        private const val MAX_GREEN_CUBE_COUNT = 13
        private const val MAX_BLUE_CUBE_COUNT = 14
    }
}

class Move(
    val redCount: Int,
    val greenCount: Int,
    val blueCount: Int
)
