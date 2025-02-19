/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TermProject;
import java.io.IOException;
import java .util.*;
import static TermProject.ReadWrite.*;
import static TermProject.Athletes.*;
import java.io.FileNotFoundException;
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


class AdminStorage {
       
    
    //IDEA: have a secret code that lets people become admin
    private String secret_code = "123";
    //Initializing the HashMap
    private static HashMap<String, String> admin_storage = new HashMap<>();
    List<Administrator> admins = new ArrayList();
    
    //Initializing the list of administrators (will later be read from a file)
    public void init_admin_storage() throws FileNotFoundException{
        admin_storage = RestoreAdmins();
        //System.out.println(admin_storage);
    }
    
    public HashMap RestoreAdmins() throws FileNotFoundException{
        HashMap<String, String> hs = new HashMap<>();
        String temp = GetAdminLogIn();
        //Parse text
        ArrayList<String> temp_storage = new ArrayList<>(Arrays.asList(temp.substring(0,temp.lastIndexOf(',')).split(",")));
        //System.out.println(temp_storage);
        for(String s: temp_storage){
            //System.out.println(s.substring(0, s.indexOf(":")));
            String key = s.substring(0, s.indexOf(":"));
            String value = s.substring(s.indexOf(":")+1);
            hs.put(key,value);
            admins.add(new Administrator(key, value));
            //System.out.println("key "+key + " value "+value);
        }
        //System.out.println(hs);
        
        return hs;
    }
    
    
    
