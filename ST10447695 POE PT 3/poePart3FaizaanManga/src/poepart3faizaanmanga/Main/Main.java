package poepart3faizaanmanga.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import poepart3faizaanmanga.AccessFeature.LoginFeature;
import poepart3faizaanmanga.AccessFeature.RegistrationFeature;
import poepart3faizaanmanga.Models.User;
import poepart3faizaanmanga.TaskFeature.TaskManager;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<User> users = new ArrayList<>();

        LoginFeature login = new LoginFeature(input, users);
        RegistrationFeature register = new RegistrationFeature(input, users);
        TaskManager taskManager = new TaskManager(input);

        while (true) {
            System.out.println("""
                               Welcome to the system.
                               Please enter:
                               1. for registration
                               2. for login
                               0. to exit""");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> register.run();
                case 2 -> {
                    login.run();
                            
                    if (login.getCurrentUser() != null) { 
                        taskManager.setCurrentUser(login.getCurrentUser());
                        taskManager.taskManagementMenu();
                    }
                }
                case 0 -> System.exit(0);
                default -> System.out.println("Please enter a valid choice.");
            }
        }
    }
}
