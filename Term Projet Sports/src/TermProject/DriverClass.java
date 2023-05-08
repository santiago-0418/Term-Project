/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TermProject;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author santiago
 */
public class DriverClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //Initial Stuff
        Scanner user_input = new Scanner(System.in);
        int selection;
        boolean is_finished = false;
        String username;
        String password;
        String athlete_name;

        //Initialize Admin Password Storage (will later read from file or sql database)
        AdminStorage admin_storage = new AdminStorage();
        admin_storage.init_admin_storage();
        UserStorage user_storage = new UserStorage();
        user_storage.init_user_storage();

        //Creating List of administrators (will later read from file or sql database)
        //Temporary Admin added for testing purposes
        admin_storage.set_up("test", "123", "123");

        //Main window loop
        //Displays the main menu
        do {
            System.out.printf("%s\n%50s\n%s\n%s%28s\n%46s\n%50s\n%54s\n%48s\n%46s\n%32s\n%s", "--------------------------------------------------------------", "Welcome to THE sports timing platform", "--------------------------------------------------------------",
                     "Please make a selection:", "1) Login for administrators", "2) login for athletes", "3) Go to the leaderboards", "4) Search and athlete by name", "5) Athlete Registration", "6) Admin Registration", "7) Exit", "Selection: ");
            selection = user_input.nextInt();
            user_input.nextLine();
            //Main switch statement
            switch (selection) {
                case 1:
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Enter your Username: ");
                    username = user_input.nextLine();
                    System.out.println("Enter your Password: ");
                    password = user_input.nextLine();
                    //Calling UserStorage
                    if (admin_storage.login(username, password)) {
                        System.out.println("Loging in is working!");
                        is_finished = true;
                        break;
                    } else {
                        System.out.println("Something broke or wrong password");
                        break;
                    }

                //temp end
//                    is_finished = true;
//                    break;
                case 2:
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Enter your Username: ");
                    username = user_input.nextLine();
                    System.out.println("Enter your Password: ");
                    password = user_input.nextLine();
                    //Calling UserStorage
                    if (user_storage.login(username, password)) {
                        System.out.println("Loging in is working!");
                    } else {
                        System.out.println("Something broke or wrong password");
                        break;
                    }
                    //temp end
                    is_finished = true;
                    break;
                case 3:
                    System.out.println("--------------------------------------------------------------");
                    System.out.printf("%s%15s\n%50s\n%50s\n%50s\n", "Choose from the following sports:", "1) Football", "2) Smimming", "3) Track");
                    //temp end
                    is_finished = true;
                    break;
                case 4:
                    System.out.println("--------------------------------------------------------------");
                    System.out.print("Enter the athletes last name: ");
                    athlete_name = user_input.nextLine();
                    is_finished = true;
                    break;

                case 5:
                    String athlete_user_create;
                    String athlete_pass_create;
                    String user_secret_code;
                    String first_name;
                    String last_name;
                    System.out.println("Enter you username: ");
                    athlete_user_create = user_input.nextLine();
                    System.out.println("Enter you password: ");
                    athlete_pass_create = user_input.nextLine();
                    System.out.println("Enter the secret code provided to you: ");
                    user_secret_code = user_input.nextLine();
                    System.out.println("Enter you first name: ");
                    first_name = user_input.nextLine();
                    System.out.println("Enter your last name: ");
                    last_name = user_input.nextLine();
                    //Creating the athlete
                    if (user_storage.set_up(athlete_user_create, athlete_pass_create, user_secret_code, first_name, last_name)) {
                        System.out.println("User Succesfully created");
                    } else {
                        break;
                    }
                    break;
                case 6:
                    String admin_user_create;
                    String admin_pass_create;
                    String admin_secret_code;
                    System.out.println("Enter you username: ");
                    admin_user_create = user_input.nextLine();
                    System.out.println("Enter you password: ");
                    admin_pass_create = user_input.nextLine();
                    System.out.println("Enter the secret code provided to you: ");
                    admin_secret_code = user_input.nextLine();
                    //Creating the admin
                    if (admin_storage.set_up(admin_user_create, admin_pass_create, admin_secret_code)) {
                        System.out.println("Admin Succesfully created");
                    } else {
                        break;
                    }
                    break;
                case 7:
                    is_finished = true;
                    break;
                default:
                    System.out.println("No selection was made, please select one of the 4 options");
            }

        } while (is_finished != true);

    }
}
