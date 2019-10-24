package com.example.diceroller;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressLint("SetTextI18n")

    TextView txt; // Widget for Congrats text
    TextView input; // Widget for user input
    TextView button; // Widget for dice roll button
    TextView count; // Widget to hold the counter
    TextView breaker; // Widget for d-icebreaker
    TextView random;
    int score = 0; // Score counter
    int result;
    String numberInsert;


    public void input() {

        // *input*
        input = this.findViewById(R.id.editText); // Attaching to the input box
        numberInsert = input.getText().toString(); // getting the input and storing it in
        result = Integer.parseInt(numberInsert); // turning int INPUT into String
        // *input*


    }

    public void roll_the_dice(View view) {

        breaker = this.findViewById(R.id.dbreaker);
        random = this.findViewById(R.id.randomQ);


        input();

        Random r = new Random(); // Creating random Object
        int number = r.nextInt(7); // Assigning value to number, the random generator


        count = this.findViewById(R.id.textView3);
        button = this.findViewById(R.id.button); // Attaching to the button
        button.setText(Integer.toString(number));
        txt = this.findViewById(R.id.congrats); // Attaching to the Congrats msg box


        if (number == result) {

            score++; //Increment score by 1
            count.setText(Integer.toString(score));
            button.setText(Integer.toString(number)); // displays numbers on button in String format
            txt.setText("Congratulations");

        } else if (number != result) {

            count.setText(Integer.toString(score));
            button.setText(Integer.toString(number)); // displays numbers on button in String format

            txt.setText(" ");


        }

    }


    public void QuestionsButton(View V) {

        breaker = this.findViewById(R.id.dbreaker);
        random = this.findViewById(R.id.randomQ);

        String [] Questions = new String[6];

        Questions[0] = "If you could go anywhere in the world, where would you go?";
        Questions[1] = "If you were stranded on a desert island, what three things" +
                "would you want to take with you?";
        Questions[2] = "If you could eat only one food for the rest of your life, what would that be?";
        Questions[3] = "If you won a million dollars, what is the first thing you would buy?";
        Questions[4] = "If you could spend the day with one fictional character, who would it be?";
        Questions[5] = "If you found a magic lantern and a genie gave you three wishes, what would you wish?";


        Random generator = new Random();
        String x = (String) Array.get(Questions, generator.nextInt(6));
        random.setText(x);


    }

}















