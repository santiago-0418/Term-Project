/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TermProject;
import static TermProject.ReadWrite.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.*;
/**
 *
 * @author Zachary Tremblay
 */
abstract class Athletes {

    String userName;
    String firstName;
    String lastName;
    String sport = "test";
    String verified = "false";

    public static void main(String[] args) {
        Football Zach = new Football("kaze", "Zach", "Tremblay", 4.78, 4.30, 7.33);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
//    public String getSport() {
//        return sport;
//    }

    public String getUsername() {
        return userName;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
    
    

//    public void athlete_menu(){
//        System.out.println("\n----------------------------------");
//        System.out.println("Helo " + this.userName + " You are now in the athlete menu for " + this.getSport() + " athletes.");
//    }
    public void athlete_menu() {
    }
;

}

class Football extends Athletes {

    double fortyYardDash;
    double T_Test;
    double L_Test;

    public Football(String userName, String firstName, String lastName, double fortyYardDash, double T_Test, double L_Test) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = "Football";
        this.fortyYardDash = fortyYardDash;
        this.T_Test = T_Test;
        this.L_Test = L_Test;
    }
    
    public Football(String userName, String firstName, String LastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = LastName;
        this.sport = "Football";
    }

    public void athlete_menu() {
        System.out.println("\n----------------------------------");
        System.out.println("Helo " + this.userName + " You are now in the athlete menu for " + this.getSport() + " athletes.");
    }

    public String getSport() {
        return sport;
    }

    public double getFortyYardDash() {
        return fortyYardDash;
    }

    public void setFortyYardDash(double fortyYardDash) {
        this.fortyYardDash = fortyYardDash;
    }

    public double getT_Test() {
        return T_Test;
    }

    public void setT_Test(double T_Test) {
        this.T_Test = T_Test;
    }

    public double getL_Test() {
        return L_Test;
    }

    public void setL_Test(double L_Test) {
        this.L_Test = L_Test;
    }
    
    public String getTimes(){
        return String.format("%s: %f\n%s: %f\n%s: %f", "Forty Yard Dash",this.fortyYardDash,"T Test",this.T_Test,"L Test",this.L_Test);
    }
    
    public void UploadTimes() throws IOException{
        ArrayList<String> time_list = new ArrayList<>(List.of("40yDash:"+this.fortyYardDash, "T-Test:"+this.T_Test,"L-Test:"+this.L_Test));
        WriteToAthlete(this.firstName,this.sport,time_list);
    }
    
    public void setTimes() throws FileNotFoundException{
        GetAthleteTime(this.firstName,this.sport);
        String times = GetAthleteTime(this.firstName,this.sport);
//        System.out.println(times);
        //Its pArSiNg time
        ArrayList<String> temp_times = new ArrayList<>(Arrays.asList(times.split(",")));
//        temp_times.add("100Fly:35");
//        System.out.println(temp_times.get(0));
        for(String s: temp_times){
            switch(s.substring(0, s.indexOf(":"))){
                case("40yDash"):
                    this.setFortyYardDash(Double.parseDouble(s.substring(s.indexOf(":")+1)));
                case("T-Test"):
                    this.setT_Test(Double.parseDouble(s.substring(s.indexOf(":")+1)));
                case("L-Test"):
                    this.setL_Test(Double.parseDouble(s.substring(s.indexOf(":")+1)));                 
            }
        }
    }
    
    public void ModifyTimes() throws IOException{
        String selection;
        String new_time;
        Scanner user_input = new Scanner(System.in);
        System.out.println("\nDo you want to modify one of your times? If yes write the number corresponding to the time you want to change\nElse, write '0'.\n ");
        System.out.print("1) Forty Yard Dash\n2) T Test\n3) L-Test\nselection: ");
        selection = user_input.nextLine();
        
        switch(selection){
            case "1":
                System.out.print("Enter your new time: ");
                this.setFortyYardDash(Double.parseDouble(user_input.nextLine()));
                this.UploadTimes();
                break;
            case "2":
                System.out.print("Enter your new time: ");
                this.setT_Test(Double.parseDouble(user_input.nextLine()));
                this.UploadTimes();
                break;
            case "3":
                System.out.print("Enter your new time: ");
                this.setL_Test(Double.parseDouble(user_input.nextLine()));
                this.UploadTimes();
                break;
            case "0":
                System.out.println("No changes were made.");
                break;
        }
    }
    
}

class Swimming extends Athletes {

