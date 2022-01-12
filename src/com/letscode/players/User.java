package com.letscode.players;

import java.util.Random;
import java.util.Scanner;

public class User {

    public static int[] getCoordinates() {
        int min = 0;
        int max = 10;
        int row;
        int col;
        Random random = new Random();
        row = random.nextInt(max + min) + min;
        col = random.nextInt(max + min) + min;
        return new int[]{row, col};
    }

    public static char getTarget(int[] guess, char[][] gameBoard2, char ship, char water, char hit, char miss) {
        int row = guess[0];
        int col = guess[1];
        char target = gameBoard2[row][col];
        if (target == ship) {
            target = hit;
        } else if (target == water) {
            target = miss;
        }
        return target;
    }

    public static int[] generateShipCoordinates(int gameBoardLength) {
        Scanner scan = new Scanner(System.in);
        int[] coordinates = new int[2];
        for (int i = 0; i < coordinates.length; i++) {
            if (i % 2 == 0) {
                System.out.print("linha: ");
            } else {
                System.out.print("Coluna: ");
            }
            coordinates[i] = scan.nextInt(gameBoardLength) - 1;
        }
        return coordinates;
    }
}