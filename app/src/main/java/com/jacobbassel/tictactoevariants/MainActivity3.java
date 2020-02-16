package com.jacobbassel.tictactoevariants;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity3  extends AppCompatActivity implements View.OnClickListener {
    int count = 0;
    int count2 = 0;
    int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0, a7 = 0, a8 = 0, a9 = 0;
    int a = 0;

    public int[] wins = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] Button_IDS = {R.id.imageButton8, R.id.imageButton3, R.id.imageButton4,
            R.id.imageButton5, R.id.imageButton6, R.id.imageButton7,
            R.id.imageButton9, R.id.imageButton10, R.id.imageButton11};



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main3);

            PreferenceManager.getDefaultSharedPreferences(getBaseContext()).
                    edit().clear().apply();

            TextView text1 = findViewById(R.id.textView);
            text1.setOnClickListener(this);

            TextView text2 = findViewById(R.id.textView2);
            text1.setOnClickListener(this);

            TextView text3 = findViewById(R.id.textView3);
            text1.setOnClickListener(this);

            Button button3 = findViewById(R.id.button4);
            button3.setOnClickListener(this);

            text1.setText("Welcome to Misere Tic-Tac-Toe!  If X gets 3 in a row, O wins!");

            text2.setText("It is O's turn");
            count2++;
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




            if (count2 % 2 == 0) {
                count = 1;
                text2.setText("it is O's turn");
            } else if (count2 % 2 != 0) {
                count = 2;
                text2.setText("it is X's turn");
            }
            for (int id = 0; id < 9; id++) {

                if (v.getId() == Button_IDS[id] && count == 1) {
                    ImageButton box1 = findViewById(Button_IDS[id]);
                    box1.setImageResource(R.drawable.letterx);

                    wins[id] = 1;


                }
                if (v.getId() == Button_IDS[id] && count == 2) {
                    ImageButton box1 = findViewById(Button_IDS[id]);
                    box1.setImageResource(R.drawable.lettero);

                    wins[id] = 2;


                }



                if ((wins[0] == 1 && wins[1] == 1 && wins[2] == 1) || (wins[3] == 1 && wins[4] == 1 && wins[5] == 1) || (wins[6] == 1 && wins[7] == 1 && wins[8] == 1) || (wins[0] == 1 && wins[3] == 1 && wins[6] == 1)
                        || (wins[1] == 1 && wins[4] == 1 && wins[7] == 1) || (wins[2] == 1 && wins[5] == 1 && wins[8] == 1) || (wins[0] == 1 && wins[4] == 1 && wins[8] == 1) || (wins[2] == 1 && wins[4] == 1 && wins[6] == 1)) {
                    text1.setText("Congratulations!      O Wins!");

                    text2.setText(" ");


                }

                a1 = wins[0];
                a2 = wins[1];
                a3 = wins[2];
                a4 = wins[3];
                a5 = wins[4];
                a6 = wins[5];
                a7 = wins[6];
                a8 = wins[7];
                a9 = wins[8];


                if (v.getId() == R.id.button4) {
                    text1.setText("Welcome to Misere Tic-Tac-Toe!  If X gets 3 in a row, O wins!");
                    text2.setText("It is O's turn");

                    for (int i = 0; i < 9; i++) {
                        ImageButton box1 = findViewById(Button_IDS[id]);
                        box1.setImageResource(R.drawable.download);
                    }
                    wins[0] = 0;
                    wins[1] = 0;
                    wins[2] = 0;
                    wins[3] = 0;
                    wins[4] = 0;
                    wins[5] = 0;
                    wins[6] = 0;
                    wins[7] = 0;
                    wins[8] = 0;
                    a1 = 0;
                    a2 = 0;
                    a3 = 0;

                }
                count2++;

            }
        }
    }
