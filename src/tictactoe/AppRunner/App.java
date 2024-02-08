package tictactoe.AppRunner;

import tictactoe.controller.GameController;
import tictactoe.exception.DuplicateSymbolEception;
import tictactoe.exception.MoreThanOneBotException;
import tictactoe.exception.PlayersCountMismatchException;
import tictactoe.models.*;
import tictactoe.strategies.ColWinningStrategy;
import tictactoe.strategies.DiagonalWinningStrategy;
import tictactoe.strategies.RowWinningStrategy;
import tictactoe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static <player> void main(String[] args) throws DuplicateSymbolEception, PlayersCountMismatchException, MoreThanOneBotException {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        int dimension=3;
        List<Player> playerList=new ArrayList<>();
        List<WinningStrategy> winningStrategies=new ArrayList<>();
        playerList.add(new Player('X',"Keerthi",1, PlayerType.HUMAN));
        playerList.add(new Bot('O',"GPT",2, PlayerType.BOT,BotDifficultyLevel.EASY));
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());
        Game game=gameController.startGame(dimension,playerList,winningStrategies);
        while (game.getGameState().equals(GameState.IN_PROG)){
            game.printBoard();
            System.out.println("Does anyone want to undo? (y/n)");
            String undo = scanner.next();

            if(undo.equalsIgnoreCase("y")){
                gameController.undo(game);
                continue;
            }



            gameController.makeMove(game);
        }
        // if i am here,it means game is not in progress anymore
        if(GameState.SUCCESS.equals(game.getGameState())){
            System.out.println(game.getWinner().getName()+", Congrats! You won the game :)");
        }
        if(GameState.DRAW.equals(game.getGameState())){
            System.out.println("Match Tied :|");
        }
    }
}
