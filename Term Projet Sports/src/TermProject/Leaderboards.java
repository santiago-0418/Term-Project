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

/*class FortyYardComparator implements Comparator<Football> {

    @Override
    public int compare(Football o1, Football o2) {
        if (o1.getFortyYardDash() == o2.getFortyYardDash()) {
            return 0;
        } else if (o1.getFortyYardDash() > o2.getFortyYardDash()) {
            return 1;
        } else {
            return -1;
        }
    }
}*/
class T_TestComparator implements Comparator<Football> {

    @Override
    public int compare(Football o1, Football o2) {
        if (o1.getT_Test() == o2.getT_Test()) {
            return 0;
        } else if (o1.getT_Test() > o2.getT_Test()) {
            return 1;
        } else {
            return -1;
        }
    }
}

class L_TestComparator implements Comparator<Football> {

    @Override
    public int compare(Football o1, Football o2) {
        if (o1.getL_Test() == o2.getL_Test()) {
            return 0;
        } else if (o1.getL_Test() > o2.getL_Test()) {
            return 1;
        } else {
            return -1;
        }
    }
}

class FourHundredIMComparator implements Comparator<Swimming> {

    @Override
    public int compare(Swimming o1, Swimming o2) {
        if (o1.getFourHundredIM() == o2.getFourHundredIM()) {
            return 0;
        } else if (o1.getFourHundredIM() > o2.getFourHundredIM()) {
            return 1;
        } else {
            return -1;
        }
    }
}

class HundredFreeComparator implements Comparator<Swimming> {

    @Override
    public int compare(Swimming o1, Swimming o2) {
        if (o1.getHundredFree() == o2.getHundredFree()) {
            return 0;
        } else if (o1.getHundredFree() > o2.getHundredFree()) {
            return 1;
        } else {
            return -1;
        }
    }
}

class HundredButterflyComparator implements Comparator<Swimming> {

    @Override
    public int compare(Swimming o1, Swimming o2) {
        if (o1.getHundredButterfly() == o2.getHundredButterfly()) {
            return 0;
        } else if (o1.getHundredButterfly() > o2.getHundredButterfly()) {
            return 1;
        } else {
            return -1;
        }
    }
}

class HundredMetersComparator implements Comparator<Track> {

    @Override
    public int compare(Track o1, Track o2) {
        if (o1.getHundredMeters() == o2.getHundredMeters()) {
            return 0;
        } else if (o1.getHundredMeters() > o2.getHundredMeters()) {
            return 1;
        } else {
            return -1;
        }
    }
}

class TwoHundredMetersComparator implements Comparator<Track> {

    @Override
    public int compare(Track o1, Track o2) {
        if (o1.getTwoHundredMeters() == o2.getTwoHundredMeters()) {
            return 0;
        } else if (o1.getTwoHundredMeters() > o2.getTwoHundredMeters()) {
            return 1;
        } else {
            return -1;
        }
    }
}

class FourHundredMetersComparator implements Comparator<Track> {

    @Override
    public int compare(Track o1, Track o2) {
        if (o1.getFourHundredMeters() == o2.getFourHundredMeters()) {
            return 0;
        } else if (o1.getFourHundredMeters() > o2.getFourHundredMeters()) {
            return 1;
        } else {
            return -1;
        }
    }
}
