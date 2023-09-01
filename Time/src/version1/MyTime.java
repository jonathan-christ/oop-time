/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;

/**
 *
 * @author User
 */
public class MyTime {

    private int hours;
    private int minutes;
    private int seconds;
    private boolean meridian;

    public MyTime() {
        this.hours = 12;
        this.minutes = 0;
        this.seconds = 0;
        this.meridian = true;
    }

//    SETTERS
    public void setHours(int hours) {
        if (hours > 12) {
            System.out.println("[X] Hours value greater than 12");
        } else {
            this.hours = hours;
        }

    }

    public void setMinutes(int minutes) {
        if (minutes > 59) {
            System.out.println("[X] Minutes value greater than 59");
        } else {
            this.minutes = minutes;
        }

    }

    public void setSeconds(int seconds) {
        if (seconds > 59) {
            System.out.println("[X] Seconds value greater than 59");
        } else {
            this.seconds = seconds;
        }
    }

    public void setMeridian(boolean meridian) {
        this.meridian = meridian;
    }

//  GETTERS
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public String getMeridian() {
        return meridian ? "AM" : "PM";
    }

// USER FUNCTIONS
    public void advanceTime(int seconds) {
        int oldHour = this.hours;
        int totalSecs = this.seconds + seconds;
        this.seconds = totalSecs % 60;
        if (totalSecs / 60 > 0) {
            int totalMins = (totalSecs / 60) + this.minutes;
            this.minutes = totalMins % 60;

            if (totalMins / 60 > 0) {
                this.hours += totalMins / 60;
            }
        }
        
        if (this.hours>=12) {
            this.hours  %= 12;
            if(this.hours == 0) this.hours = 12;
            if(oldHour != 12) this.meridian = !this.meridian;
            System.out.println(meridian);
        }
    }

    public void tickBySecond() {
        this.advanceTime(1);
    }

    public void tickByMinute() {
        this.advanceTime(60);
    }

    public void tickByHour() {
        this.advanceTime(3600);
    }

    public void displayTime12() {
        System.out.printf(
                "%02d : %02d : %02d %s\n", 
                hours, minutes, seconds, getMeridian()
        );
    }

    public void displayTime24() {
        boolean meridCase = meridian;
        if(hours == 12 ) meridCase = !meridian;
        
        int finHours = meridCase ? hours: hours+12;
        
        finHours %= 24;

        System.out.printf("%02d : %02d : %02d\n", finHours, minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format(
                "Hours: %d\nMinutes: %d\nSeconds: %d\nMeridian: %s\n", 
                hours, minutes, seconds, getMeridian());
    }

}
