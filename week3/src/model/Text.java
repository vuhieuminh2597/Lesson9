package model;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Text {
    private static Scanner input = new Scanner(in);

    public static int choiceUse() {
        out.println("Please choice:");
        out.println("1.You are Student.");
        out.println("2.You are Teacher.");
        out.println("Number other == Exit.");
        int choice = checkInputInt();
        switch (choice) {
            case 1 -> {
                return 1;
            }
            case 2 -> {
                return 2;
            }
            default -> {
                return 0;
            }
        }
    }

    public static int studentFunction() {
        out.println("Please choice function:");
        out.println("1.Personal information.");
        out.println("2.List subject.");
        out.println("3.Subject registration.");
        out.println("4.Subject transcripts.");
        out.println("5.Number other == Exit");
        int choice = checkInputInt();
        switch (choice) {
            case 1 -> {
                return 1;
            }
            case 2 -> {
                return 2;
            }
            case 3 -> {
                return 3;
            }
            case 4 -> {
                return 4;
            }
            default -> {
                return 0;
            }
        }
    }

    public static int checkInputInt() {
        int number = 0;
        while (!input.hasNextInt()) {
            out.println("That's not a integer number!");
            input.next();
        }
        return number = input.nextInt();
    }
}
