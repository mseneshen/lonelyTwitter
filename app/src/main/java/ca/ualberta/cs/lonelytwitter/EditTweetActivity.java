package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;

public class EditTweetActivity extends Activity {

    private String message;
    private String date;

    private TextView messageText;
    private TextView dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        messageText = (TextView) findViewById(R.id.message);
        dateText = (TextView) findViewById(R.id.date);

        message = getIntent().getStringExtra("tweet_message");
        date = getIntent().getStringExtra("tweet_date");

        messageText.setText(message);
        dateText.setText(date);
    }
}
