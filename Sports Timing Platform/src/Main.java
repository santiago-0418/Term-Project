/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.io.Console;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author 2257853
 */
class FinalProjectPOC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initializing necesseary components
        Scanner user_input = new Scanner(System.in);
        int selection;
        boolean is_finished = false;
        String username;
        String password;
        String athlete_name;
        //Main window loop
        //Displays the main menu
        do{
            System.out.printf("%s\n%50s\n%s\n%s%28s\n%50s\n%54s\n%32s\n%s","--------------------------------------------------------------","Welcome to THE sports timing platform","--------------------------------------------------------------"
                    , "Please make a selection:", "1) Login for administrators", "2) Go to the leaderboards", "3) Search and athlete by name", "4) Exit", "Selection: ");
            selection = user_input.nextInt();
            user_input.nextLine();
            //Main switch statement
            switch(selection){
                case 1:
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Enter your Username: ");
                    username = user_input.nextLine();
                    System.out.println("Enter your Password: ");
                    password = user_input.nextLine();
                    //temp end
                    is_finished = true;
                    break;
                case 2:
                    System.out.println("--------------------------------------------------------------");
                    System.out.printf("%s%15s\n%50s\n%50s\n%50s\n","Choose from the following sports:","1) idk man","2) idk man 2", "3) idk man 3", "4) idk man 4", "5) idk man 5");
                    //temp end
                    is_finished = true;
                    break;
                case 3:
                    clearScreen();
                    System.out.println("--------------------------------------------------------------");
                    System.out.print("Enter the athletes last name: ");
                    athlete_name = user_input.nextLine();
                    is_finished = true;
                    break;
                case 4:
                    is_finished = true;
                    break;
                default:
                    System.out.println("No selection was made, please select one of the 4 options");

            }


        }while(is_finished != true);

    }

    public static void clearScreen(){
        try{
            Runtime.getRuntime().exec("clear");
            System.out.flush();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
