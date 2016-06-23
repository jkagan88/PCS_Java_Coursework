/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

/**
 *
 * @author YYKF
 */
public class Time
{
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        if (this.hour > 12)
        {
            this.hour = 12;
        }
        if (this.minute > 59)
        {
            this.minute = 59;
        }
        if (this.second > 59)
        {
            this.second = 59;
        }
    }
    
    public void print(Time time)
    {
        System.out.println(time.hour + ":" + time.minute + ":" + time.second);
    }
    
    /**
     * @return the hour
     */
    public int getHour() {
        
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(int hour) {

        this.hour = hour;
    }

    /**
     * @return the minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * @param minute the minute to set
     */
    public void setMinute(int minute) {

        this.minute = minute;
    }

    /**
     * @return the second
     */
    public int getSecond() {
        return second;
    }

    /**
     * @param second the second to set
     */
    public void setSecond(int second) {

        this.second = second;
    }
}
