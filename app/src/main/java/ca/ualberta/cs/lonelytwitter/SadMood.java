package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by seneshen on 9/12/17.
 */

public class SadMood extends Mood {

    public SadMood() {
        super();
        this.mood = "Sad";
    }

    public SadMood(Date date) {
        super(date);
        this.mood = "Sad";
    }
}
