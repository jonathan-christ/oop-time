/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;

public class Main {

    public static void main(String[] args) {
        MyTime t = new MyTime();
        
        t.setHours(10);
        t.setMinutes(59);
        t.setSeconds(15);
        t.setMeridian(true);
        t.advanceTime(3600);

        t.displayTime12();
        t.displayTime24();

        
    }
    
}
