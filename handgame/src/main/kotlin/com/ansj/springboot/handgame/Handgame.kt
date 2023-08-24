package com.ansj.springboot.handgame

import java.util.Random

class Handgame {
    fun play(player: GameCommand): Pair<GameResult, GameCommand> {
        val opponent = GameCommand.values()[Random().nextInt(3)]
        return if (player == opponent) {
            Pair(GameResult.동점, player)
        } else if (player == GameCommand.바위 && opponent == GameCommand.가위) {
            Pair(GameResult.승리, GameCommand.가위)
        } else if (player == GameCommand.가위 && opponent == GameCommand.보) {
            Pair(GameResult.승리, GameCommand.보)
        } else if (player == GameCommand.보 && opponent == GameCommand.바위) {
            Pair(GameResult.승리, GameCommand.바위)
        } else Pair(GameResult.패배, opponent)
    }
}

enum class GameCommand(num: Int) {
    바위(0), 가위(1), 보(2)
}

enum class GameResult{
    동점, 승리, 패배
}