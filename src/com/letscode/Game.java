package com.letscode;

import com.letscode.boards.ComputerBoard;
import com.letscode.boards.UserBoard;
import com.letscode.players.Computer;
import com.letscode.players.User;


public class Game {
    public static void main(String[] args) {
        int gameBoardLength = 10;
        char water = '-';
        char ship = 'N';
        char hit = '*';
        char miss = 'O';
        int shipNumber = 3;

        char[][] computerGameBoard = ComputerBoard.createGameBoard(gameBoardLength, water, ship, shipNumber);
        char[][] userGameBoard = UserBoard.createGameBoard
                (gameBoardLength, water, ship, shipNumber);

        ComputerBoard.printGameBoard(computerGameBoard, water, ship);
        UserBoard.printGameBoard(userGameBoard, water, ship);

        int computerShipNumber = shipNumber;
        int userShipNumber = shipNumber;
        while (computerShipNumber > 0 && userShipNumber > 0) {
            int[] guessComputerCoordinates = Computer.getCoordinates(gameBoardLength);
            int[] guessUserCoordinates = User.getCoordinates();

            char computerViewUpdate = Computer.getTarget
                    (guessComputerCoordinates, computerGameBoard, ship, water, hit, miss);
            char userViewUpdate = User.getTarget(guessUserCoordinates, userGameBoard, ship, water, hit, miss);

            if (computerViewUpdate == hit) {
                computerShipNumber--;
            }
            if (userViewUpdate == hit) {
                userShipNumber--;
            }

            computerGameBoard = ComputerBoard.updateGameBoard
                    (computerGameBoard, guessComputerCoordinates, computerViewUpdate);
            ComputerBoard.printGameBoard(computerGameBoard, water, ship);

            userGameBoard = UserBoard.updateGameBoard
                    (userGameBoard, guessUserCoordinates, userViewUpdate);
            UserBoard.printGameBoard(userGameBoard, water, ship);

        }


    }
}
