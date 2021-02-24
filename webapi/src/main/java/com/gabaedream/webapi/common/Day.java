package com.gabaedream.webapi.common;

/**
 * Day of the week
 */
public enum Day {
    Sunday("Sunday", 0),
    Monday("Monday", 1),
    Tuesday("Tuesday",2),
    Wednesday("Wednesday",3),
    Thursday("Thursday",4),
    Friday("Friday",5),
    Saturday("Saturday",6);

    private String dayOfTheWeek;
    private int index;

    Day(String dayOfTheWeek, int index) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.index = index;
    }
}
