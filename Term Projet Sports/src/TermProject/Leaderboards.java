/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TermProject;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Collections;

/**
 *
 * @author Zachary Tremblay
 */
public class Leaderboards {

    public void PrintFootballForty(List<Athletes> athletes) {
        List<Athletes> FootballAth = new ArrayList();

        FootballAth = athletes.stream().filter(i -> i.getSport().equals("Football")).collect(Collectors.toList());
        Collections.sort(FootballAth, FortyYardComparator());
        
        
        for(Athletes e: FootballAth){

            System.out.printf("Name: %s   40 time: %.2f", e.firstName+" "+e.getLastName(),  ((Football)e).getFortyYardDash());
        }

    }

    static Comparator<Athletes> FortyYardComparator() {
        return new Comparator<Athletes>() {
            @Override
            public int compare(Athletes o1, Athletes o2) {
                if (((Football) o1).getFortyYardDash() == ((Football) o2).getFortyYardDash()) {
                    return 0;
                } else if (((Football) o1).getFortyYardDash() > ((Football) o2).getFortyYardDash()) {
                    return 1;
                } else {
                    return -1;
                }
            }

        };
    }

}


