/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TermProject;

/**
 *
 * @author Zachary Tremblay
 */
abstract class Athletes {

    String userName;
    String firstName;
    String lastName;
    String sport = "test";

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
    
}

class Swimming extends Athletes {

    double fourHundredIM;
    double hundredFree;
    double hundredButterfly;

    public Swimming(String userName, String firstName, String lastName, double fourHundredIM, double hundredFree, double hundredButterfly) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = "Swimming";
        this.fourHundredIM = fourHundredIM;
        this.hundredFree = hundredFree;
        this.hundredButterfly = hundredButterfly;
    }

    public Swimming(String userName, String firstName, String LastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = LastName;
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
    
    

}
