package com.gameoflife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        getUserInput();

    }


    public static void getUserInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Board Dimensions in x,y format");
        String dimension = null;
        try {
            dimension = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int length = Integer.parseInt(dimension.split(",")[0]);
        int breath = Integer.parseInt(dimension.split(",")[1]);
        Board board = new Board(length, breath);
        boolean userWantsToInput = true;
        while (userWantsToInput) {
            try {
                System.out.println("Enter Co-ordinates of Cell you want make it alive  in x,y format ");
                String cooridnate = br.readLine();
                int x = Integer.parseInt(cooridnate.split(",")[0]);
                int y = Integer.parseInt(cooridnate.split(",")[1]);
                board.makeAlive(x, y);
            } catch (Exception e) {
                userWantsToInput = false;
            }
        }
        board.printBoard();
    }


}
