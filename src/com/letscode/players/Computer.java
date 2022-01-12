package com.letscode.players;

import java.util.Random;
import java.util.Scanner;

public class Computer {

    public static int[] getCoordinates(int gameBoardLength) {
        int row;
        int col;
        do {
            System.out.print("Row: ");
            row = new Scanner(System.in).nextInt();
        } while (row < 0 || row > gameBoardLength + 1);
        do {
            System.out.print("Column: ");
            col = new Scanner(System.in).nextInt();
        } while (col < 0 || col > gameBoardLength + 1);
        return new int[]{row - 1, col - 1};
    }

    public static int[] generateShipCoordinates(int gameBoardLength) {
        int[] coordinates = new int[2];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = new Random().nextInt(gameBoardLength);
        }
        return coordinates;
    }

    public static char getTarget
            (int[] guessCoordinates, char[][] gameBoard, char ship, char water, char hit, char miss) {
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];
        char target = gameBoard[row][col];
        if (target == ship) {
            target = hit;
        } else if (target == water) {
            target = miss;
        }
        return target;
    }
}
