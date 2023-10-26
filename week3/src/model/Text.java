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
        out.println("1.List students.");
        out.println("2.List subject.");
        out.println("3.Subject registration.");
        out.println("4.Search Subject transcripts of students.");
        out.println("Number other == Exit");
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
            case 5 -> {
                return 5;
            }
            default -> {
                return 0;
            }
        }
    }

    public static int teacherFunction() {
        out.println("Please choice function:");
        out.println("1.List Teachers.");
        out.println("2.Students transcripts.");
        out.println("3.Register to teach subject.");
        out.println("4.Grading student's subjects.");
        out.println("5.Search for subjects that teachers have registered to teach.");
        out.println("Number other == Exit");
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
            case 5 -> {
                return 5;
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
    public static Double checkInputDouble() {
        Double number = 0d;
        while (!input.hasNextDouble()) {
            out.println("That's not a double or integer number!");
            input.next();
        }
        return number = input.nextDouble();
    }
}
