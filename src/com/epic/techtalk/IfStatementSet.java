package com.epic.techtalk;

public class IfStatementSet {
    public String getDayOfWeek(int dayOfWeek){
        String dayName;
        if (dayOfWeek == 1) {
            dayName = "Sunday";
        } else if (dayOfWeek == 2) {
            dayName = "Monday";
        } else if (dayOfWeek == 3) {
            dayName = "Tuesday";
        } else if (dayOfWeek == 4) {
            dayName = "Wednesday";
        } else if (dayOfWeek == 5) {
            dayName = "Thursday";
        } else if (dayOfWeek == 6) {
            dayName = "Friday";
        } else if (dayOfWeek == 7) {
            dayName = "Saturday";
        } else {
            dayName = "Invalid day";
        }
        return dayName;
    }
}