    //Setting a new username and password
    public boolean set_up(String user, String pass, String secret_access) throws IOException{
        if(secret_code.equals(secret_access)){
            admin_storage.put(user, pass);
            admins.add(new Administrator(user,pass));
            SaveAdmins(admin_storage);
            return true;
        }
        else{
            System.out.println("Wrong Access Code Entered");
            return false;
        }
    }
    //Verifying the password
//    @Override
    public boolean login(String user, String pass) throws FileNotFoundException{
        if(admin_storage.containsKey(user)){
            if(admin_storage.get(user).equals(pass)){
                System.out.println("Correct Password");
                for(Administrator admin: admins){
                    if(admin.getUser_name().equals(user)){
                        
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
    //Initilalizing list of Athletes !!THIS IS THE THING CAUSING ALL OF THE PROBLEMS IM TOO TIRED TO FIGURE OUT A SOLUTION!!
    public List<Athletes> athletes = new ArrayList();
    //Initializing the HashMap
    private HashMap<String, String> user_storage = new HashMap<>();
    
    public List getAthletes(){
        return athletes;
    }
    
    public void init_user_storage() throws FileNotFoundException{
        user_storage = RestoreUsers();
        //System.out.println(user_storage);
    }
    
    public  HashMap RestoreUsers() throws FileNotFoundException{
        HashMap<String, String> hs = new HashMap<>();
        String temp = GetUserLogIn();
        //Parse text
        ArrayList<String> temp_storage = new ArrayList<>(Arrays.asList(temp.substring(0,temp.lastIndexOf(',')).split(",")));
        //System.out.println(temp_storage);
        for(String s: temp_storage){
            ArrayList<String> temp_ls = new ArrayList<>(Arrays.asList(s.split(":")));
            //System.out.println(temp_ls);
            //System.out.println(s.substring(0, s.indexOf(":")));
            String key = temp_ls.get(0);
            String value = temp_ls.get(1);
            String sport = temp_ls.get(2);
            String f_name = temp_ls.get(3);
            String l_name = temp_ls.get(4);
            String verified = temp_ls.get(5);
            hs.put(key,value);
            //FOUND THE PROBLEM!!!!!!!!!
            switch(sport){                
                    case "Football":
                        athletes.add(new Football(key,f_name, l_name, verified));
                        break;
                    case "Swimming":
                        athletes.add(new Swimming(key,f_name, l_name, verified));
                        break;
                    case "Track":
                        athletes.add(new Track(key,f_name, l_name, verified));
                        break;
                    default:
                        System.out.println("Something Broke");
                        break;
                }
            for(Athletes a: athletes){
                if(a.getClass()==Swimming.class)
                {
                 ((Swimming)a).setTimes();
                }
                else if(a.getClass()==Football.class){
                    ((Football)a).setTimes();
                }
                else if(a.getClass()==Track.class){
                    ((Track)a).setTimes();
                }
            }
            //System.out.println("key "+key + " value "+value +" sport "+sport);
        }
        //System.out.println(hs);
        
        return hs;
    }
    
    
    
    //Setting a new username and password
    public boolean set_up(String user, String pass, String secret_access, String first_name, String last_name) throws IOException{
        if(secret_code.equals(secret_access)){
            user_storage.put(user, pass);
            boolean selected_sport = false;
            //Selecting the sport
            int sport_selection;
            do{
                System.out.print("Select which sport you want to participate in: ");
                System.out.printf("%s\n%58s\n%55s\n%s","1) Football", "2) Swimming","3) Track","Selection: ");
                sport_selection = DriverClass.UserInput(1, 3);
                switch(sport_selection){                
                    case 1:
                        athletes.add(new Football(user,first_name, last_name, "false"));
                        selected_sport = true;
                        initTxt();
                        break;
                    case 2:
                        athletes.add(new Swimming(user,first_name, last_name, "false"));
                        selected_sport = true;
                        initTxt();
                        break;
                    case 3:
                        athletes.add(new Track(user,first_name, last_name, "false"));
                        selected_sport = true;
                        initTxt();
                        break;
                    default:
                        System.out.println("Non valid input, please enter a number from 1 to 3 ");
                        break;
                }
                //Saves Users information to text file
                SaveUsers(user_storage, athletes);
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
    public boolean login(String user, String pass) throws IOException{
        if(user_storage.containsKey(user)){
            if(user_storage.get(user).equals(pass)){
                //System.out.println("Correct Password");
                for(Athletes athlete: athletes){
                    
                    if(athlete.getUsername().equals(user) && athlete.getClass()==Swimming.class)
                    {
                        System.out.println("--------------------------------------------------------------"
                                + "\n--------------------------------------------------------------");
                        System.out.println("Hello " + athlete.firstName + " "+ athlete.lastName + " you are a " + ((Swimming)athlete).sport + " athlete");
//                        ((Swimming)athlete).UploadTimes();
//                        ((Swimming)athlete).setTimes();
                        System.out.println("Your times are:\n" + ((Swimming)athlete).getTimes());
                        System.out.println("Verified: "+((Swimming)athlete).verified);
                        ((Swimming)athlete).ModifyTimes();
                        
                    }
                    else if(athlete.getUsername().equals(user) && athlete.getClass()==Football.class)
                    {
                        System.out.println("--------------------------------------------------------------"
                                + "\n--------------------------------------------------------------");
                        System.out.println("Hello " + athlete.firstName + " "+ athlete.lastName + " you are a " + ((Football)athlete).sport + " athlete");
//                        ((Football)athlete).UploadTimes();
//                        ((Football)athlete).setTimes();
                        System.out.println("Your times are:\n" + ((Football)athlete).getTimes());
                        System.out.println("Verified: "+((Football)athlete).verified);
                        ((Football)athlete).ModifyTimes();
                    
                    }
                    else if(athlete.getUsername().equals(user) && athlete.getClass()==Track.class)
                    {
                        System.out.println("--------------------------------------------------------------"
                                + "\n--------------------------------------------------------------");
                        System.out.println("Hello " + athlete.firstName + " "+ athlete.lastName + " you are a " + ((Track)athlete).sport + " athlete");
//                        ((Track)athlete).UploadTimes();
//                        ((Track)athlete).setTimes();
                        System.out.println("Your times are:\n" + ((Track)athlete).getTimes());
                        System.out.println("Verified: "+((Track)athlete).verified);
                        ((Track)athlete).ModifyTimes();
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
    
    public void initTxt() throws FileNotFoundException, IOException{
        for(Athletes athlete: athletes){
            if(athlete.getClass()==Swimming.class){
                ((Swimming)athlete).UploadTimes();
                ((Swimming)athlete).setTimes();
            }
            else if(athlete.getClass()==Football.class){
                ((Football)athlete).UploadTimes();
                ((Football)athlete).setTimes();
            }
            else if(athlete.getClass()==Track.class){
                ((Track)athlete).UploadTimes();
                ((Track)athlete).setTimes();
            }
        }
    }
     
    public void SaveChanges(List funnylist) throws IOException{
        SaveUsers(user_storage, funnylist);
        for(int i=0; i<funnylist.size();i++){
            //System.out.println(funnylist.get(i));
        }
    }
    
    public void Search(String l_name) throws FileNotFoundException{
        
        for(Athletes athlete: athletes){
            if(athlete.lastName.equals(l_name) && athlete.getClass()==Swimming.class){
                ((Swimming)athlete).setTimes();
                System.out.println(athlete.firstName+" "+athlete.lastName+" times are:\n" + ((Swimming)athlete).getTimes());
                break;
            }
            else if(athlete.lastName.equals(l_name) && athlete.getClass()==Football.class){
                ((Football)athlete).setTimes();
                System.out.println(athlete.firstName+" "+athlete.lastName+" times are:\n" + ((Football)athlete).getTimes());
                break;
            }
            else if(athlete.lastName.equals(l_name) && athlete.getClass()==Track.class){
                ((Track)athlete).setTimes();
                System.out.println(athlete.firstName+" "+athlete.lastName+" times are:\n" + ((Track)athlete).getTimes());
                break;
            }
            
            else{
                System.out.println("User not Found");
                break;
            }
        }
    }
    
}