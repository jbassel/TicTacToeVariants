package com.jacobbassel.tictactoevariants;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    int count = 0;
    int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0,a7 = 0, a8 = 0, a9 = 0;
    int a = 0;

    public int[] wins = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] Button_IDS = {R.id.imageButton8, R.id.imageButton3, R.id.imageButton4,
            R.id.imageButton5, R.id.imageButton6, R.id.imageButton7,
            R.id.imageButton9, R.id.imageButton10, R.id.imageButton11};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        PreferenceManager.getDefaultSharedPreferences(getBaseContext()).
                edit().clear().apply();


        ImageButton button1 = findViewById(R.id.imageButton12);
        button1.setOnClickListener(this);

        ImageButton button2 = findViewById(R.id.imageButton14);
        button2.setOnClickListener(this);

        TextView text1 = findViewById(R.id.textView);
        text1.setOnClickListener(this);

        TextView text2 = findViewById(R.id.textView2);
        text1.setOnClickListener(this);

        TextView text3 = findViewById(R.id.textView3);
        text1.setOnClickListener(this);

        Button button3 = findViewById(R.id.button4);
        button3.setOnClickListener(this);

        for (int id : Button_IDS) {
            ImageButton button = findViewById(id);
            button.setOnClickListener(this);
            button.setImageResource(R.drawable.download);
        }
    }

    @Override
    public void onClick(View v) {
        TextView text1 = findViewById(R.id.textView);
        text1.setOnClickListener(this);


        TextView text2 = findViewById(R.id.textView2);
        text2.setOnClickListener(this);

        TextView text3 = findViewById(R.id.textView3);
        text3.setOnClickListener(this);

        ImageButton button1 = findViewById(R.id.imageButton12);
        button1.setOnClickListener(this);
        ImageButton button2 = findViewById(R.id.imageButton14);
        button2.setOnClickListener(this);


        if (v.getId() == R.id.imageButton12) {
            count = 1;
        } else if (v.getId() == R.id.imageButton14) {
            count = 2;
        }
        for (int id = 0; id < 9; id++) {

            if (v.getId() == Button_IDS[id] && count == 1) {
                ImageButton box1 = findViewById(Button_IDS[id]);
                box1.setImageResource(R.drawable.letterx);

                wins[id] = 1;


            }
            else if (v.getId() == Button_IDS[id] && count == 2) {
                ImageButton box2 = findViewById(Button_IDS[id]);
                box2.setImageResource(R.drawable.lettero);

                wins[id] = 2;
            }


            if ((wins[0] == 1 && wins[1] == 1 && wins[2] == 1) || (wins[3] == 1 && wins[4] == 1 && wins[5] == 1) || (wins[6] == 1 && wins[7] == 1 && wins[8] == 1) || (wins[0] == 1 && wins[3] == 1 && wins[6] == 1)
                    || (wins[1] == 1 && wins[4] == 1 && wins[7] == 1) || (wins[2] == 1 && wins[5] == 1 && wins[8] == 1) || (wins[0] == 1 && wins[4] == 1 && wins[8] == 1) || (wins[2] == 1 && wins[4] == 1 && wins[6] == 1))
            {
                text1.setText("Congratulations!      X Wins!");

                text2.setText(" ");

                text3.setText(" ");


            }
            else if ((wins[0] == 2 && wins[1] == 2 && wins[2] == 2) || (wins[3] == 2 && wins[4] == 2 && wins[5] == 2) || (wins[6] == 2 && wins[7] == 2 && wins[8] == 2) || (wins[0] == 2 && wins[3] == 2 && wins[6] == 2)
                    || (wins[1] == 2 && wins[4] == 2 && wins[7] == 2) || (wins[2] == 2 && wins[5] == 2 && wins[8] == 2) || (wins[0] == 2 && wins[4] == 2 && wins[8] == 2) || (wins[2] == 2 && wins[4] == 2 && wins[6] == 2))
            {
                text1.setText("Congratulations!     O Wins!");

                text2.setText(" ");

                text3.setText(" ");

            }

            a1 = wins[0]; a2 = wins[1]; a3 = wins[2]; a4 = wins[3]; a5 = wins[4]; a6 = wins[5]; a7 = wins[6]; a8 = wins[7]; a9 = wins[8];





            if (v.getId() == R.id.button4) {
                text1.setText("Welcome to Wild Tic-Tac-Toe");
                text2.setText("You may pick X or O.. First to 3 wins!");
                text3.setText("Please choose which letter you would like to place");

                for (int i = 0; i < 9; i++)
                {
                    ImageButton box1 = findViewById(Button_IDS[id]);
                    box1.setImageResource(R.drawable.download);
                }
                wins[0] = 0; wins[1] = 0; wins[2] = 0; wins[3] = 0; wins[4] = 0; wins[5] = 0; wins[6] = 0; wins[7] = 0; wins[8] = 0;
                a1 = 0; a2 = 0; a3 = 0;

            }

        }
    }


    @Override
    protected void onPause() {
        super.onPause();


        TextView text1 = findViewById(R.id.textView);
        text1.setOnClickListener(this);
        TextView text2 = findViewById(R.id.textView2);
        text2.setOnClickListener(this);
        TextView text3 = findViewById(R.id.textView3);
        text3.setOnClickListener(this);

        SharedPreferences sp = getSharedPreferences("textkey", 0);
        SharedPreferences.Editor edit1 = sp.edit();

        SharedPreferences sp2 = getSharedPreferences("textkey2", 0);
        SharedPreferences.Editor edit2 = sp2.edit();

        SharedPreferences sp3 = getSharedPreferences("textkey3", 0);
        SharedPreferences.Editor edit3 = sp3.edit();

        SharedPreferences sp4 = getSharedPreferences("winkey1", 0);
        SharedPreferences.Editor edit4 = sp4.edit();

        SharedPreferences sp5 = getSharedPreferences("winkey2", 0);
        SharedPreferences.Editor edit5 = sp5.edit();

        SharedPreferences sp6 = getSharedPreferences("winkey3", 0);
        SharedPreferences.Editor edit6 = sp6.edit();

        SharedPreferences sp7 = getSharedPreferences("winkey4", 0);
        SharedPreferences.Editor edit7 = sp7.edit();

        SharedPreferences sp8 = getSharedPreferences("winkey5", 0);
        SharedPreferences.Editor edit8 = sp8.edit();

        SharedPreferences sp9 = getSharedPreferences("winkey6", 0);
        SharedPreferences.Editor edit9 = sp9.edit();

        SharedPreferences sp10 = getSharedPreferences("winkey7", 0);
        SharedPreferences.Editor edit10 = sp10.edit();

        SharedPreferences sp11 = getSharedPreferences("winkey8", 0);
        SharedPreferences.Editor edit11 = sp11.edit();

        SharedPreferences sp12 = getSharedPreferences("winkey9", 0);
        SharedPreferences.Editor edit12 = sp12.edit();

        edit1.putString("text1", text1.getText().toString());
        edit2.putString("text2", text2.getText().toString());
        edit3.putString("text3", text3.getText().toString());
        edit4.putInt("a1", a1);
        edit5.putInt("a2", a2);
        edit6.putInt("a3", a3);
        edit7.putInt("a4", a4);
        edit8.putInt("a5", a5);
        edit9.putInt("a6", a6);
        edit10.putInt("a7", a7);
        edit11.putInt("a8", a8);
        edit12.putInt("a9", a9);




        edit1.commit();
        edit2.commit();
        edit3.commit();
        edit4.commit();
        edit5.commit();
        edit6.commit();
        edit7.commit();
        edit8.commit();
        edit9.commit();
        edit10.commit();
        edit11.commit();
        edit12.commit();


    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Integer> winners = new ArrayList<Integer>(0);

        TextView text1 = findViewById(R.id.textView);
        text1.setOnClickListener(this);
        TextView text2 = findViewById(R.id.textView2);
        text2.setOnClickListener(this);
        TextView text3 = findViewById(R.id.textView3);
        text3.setOnClickListener(this);

        SharedPreferences sp = getSharedPreferences("textkey", 0);
        String textValue = sp.getString("text1", "Welcome to Wild Tic-Tac-Toe");

        SharedPreferences sp2 = getSharedPreferences("textkey2", 0);
        String textValue2 = sp2.getString("text3", "You may pick X or O.. First to 3 wins!");

        SharedPreferences sp3 = getSharedPreferences("textkey3", 0);
        String textValue3 = sp3.getString("text2", "Please choose which letter you would like to place");

        SharedPreferences sp4 = getSharedPreferences("winkey1", 0);
        int win1 = sp4.getInt("a1", a1);

        SharedPreferences sp5 = getSharedPreferences("winkey2", 0);
        int win2 = sp5.getInt("a2", a2);

        SharedPreferences sp6 = getSharedPreferences("winkey3", 0);
        int win3 = sp6.getInt("a3", a3);

        SharedPreferences sp7 = getSharedPreferences("winkey4", 0);
        int win4 = sp7.getInt("a4", a4);

        SharedPreferences sp8 = getSharedPreferences("winkey5", 0);
        int win5 = sp8.getInt("a5", a5);

        SharedPreferences sp9 = getSharedPreferences("winkey6", 0);
        int win6 = sp9.getInt("a6", a6);

        SharedPreferences sp10 = getSharedPreferences("winkey7", 0);
        int win7 = sp10.getInt("a7", a7);

        SharedPreferences sp11 = getSharedPreferences("winkey8", 0);
        int win8 = sp11.getInt("a8", a8);

        SharedPreferences sp12 = getSharedPreferences("winkey9", 0);
        int win9 = sp12.getInt("a9", a9);

        text1.setText(textValue);
        text2.setText(textValue2);
        text3.setText(textValue3);

        a1 = win1;
        a2 = win2;
        a3 = win3;
        a4 = win4;
        a5 = win5;
        a6 = win6;
        a7 = win7;
        a8 = win8;
        a9 = win9;


        winners.add(0, a1);
        winners.add(1, a2);
        winners.add(2, a3);
        winners.add(3, a4);
        winners.add(4, a5);
        winners.add(5, a6);
        winners.add(6, a7);
        winners.add(7, a8);
        winners.add(8, a9);

        for (int thing : winners) {
            if (thing == 0) {
                ImageButton box1 = findViewById(Button_IDS[a]);
                box1.setImageResource(R.drawable.download);
                wins[a] = 0;
            } else if (thing == 1) {
                ImageButton box1 = findViewById(Button_IDS[a]);
                box1.setImageResource(R.drawable.letterx);
                wins[a] = 1;
            } else {
                ImageButton box1 = findViewById(Button_IDS[a]);
                box1.setImageResource(R.drawable.lettero);
                wins[a] = 2;
            }
            a++;
        }

    }


}
