/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TermProject;

/**
 *
 * @author santiago
 */
public class Administrator {
    
    //Attributes
    String name;
    String user_name;
    String password;
    
    //Full Constructor
    public Administrator (String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }
    
    //Getter
    public String getUser_name() {
        return user_name;
    }
    public String getPassword() {
        return password;
    }
    //Setter
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
