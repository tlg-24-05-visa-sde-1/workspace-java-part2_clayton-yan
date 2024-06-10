package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Scanner;
import static com.duckrace.Reward.*;

public class DuckRaceApp {
    // Controller, directs flow of app, prompts user for inputs then passes those into system

    private final Board board = new Board();
    private final Scanner scanner = new Scanner(System.in);

    public void execute() {
        //
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        updateBoard(id, reward);
        showBoard();

    }

    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private Reward promptForReward() {
        Reward reward = null;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("D|P")) {
                validInput = true;
                reward = (input.equals("D")) ? DEBIT_CARD : PRIZES; // ternary op
            }
        }
        return reward;
    }

    private int promptForId() {
        int id = 0;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter ID of the winner [1-16]: ");
            String input = scanner.nextLine().trim(); // BLOCKS for input i.e., the enter key
            if (input.matches("\\d{1,2}")) { // any digit, one or two times
                id = Integer.parseInt(input); // safe (no exception)
                if (id >= 1 && id <= 16) {
                    validInput = true;
                }

            }
        }
        return id;
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("------- -- --- ---- ---- -----------");
        System.out.println("WELCOME TO THE DUCK RACE APPLICATION");
        System.out.println("------- -- --- ---- ---- -----------");
        System.out.println("\n");
    }
}
