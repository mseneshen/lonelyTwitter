package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by seneshen on 9/12/17.
 */

public class HappyMood extends Mood {

    public HappyMood() {
        super();
        this.mood = "Happy";
    }

    public HappyMood(Date date) {
        super(date);
        this.mood = "Happy";
    }


}
