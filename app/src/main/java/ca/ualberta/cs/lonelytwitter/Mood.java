package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Abstract Mood class. Subclasses hold specific mood values.
 *
 * @author Micah Seneshen
 * @see SadMood
 * @see HappyMood
 */
public class Mood {
    /**
     * Mood's date
     */
    private Date date;

    /**
     * Mood's name
     */
    protected String mood;

    /**
     * Create new mood with current date as date.
     */
    public Mood(){
        this.date = new Date();
    }

    /**
     * Create new mood with specific date.
     * @param date Mood's date
     */
    public Mood(Date date){
        this.date = date;
    }

    /**
     * Get mood's date
     * @return mood's date
     */
    public Date getDate(){
        return this.date;
    }

    /**
     * Set mood's date
     * @param date mood's date
     */
    public void setDate(Date date){
        this.date = date;
    }

    /**
     * Get a printable mood string.
     * @return mood string
     */
    public String toString(){
        return this.mood;
    }

}
