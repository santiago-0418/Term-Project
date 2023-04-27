/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TermProject;

import java.util.*;

/**
 *
 * @author Zachary Tremblay
 */
public class Leaderboards {

}

class FortyYardComparator implements Comparator<Football> {

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
}

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
