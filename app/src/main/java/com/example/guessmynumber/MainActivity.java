package com.example.guessmynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText guess;
    Button go;
    int value;
    String guessValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go = findViewById(R.id.btgo);
        guess = findViewById(R.id.etguess);





        //Get value from the edittext element and convert it to integer
        Random rand = new Random();
        final int[] randomValue = {rand.nextInt(21)};
        Toast.makeText(MainActivity.this,"Guessed Value: " + randomValue[0], Toast.LENGTH_LONG).show();


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                guessValue = guess.getText().toString();

                //Checks if edittext is empty
                try{
                    value = Integer.valueOf(guessValue);
                }
                catch (Exception e) {
                    value = Integer.valueOf("-1");
                }


                if(value > randomValue[0] && value >= 0 && value <= 20 ){
                    Toast.makeText(MainActivity.this, "Too High", Toast.LENGTH_SHORT).show();
                }
                else if(value < randomValue[0] && value >= 0 && value <= 20 ){
                    Toast.makeText(MainActivity.this, "Too Low", Toast.LENGTH_SHORT).show();
                }
                else if(value == randomValue[0] && value != -1){
                    Toast.makeText(MainActivity.this, "Congratulation you guessed correctly", Toast.LENGTH_SHORT).show();
                    randomValue[0] = rand.nextInt(21);
                }
                else {
                    Toast.makeText(MainActivity.this,"Enter a valid number ", Toast.LENGTH_LONG).show();
                }
            }
        });



    }

}