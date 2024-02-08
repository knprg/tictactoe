package tictactoe.controller;

import tictactoe.exception.DuplicateSymbolEception;
import tictactoe.exception.MoreThanOneBotException;
import tictactoe.exception.PlayersCountMismatchException;
import tictactoe.models.Game;
import tictactoe.models.Player;
import tictactoe.strategies.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> playerList, List<WinningStrategy> winningStrategies) throws DuplicateSymbolEception, PlayersCountMismatchException, MoreThanOneBotException {
         return Game.getBuilder().setDimension(dimension).setPlayers(playerList).setWinningStrategies(winningStrategies).build();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void undo(Game game){
        game.undo();
    }
}
