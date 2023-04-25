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

    String firstName;
    String lastName;
    String sport;
    
    public static void main(String[] args) {
        Football Zach = new Football("Zach", "Tremblay", 4.90, 4.30, 7.33);
    }

}

class Football extends Athletes {

    double fortyYardDash;
    double T_Test;
    double L_Test;

    public Football(String firstName, String lastName, double fortyYardDash, double T_Test, double L_Test) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = "Football";
        this.fortyYardDash = fortyYardDash;
        this.T_Test = T_Test;
        this.L_Test = L_Test;
    }

}

class Swimming extends Athletes {

    double fourHundredIM;
    double hundredFree;
    double hundredButterfly;

    public Swimming(String firstName, String lastName, double fourHundredIM, double hundredFree, double hundredButterfly) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = "Swimming";
        this.fourHundredIM = fourHundredIM;
        this.hundredFree = hundredFree;
        this.hundredButterfly = hundredButterfly;
    }

}

class Track extends Athletes {

    double hundredMeters;
    double twoHundredMeters;
    double fourHundredMeters;

    public Track(String firstName, String lastName, double hundredMeters, double twoHundredMeters, double fourHundredMeters) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = "Track";
        this.hundredMeters = hundredMeters;
        this.twoHundredMeters = twoHundredMeters;
        this.fourHundredMeters = fourHundredMeters;
    }
    
    

}


