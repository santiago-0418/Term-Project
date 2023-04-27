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
//class Password {
//    
//    public static void main(String[] args) {
//        //Creating the hashmap
//        UserStorage storage = new UserStorage();
//        //Test values
//        storage.set_up("abc","123","123");
//           
//        //Asking for input
//        String username; String pass;
//        Scanner user_input = new Scanner(System.in);
//        System.out.println("Enter your username: ");
//        username = user_input.nextLine();
//        System.out.println("Enter your password: ");
//        pass = user_input.nextLine();
//        
//        //Calling to validate
//        storage.login(username, pass);
//    }
//    
//}

interface Storage{
    
    public boolean set_up(String user, String pass, String code);
    public boolean login(String user, String pass);
    
}

class AdminStorage implements Storage{
       
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
    @Override
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

class UserStorage implements Storage{
       
    //IDEA: have a secret code that lets people become admin
    private String secret_code = "321";
    //Initializing the HashMap
    private HashMap<String, String> user_storage = new HashMap<>();
    
    //Setting a new username and password
    public boolean set_up(String user, String pass, String secret_access){
        if(secret_code.equals(secret_access)){
            user_storage.put(user, pass);
            return true;
        }
        else{
            System.out.println("Wrong Access Code Entered");
            return false;
        }
    }
    //Verifying the password
    @Override
    public boolean login(String user, String pass){
        if(user_storage.containsKey(user)){
            if(user_storage.get(user).equals(pass)){
                System.out.println("Correct Password");
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