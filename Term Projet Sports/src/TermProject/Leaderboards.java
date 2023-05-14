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

    public static void PrintFootballForty(List<Athletes> athletes) {
        List<Athletes> FootballAth;

        FootballAth = athletes.stream().filter(i -> i.getSport().equals("Football")).filter(i -> ((Football) i).getFortyYardDash() > 0).collect(Collectors.toList());
        Collections.sort(FootballAth, FortyYardComparator());
        int place = 1;

        System.out.printf("%-25s %s\n", "Athlete Name:", "40 yard dash:");
        for (Athletes e : FootballAth) {

            System.out.printf("%d. %-25s %.2f\n", place++, e.firstName + " " + e.getLastName(), ((Football) e).getFortyYardDash());
        }

    }

    public static void PrintFootballT_Test(List<Athletes> athletes) {
        List<Athletes> FootballAth;

        FootballAth = athletes.stream().filter(i -> i.getSport().equals("Football")).filter(i -> ((Football) i).getT_Test() > 0).collect(Collectors.toList());
        Collections.sort(FootballAth, T_TestComparator());
        int place = 1;
        System.out.printf("%-25s %s\n", "Athlete Name:", "T-Test time:");
        for (Athletes e : FootballAth) {

            System.out.printf("%d. %-25s %.2f%n", place++, e.firstName + " " + e.getLastName(), ((Football) e).getT_Test());
        }

    }

    public static void PrintFootballL_Test(List<Athletes> athletes) {
        List<Athletes> FootballAth;

        FootballAth = athletes.stream().filter(i -> i.getSport().equals("Football")).filter(i -> ((Football) i).getL_Test() > 0).collect(Collectors.toList());
        Collections.sort(FootballAth, L_TestComparator());
        int place = 1;
        System.out.printf("%-25s %s\n", "Athlete Name:", "L-Test time:");
        for (Athletes e : FootballAth) {

            System.out.printf("%d. %-25s %.2f%n", place++, e.firstName + " " + e.getLastName(), ((Football) e).getL_Test());
        }

    }

    public static void PrintSwimmingFourHundredIM(List<Athletes> athletes) {
        List<Athletes> SwimmingAth;

        SwimmingAth = athletes.stream().filter(i -> i.getSport().equals("Swimming")).filter(i -> ((Swimming) i).getFourHundredIM() > 0).collect(Collectors.toList());
        Collections.sort(SwimmingAth, FourHundredIMComparator());
        int place = 1;
        System.out.printf("%-25s %s\n", "Athlete Name:", "400 IM time:");
        for (Athletes e : SwimmingAth) {

            System.out.printf("%d. %-25s %.2f%n", place++, e.firstName + " " + e.getLastName(), ((Swimming) e).getFourHundredIM());
        }

    }

    public static void PrintSwimmingHundredFree(List<Athletes> athletes) {
        List<Athletes> SwimmingAth;

        SwimmingAth = athletes.stream().filter(i -> i.getSport().equals("Swimming")).filter(i -> ((Swimming) i).getHundredFree() > 0).collect(Collectors.toList());
        Collections.sort(SwimmingAth, HundredFreeComparator());
        int place = 1;
        System.out.printf("%-25s %s\n", "Athlete Name:", "100 Free time:");
        for (Athletes e : SwimmingAth) {

            System.out.printf("%d. %-25s %.2f%n", place++, e.firstName + " " + e.getLastName(), ((Swimming) e).getHundredFree());
        }

    }

    public static void PrintSwimmingHundredButterfly(List<Athletes> athletes) {
        List<Athletes> SwimmingAth;

        SwimmingAth = athletes.stream().filter(i -> i.getSport().equals("Swimming")).filter(i -> ((Swimming) i).getHundredButterfly() > 0).collect(Collectors.toList());
        Collections.sort(SwimmingAth, HundredButterflyComparator());
        int place = 1;

        System.out.printf("%-25s %s\n", "Athlete Name:", "100 Butterfly time:");
        for (Athletes e : SwimmingAth) {

            System.out.printf("%d. %-25s %.2f%n", place++, e.firstName + " " + e.getLastName(), ((Swimming) e).getHundredButterfly());

        }

    }

    public static void PrintTrack100(List<Athletes> athletes) {
        List<Athletes> TrackAth;

        TrackAth = athletes.stream().filter(i -> i.getSport().equals("Track")).filter(i -> ((Track) i).getHundredMeters() > 0).collect(Collectors.toList());
        Collections.sort(TrackAth, HundredMetersComparator());
        int place = 1;
        System.out.printf("%-25s %s\n", "Athlete Name:", "100 meters time:");
        for (Athletes e : TrackAth) {

            System.out.printf("%d. %-25s %.2f%n", place++, e.firstName + " " + e.getLastName(), ((Track) e).getHundredMeters());
        }

    }

    public static void PrintTrack200(List<Athletes> athletes) {
        List<Athletes> TrackAth;

        TrackAth = athletes.stream().filter(i -> i.getSport().equals("Track")).filter(i -> ((Track) i).getTwoHundredMeters() > 0).collect(Collectors.toList());
        Collections.sort(TrackAth, TwoHundredMetersComparator());
        int place = 1;
        System.out.printf("%-25s %s\n", "Athlete Name:", "200 meters time:");
        for (Athletes e : TrackAth) {

            System.out.printf("%d. %-25s %.2f%n", place++, e.firstName + " " + e.getLastName(), ((Track) e).getTwoHundredMeters());
        }

    }

    public static void PrintTrack400(List<Athletes> athletes) {
        List<Athletes> TrackAth;

        TrackAth = athletes.stream().filter(i -> i.getSport().equals("Track")).filter(i -> ((Track) i).getFourHundredMeters() > 0).collect(Collectors.toList());
        Collections.sort(TrackAth, FourHundredMetersComparator());
        int place = 1;
        System.out.printf("%-25s %s\n", "Athlete Name:", "400 meters time:");
        for (Athletes e : TrackAth) {

            System.out.printf("%d. %-25s %.2f%n", place++, e.firstName + " " + e.getLastName(), ((Track) e).getFourHundredMeters());
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

    static Comparator<Athletes> T_TestComparator() {
        return new Comparator<Athletes>() {
            @Override
            public int compare(Athletes o1, Athletes o2) {
                if (((Football) o1).getT_Test() == ((Football) o2).getT_Test()) {
                    return 0;
                } else if (((Football) o1).getT_Test() > ((Football) o2).getT_Test()) {
                    return 1;
                } else {
                    return -1;
                }
            }

        };
    }

    static Comparator<Athletes> L_TestComparator() {
        return new Comparator<Athletes>() {
            @Override
            public int compare(Athletes o1, Athletes o2) {
                if (((Football) o1).getL_Test() == ((Football) o2).getL_Test()) {
                    return 0;
                } else if (((Football) o1).getL_Test() > ((Football) o2).getL_Test()) {
                    return 1;
                } else {
                    return -1;
                }
            }

        };
    }

    static Comparator<Athletes> FourHundredIMComparator() {
        return new Comparator<Athletes>() {
            @Override
            public int compare(Athletes o1, Athletes o2) {
                if (((Swimming) o1).getFourHundredIM() == ((Swimming) o2).getFourHundredIM()) {
                    return 0;
                } else if (((Swimming) o1).getFourHundredIM() > ((Swimming) o2).getFourHundredIM()) {
                    return 1;
                } else {
                    return -1;
                }
            }

        };
    }

    static Comparator<Athletes> HundredFreeComparator() {
        return new Comparator<Athletes>() {
            @Override
            public int compare(Athletes o1, Athletes o2) {
                if (((Swimming) o1).getHundredFree() == ((Swimming) o2).getHundredFree()) {
                    return 0;
                } else if (((Swimming) o1).getHundredFree() > ((Swimming) o2).getHundredFree()) {
                    return 1;
                } else {
                    return -1;
                }
            }

        };

    }

    static Comparator<Athletes> HundredButterflyComparator() {
        return new Comparator<Athletes>() {
            @Override
            public int compare(Athletes o1, Athletes o2) {
                if (((Swimming) o1).getHundredButterfly() == ((Swimming) o2).getHundredButterfly()) {
                    return 0;
                } else if (((Swimming) o1).getHundredButterfly() > ((Swimming) o2).getHundredButterfly()) {
                    return 1;
                } else {
                    return -1;
                }
            }

        };
    }

    static Comparator<Athletes> HundredMetersComparator() {
        return new Comparator<Athletes>() {
            @Override
            public int compare(Athletes o1, Athletes o2) {
                if (((Track) o1).getHundredMeters() == ((Track) o2).getHundredMeters()) {
                    return 0;
                } else if (((Track) o1).getHundredMeters() > ((Track) o2).getHundredMeters()) {
                    return 1;
                } else {
                    return -1;
                }
            }

        };
    }

    static Comparator<Athletes> TwoHundredMetersComparator() {
        return new Comparator<Athletes>() {
            @Override
            public int compare(Athletes o1, Athletes o2) {
                if (((Track) o1).getTwoHundredMeters() == ((Track) o2).getTwoHundredMeters()) {
                    return 0;
                } else if (((Track) o1).getTwoHundredMeters() > ((Track) o2).getTwoHundredMeters()) {
                    return 1;
                } else {
                    return -1;
                }
            }

        };
    }

    static Comparator<Athletes> FourHundredMetersComparator() {
        return new Comparator<Athletes>() {
            @Override
            public int compare(Athletes o1, Athletes o2) {
                if (((Track) o1).getFourHundredMeters() == ((Track) o2).getFourHundredMeters()) {
                    return 0;
                } else if (((Track) o1).getFourHundredMeters() > ((Track) o2).getFourHundredMeters()) {
                    return 1;
                } else {
                    return -1;
                }
            }

        };
    }

}