    double fourHundredIM;
    double hundredFree;
    double hundredButterfly;
    String verified = "true";

    public Swimming(String userName, String firstName, String lastName, double fourHundredIM, double hundredFree, double hundredButterfly) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = "Swimming";
        this.fourHundredIM = fourHundredIM;
        this.hundredFree = hundredFree;
        this.hundredButterfly = hundredButterfly;
        CreateAthleteFolder(firstName);
    }

    public Swimming(String userName, String firstName, String LastName, String verified) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = LastName;
        this.sport = "Swimming";
        this.verified = verified;
        CreateAthleteFolder(firstName);
    }

    public void athlete_menu() {
        System.out.println("\n----------------------------------");
        System.out.println("Helo " + this.userName + " You are now in the athlete menu for " + this.getSport() + " athletes.");
    }

    public String getSport() {
        return sport;
    }

    public double getFourHundredIM() {
        return fourHundredIM;
    }

    public void setFourHundredIM(double fourHundredIM) {
        this.fourHundredIM = fourHundredIM;
    }

    public double getHundredFree() {
        return hundredFree;
    }

    public void setHundredFree(double hundredFree) {
        this.hundredFree = hundredFree;
    }

    public double getHundredButterfly() {
        return hundredButterfly;
    }

    public void setHundredButterfly(double hundredButterfly) {
        this.hundredButterfly = hundredButterfly;
    }
    
    public String getTimes(){
        return String.format("%-14s: %.2fs\n%s: %.2fs\n%s: %.2fs", "400m IM",this.fourHundredIM,"100m Freestyle",this.hundredFree,"100m Butterfly",this.hundredButterfly);
    }
    
    public void UploadTimes() throws IOException{
        ArrayList<String> time_list = new ArrayList<>(List.of("400mIM:"+this.fourHundredIM, "100mFree:"+this.hundredFree,"100mFly:"+this.hundredButterfly));
        WriteToAthlete(this.firstName,this.sport,time_list);
    }
    
    public void setTimes() throws FileNotFoundException{
        GetAthleteTime(this.firstName,this.sport);
        
        String times = GetAthleteTime(this.firstName,this.sport);
//        System.out.println(times);
        //Its pArSiNg time
        ArrayList<String> temp_times = new ArrayList<>(Arrays.asList(times.split(",")));
//        temp_times.add("100Fly:35");
//        System.out.println(temp_times.get(0));
        for(String s: temp_times){
            switch(s.substring(0, s.indexOf(":"))){
                case("400mIM"):
                    this.setFourHundredIM(Double.parseDouble(s.substring(s.indexOf(":")+1)));
                case("100mFree"):
                    this.setHundredFree(Double.parseDouble(s.substring(s.indexOf(":")+1)));
                case("100mFly"):
                    this.setHundredButterfly(Double.parseDouble(s.substring(s.indexOf(":")+1)));                 
            }
        }
    }
    
    public void ModifyTimes() throws IOException{
        String selection;
        String new_time;
        Scanner user_input = new Scanner(System.in);
        System.out.println("\nDo you want to modify one of your times? If yes write the number corresponding to the time you want to change\nElse, write '0'.\n ");
        System.out.print("1) 400m IM\n2) 100m Freestyle\n3) 100m Butterfly\nselection: ");
        selection = user_input.nextLine();
        
        switch(selection){
            case "1":
                System.out.print("Enter your new time: ");
                this.setFourHundredIM(Double.parseDouble(user_input.nextLine()));
                this.UploadTimes();
                break;
            case "2":
                System.out.print("Enter your new time: ");
                this.setHundredFree(Double.parseDouble(user_input.nextLine()));
                this.UploadTimes();
                break;
            case "3":
                System.out.print("Enter your new time: ");
                this.setHundredButterfly(Double.parseDouble(user_input.nextLine()));
                this.UploadTimes();
                break;
            case "0":
                System.out.println("No changes were made.");
                break;
        }
    }
    
}

