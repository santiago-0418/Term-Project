/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TermProject;
import java.io.*;
/**
 *
 * @author santiago
 */
public class SetUp {

    public static void first_time() throws IOException {
        String home = System.getProperty("user.home");
        String f_name = String.format("%s%s",home,"/desktop/SportsPlatform");
        new File(f_name).mkdirs();
        //Creation of Athletes folder
        new File((home+"/desktop/SportsPlatform/Athletes")).mkdirs();
        //Creating of Storage for login
        new File((home+"/desktop/SportsPlatform/LoginInformation")).mkdirs();
        BufferedWriter writer = new BufferedWriter(new FileWriter(home+"/desktop/SportsPlatform/LoginInformation/Admins.txt", false));
                        writer.write("test:123,");
                        writer.close();
        BufferedWriter writer_2 = new BufferedWriter(new FileWriter(home+"/desktop/SportsPlatform/LoginInformation/Users.txt", false));
        writer_2.write("test:123:Swimming:test:noway,");
        writer_2.close();
    }
    
}
