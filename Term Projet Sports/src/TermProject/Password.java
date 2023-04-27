/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TermProject;
import java .util.*;
/**
 *
 * @author 2257853
 */
//interface Storage{
//    
//    public boolean set_up(String user, String pass, String code);
//    public boolean login(String user, String pass);
//    
//}

class AdminStorage{
       
    
    //IDEA: have a secret code that lets people become admin
    private String secret_code = "123";
    //Initializing the HashMap
    private HashMap<String, String> admin_storage = new HashMap<>();
    //Initializing the list of administrators (will later be read from a file)
    List<Administrator> admins = new ArrayList();
    //Setting a new username and password
    public boolean set_up(String user, String pass, String secret_access){
        if(secret_code.equals(secret_access)){
            admin_storage.put(user, pass);
            admins.add(new Administrator(user,pass));
            return true;
        }
        else{
            System.out.println("Wrong Access Code Entered");
            return false;
        }
    }
    //Verifying the password
//    @Override
    public boolean login(String user, String pass){
        if(admin_storage.containsKey(user)){
            if(admin_storage.get(user).equals(pass)){
                System.out.println("Correct Password");
                for(Administrator admin: admins){
                    if(admin.getUser_name().equals(user)){
                        admin.admin_menu();
                        break;
                    }
                }
                return true;
            }
            else
                return false;
        }
        else{
            System.out.println("User Does Not Exist");
            return false;
        }
    }
    
}

class UserStorage{
       
    Scanner user_input = new Scanner(System.in);
    //IDEA: have a secret code that lets people become admin
    private String secret_code = "321";
    //Initilalizing list of Athletes
    List<Athletes> athletes = new ArrayList();
    //Initializing the HashMap
    private HashMap<String, String> user_storage = new HashMap<>();
    
    //Setting a new username and password
    public boolean set_up(String user, String pass, String secret_access, String first_name, String last_name){
        if(secret_code.equals(secret_access)){
            user_storage.put(user, pass);
            boolean selected_sport = false;
            //Selecting the sport
            int sport_selection;
            do{
                System.out.print("Select which sport you want to participate in: ");
                System.out.printf("%s\n%58s\n%55s\n%s","1) Football", "2) Swimming","3) Track","Selection: ");
                sport_selection = user_input.nextInt();
                switch(sport_selection){                
                    case 1:
                        athletes.add(new Football(user,first_name, last_name));
                        selected_sport = true;
                        break;
                    case 2:
                        athletes.add(new Swimming(user,first_name, last_name));
                        selected_sport = true;
                        break;
                    case 3:
                        athletes.add(new Track(user,first_name, last_name));
                        selected_sport = true;
                        break;
                    default:
                        System.out.println("Non valid input, please enter a number from 1 to 3 ");
                        break;
                }
            }while(selected_sport!=true);
            return true;
        }
        else{
            System.out.println("Wrong Access Code Entered");
            return false;
        }
    }
    
    //Verifying the password
//    @Override
    public boolean login(String user, String pass){
        if(user_storage.containsKey(user)){
            if(user_storage.get(user).equals(pass)){
                System.out.println("Correct Password");
                for(Athletes athlete: athletes){
                    if(athlete.getUsername().equals(user));
//                    athlete.athlete_menu();
                    System.out.println(athlete.sport);
//                    for(int i=0; i<athletes.size();i++){
//                        System.out.println(athletes.get(i).sport);
//                    }
                    break;
                }
                return true;
            }
            else
                return false;
        }
        else{
            System.out.println("User Does Not Exist");
            return false;
        }
    }
    
}