class Track extends Athletes {

    double hundredMeters;
    double twoHundredMeters;
    double fourHundredMeters;

    public Track(String userName, String firstName, String lastName, double hundredMeters, double twoHundredMeters, double fourHundredMeters) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = "Track";
        this.hundredMeters = hundredMeters;
        this.twoHundredMeters = twoHundredMeters;
        this.fourHundredMeters = fourHundredMeters;
    }

    public Track(String userName, String firstName, String LastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = LastName;
        this.sport = "Track";
    }

    public void athlete_menu() {
        System.out.println("\n----------------------------------");
        System.out.println("Helo " + this.userName + " You are now in the athlete menu for " + this.getSport() + " athletes.");
    }

    public String getSport() {
        return sport;
    }

    public double getHundredMeters() {
        return hundredMeters;
    }

    public void setHundredMeters(double hundredMeters) {
        this.hundredMeters = hundredMeters;
    }

    public double getTwoHundredMeters() {
        return twoHundredMeters;
    }

    public void setTwoHundredMeters(double twoHundredMeters) {
        this.twoHundredMeters = twoHundredMeters;
    }

    public double getFourHundredMeters() {
        return fourHundredMeters;
    }

    public void setFourHundredMeters(double fourHundredMeters) {
        this.fourHundredMeters = fourHundredMeters;
    }
    
    public String getTimes(){
        return String.format("%s: %f\n%s: %f\n%s: %f", "100m Sprint",this.hundredMeters,"200m Sprint",this.twoHundredMeters,"400m Sprint",this.fourHundredMeters);
    }
    
    
    public void UploadTimes() throws IOException{
        ArrayList<String> time_list = new ArrayList<>(List.of("100mSprint:"+this.hundredMeters, "200mSprint:"+this.twoHundredMeters,"400mSprint:"+this.fourHundredMeters));
        WriteToAthlete(this.firstName,this.sport,time_list);
    }
    
    public void setTimes() throws FileNotFoundException{
        GetAthleteTime(this.firstName,this.sport);
        String times = GetAthleteTime(this.firstName,this.sport);
//        System.out.println(times);
        //Its pArSiNg time
        ArrayList<String> temp_times = new ArrayList<>(Arrays.asList(times.split(",")));
//        temp_times.add("100Fly:35");
//        System.out.println(temp_times.get(0));
        for(String s: temp_times){
            switch(s.substring(0, s.indexOf(":"))){
                case("100mSprint"):
                    this.setHundredMeters(Double.parseDouble(s.substring(s.indexOf(":")+1)));
                case("200mSprint"):
                    this.setTwoHundredMeters(Double.parseDouble(s.substring(s.indexOf(":")+1)));
                case("400mSprint"):
                    this.setFourHundredMeters(Double.parseDouble(s.substring(s.indexOf(":")+1)));                 
            }
        }
    }

    public void ModifyTimes() throws IOException{
        String selection;
        String new_time;
        Scanner user_input = new Scanner(System.in);
        System.out.println("\nDo you want to modify one of your times? If yes write the number corresponding to the time you want to change\nElse, write '0'.\n ");
        System.out.print("1) 100m Sprint\n2) 200m Sprint\n3) 400m Sprint\nselection: ");
        selection = user_input.nextLine();
        
        switch(selection){
            case "1":
                System.out.print("Enter your new time: ");
                this.setHundredMeters(Double.parseDouble(user_input.nextLine()));
                this.UploadTimes();
                break;
            case "2":
                System.out.print("Enter your new time: ");
                this.setTwoHundredMeters(Double.parseDouble(user_input.nextLine()));
                this.UploadTimes();
                break;
            case "3":
                System.out.print("Enter your new time: ");
                this.setFourHundredMeters(Double.parseDouble(user_input.nextLine()));
                this.UploadTimes();
                break;
            case "0":
                System.out.println("No changes were made.");
                break;
        }
    }
    
}

