package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static android.R.attr.text;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
    private RadioGroup moodSelector;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
        moodSelector = (RadioGroup) findViewById(R.id.moodRadioGroup);
		Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);

        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

        final Activity activity = this;

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

                NormalTweet tweet = new NormalTweet(text);

                switch(moodSelector.getCheckedRadioButtonId()){
                    case R.id.happyRadio:
                        tweet.setHappy();
                        break;
                    case R.id.sadRadio:
                        tweet.setSad();
                        break;
                }

                tweetList.add(tweet);

                adapter.notifyDataSetChanged();

                saveInFile();

                // From: https://stackoverflow.com/questions/8785023/how-to-close-android-soft-keyboard-programmatically
                // Sept 19, 2017

                View view = activity.getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }

			}
		});

        clearButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                tweetList.clear();
                adapter.notifyDataSetChanged();

            }
        });
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
        try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Taken from https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            // 2017-09-19

            Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        adapter = new ArrayAdapter<Tweet>(this, android.R.layout.simple_list_item_1, tweetList);

    }
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
            gson.toJson(tweetList, out);
            out.flush();

            fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
            throw new RuntimeException();
		} catch (IOException e) {
			e.printStackTrace();
            throw new RuntimeException();
		}
	}
}