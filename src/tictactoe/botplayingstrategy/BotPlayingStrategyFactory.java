package tictactoe.botplayingstrategy;

import tictactoe.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        return new EasyBotPlayingStrategy();
    }
}
