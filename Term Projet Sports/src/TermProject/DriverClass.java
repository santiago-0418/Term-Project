/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TermProject;

// IF YOU SEE THIS IT IS THE RIGHT VERSION
import static TermProject.SetUp.first_time;
import java.io.IOException;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import TermProject.UserStorage.*;
import TermProject.Leaderboards.*;

/**
 *
 * @author santiago
 */
public class DriverClass {

    //method for exception handling
    public static int UserInput(int start, int end) {
        Scanner user_input = new Scanner(System.in);

        int input = 0;
        boolean valueFound = true;

        while (valueFound) {
            System.out.print("Selection: ");
            try {
                input = user_input.nextInt();
                if (input < start || input > end) {
                    throw new InputMismatchException();

                } else {
                    return input;
                }

            } catch (InputMismatchException e) {
                System.out.println("Incorrect input, please try again and enter one of the specified digits");
                user_input.nextLine();

            }
        }
        return input;
    }

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

        //Verifying if folder exists or if first time usage
        String home = System.getProperty("user.home");
        Path path = Path.of(home + "/desktop/SportsPlatform");
        if (Files.exists(path) != true) {
            first_time();
        }

        //Initialize Admin Password Storage (will later read from file or sql database)
        AdminStorage admin_storage = new AdminStorage();
        admin_storage.init_admin_storage();
        System.out.println();
        UserStorage user_storage = new UserStorage();
        user_storage.init_user_storage();

        //Creating List of administrators (will later read from file or sql database)
        //Temporary Admin added for testing purposes
        admin_storage.set_up("test", "123", "123");

        //Main window loop
        //Displays the main menu
        do {
            System.out.printf("%s\n%50s\n%s\n%s%28s\n%46s\n%50s\n%54s\n%48s\n%46s\n%32s\n", "--------------------------------------------------------------", "Welcome to THE sports timing platform", "--------------------------------------------------------------",
                    "Please make a selection:", "1) Login for administrators", "2) login for athletes", "3) Go to the leaderboards", "4) Search and athlete by name", "5) Athlete Registration", "6) Admin Registration", "7) Exit");

            //selection = user_input.nextInt();
            //user_input.nextLine();
            selection = UserInput(1, 7);
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

                        // System.out.print("Here are the Athletes to verify: ");
                        List<Athletes> temp_list = user_storage.getAthletes();
                        System.out.println("\nWhich Athlete do you want to modify? ");
                        int count = 1;
                        int selection2;
                        for (Athletes athlete : temp_list) {
                            System.out.println(count + ") " + athlete.firstName);
                            count++;
                        }
                        //System.out.print("selection: ");
                        //selection2 = user_input.nextInt();
                        selection2 = UserInput(1,count);

                        if (temp_list.get(selection2 - 1).getClass() == Swimming.class) {
                            ((Swimming) temp_list.get(selection2 - 1)).ModifyTimes();
                        }
                        if (temp_list.get(selection2 - 1).getClass() == Football.class) {
                            ((Football) temp_list.get(selection2 - 1)).ModifyTimes();
                        }
                        if (temp_list.get(selection2 - 1).getClass() == Track.class) {
                            ((Track) temp_list.get(selection2 - 1)).ModifyTimes();
                        }

                        //System.out.println("Loging in is working!");
                        //is_finished = true;
                        break;
                    } else {
                        System.out.println("Wrong password or Username");
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
                        //System.out.println("Loging in is working!");
                    } else {
                        System.out.println("Wrong password or Username");
                        break;
                    }
                    //temp end
                    //is_finished = true;
                    break;
                case 3:
                    System.out.println("--------------------------------------------------------------");
                    System.out.printf("%s\n%-15s\n%-15s\n%-15s\n", "Choose from the following sports:", "1) Football", "2) Swimming", "3) Track");
                    //int choice1 = user_input.nextInt();
                    int choice1 = UserInput(1,3);
                    switch (choice1) {
                        case 1:
                            System.out.printf("%s\n%-15s\n%-15s\n%-15s\n", "Which Test do you want to see", "1) 40 yard dash", "2) T-Test", "3) L-Test");
                            //int choice2 = user_input.nextInt();
                            int choice2 = UserInput(1,3);
                            switch (choice2) {
                                case 1:
                                    Leaderboards.PrintFootballForty(user_storage.athletes);
                                    break;
                                case 2:
                                    Leaderboards.PrintFootballT_Test(user_storage.athletes);
                                    break;
                                case 3:
                                    Leaderboards.PrintFootballL_Test(user_storage.athletes);
                                    break;
                            }

                            break;
                        case 2:
                            System.out.printf("%s%-15s\n%-15s\n%-15s\n", "Which Time do you want to see", "1) 400 IM", "2) 100 Free", "3) 100 Butterfly");
                            //int choice3 = user_input.nextInt();
                            int choice3 = UserInput(1,3);
                            switch (choice3) {
                                case 1:
                                    Leaderboards.PrintSwimmingFourHundredIM(user_storage.athletes);
                                    break;
                                case 2:
                                    Leaderboards.PrintSwimmingHundredFree(user_storage.athletes);
                                    break;
                                case 3:
                                    Leaderboards.PrintSwimmingHundredButterfly(user_storage.athletes);
                                    break;

                            }

                            break;
                        case 3:
                            System.out.printf("%s%-15s\n%-15s\n%-15s\n", "Which Time do you want to see", "1) 100 meters", "2) 200 meters", "3) 400 meters");
                            //int choice4 = user_input.nextInt();
                            int choice4 = UserInput(1,3);
                            switch (choice4) {
                                case 1:
                                    Leaderboards.PrintTrack100(user_storage.athletes);
                                    break;
                                case 2:
                                    Leaderboards.PrintTrack200(user_storage.athletes);
                                    break;
                                case 3:
                                    Leaderboards.PrintTrack400(user_storage.athletes);
                                    break;

                            }

                            break;

                    }
                    //temp end

                    break;
                case 4:
                    System.out.println("--------------------------------------------------------------");
                    System.out.print("Enter the athletes last name: ");
                    athlete_name = user_input.nextLine();
                    user_storage.Search(athlete_name);
                    //is_finished = true;
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
                    System.out.println("No selection was made, please select one of the 7 options");
            }

        } while (is_finished != true);

    }

}
