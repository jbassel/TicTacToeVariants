package com.jacobbassel.tictactoevariants;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(this);

        Button button2 = findViewById(R.id.button6);
        button2.setOnClickListener(this);

        Button buttonNum = findViewById(R.id.buttonNum);
        buttonNum.setOnClickListener(this);


        }

    @Override
    public void onClick(View v) {

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(this);

        Button button2 = findViewById(R.id.button6);
        button2.setOnClickListener(this);


        TextView text1 = findViewById(R.id.textView4);
        text1.setOnClickListener(this);

        TextView text2 = findViewById(R.id.textView5);
        text2.setOnClickListener(this);

        text1.setText("In Wild Tic-Tac-Toe, any player can place an X or an O.  The rules are the /n" +
                "same.  You must match 3 in a row, but the player can place any symbol.");


        text2.setText("In Misere Tic-Tac-Toe, one Player places an X while the other places an O.  The rules are that /n" +
                "O must not prevent X from getting 3 in a row.  If O prevents this, they win.  If they do not, X wins.");
        if (v.getId() == R.id.button2)
        {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        }
        else if (v.getId() == R.id.button6)
        {
            startActivity(new Intent(MainActivity.this, MainActivity3.class));
        }
        else if (v.getId() == R.id.buttonNum)
            startActivity(new Intent(this, NumericalTicTacToe.class));



    }
}





