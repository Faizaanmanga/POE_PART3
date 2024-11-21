package poepart3faizaanmanga.AccessFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import poepart3faizaanmanga.Models.User;

public class RegistrationFeature {

    private Scanner input;
    List<User> users = new ArrayList<>();
    public RegistrationFeature(Scanner input, List<User> users) {
        this.input = input;
        this.users = users;
    }

    public void run() {
        boolean check = true;
        String name = "";
        String surname = "";
        String username = "";

        while (check) {
            System.out.print("Enter your name: ");
            name = input.nextLine();

            System.out.print("Enter your surname: ");
            surname = input.nextLine();

            System.out.print("Create a username (your username must be no more than 5 characters long and must contain an _): ");
            username = input.nextLine();

            System.out.print("Create a password (password must contain a special character, a capital letter, a number and must be 8 characters long): ");
            String password = input.nextLine();

            if (!checkUserName(username)) {
                System.out.println("\nUsername is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            } else if (!checkPasswordComplexity(password)) {
                System.out.println("\nPassword is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            } else {
                users.add(new User(name, surname, username, password));
                System.out.println("\nLogin successful! Welcome, " + name + " " + surname + "!");
                check = false;
            }
        }

        System.out.println("\nUser Information:");
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Username successfully captured: " + username);
        System.out.println("Password successfully captured");
    }

    public static boolean checkUserName(String username) {
        if (username.length() > 5) {
            System.out.println("Username must be at most 5 characters long.");
            return false;
        }

        if (!username.contains("_")) {
            System.out.println("Username needs to contain an '_'");
            return false;
        }
        return true;
    }

    public static boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        if (!password.matches(".*\\d.*")) {
            System.out.println("Password must contain at least one digit (number).");
            return false;
        }

        if (!password.matches(".*[@_<>].*")) {
            System.out.println("Password must contain at least one special character.");
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            System.out.println("Password must contain at least one uppercase letter.");
            return false;
        }
        return true;
    }

    public static void run2() {
        Scanner input2 = new Scanner(System.in);
        boolean check = true;
        while (check) {
            String correctUsername = "fizz_";
            String correctPassword = "1234@RCO";

            System.out.println("Welcome to the Login feature");
            System.out.print("Enter your name: ");
            String name = input2.nextLine();

            System.out.print("Enter your surname: ");
            String surname = input2.nextLine();

            System.out.print("Enter your username: ");
            String username = input2.nextLine();

            System.out.print("Enter your password: ");
            String password = input2.nextLine();

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Welcome, " + name + " " + surname + ", it's great to see you again!");
                check = false;
            } else {
                System.out.println("Username or password incorrect. Please try again.");
            }
        }

        input2.close();
    }
}
