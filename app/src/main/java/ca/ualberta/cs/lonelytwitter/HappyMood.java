package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Happy mood class
 * @author Micah Seneshen
 */
public class HappyMood extends Mood {

    /**
     * Create happy mood object
     */
    public HappyMood() {
        super();
        this.mood = "Happy";
    }

    /**
     * Create happy mood object with specific date
     * @param date mood's date
     */
    public HappyMood(Date date) {
        super(date);
        this.mood = "Happy";
    }


}
