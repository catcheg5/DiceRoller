package com.example.diceroller;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.TextView;

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

    //Level 2: Then add an input box where the user can enter a number from 1 to 6.
    // Repeat the process above, if the generated dice number is the same as the number in the box,
    // then display Congratulations.

    @SuppressLint("SetTextI18n")


    TextView txt; // Congrats text
    TextView input; // user input
    TextView button; // Widget for dice roll button
    TextView count; // Widget to hold the counter
    int score = 0; // Score counter

    public void on_button_click(View view) {

       
        count = this.findViewById(R.id.textView3);

        Random r = new Random(); // Creating random Object
        int number = r.nextInt(7); // Assigning value to number, the random generator
        txt = this.findViewById(R.id.congrats); // Attaching to the Congrats msg box
        input = this.findViewById(R.id.editText); // Attaching to the input box
        String numberInsert = input.getText().toString(); // getting the input and storing it in
        int result = Integer.parseInt(numberInsert); // turning int INPUT into String
        button = this.findViewById(R.id.button); // Attaching to the button
        button.setText(Integer.toString(number));

        if (number == result) {

            score++;
            count.setText(Integer.toString(score));
            button.setText(Integer.toString(number)); // displays numbers on button in String format

            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    txt.setText("Congratulations");
                }
            });


        }


    }


}














