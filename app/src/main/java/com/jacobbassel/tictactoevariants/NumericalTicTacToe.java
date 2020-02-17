//Eliot Fordham
//Jacob Bassel
package com.jacobbassel.tictactoevariants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import org.w3c.dom.Text;

import static java.lang.Integer.parseInt;

public class NumericalTicTacToe extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener, Button.OnClickListener{

    //To store numerical values to corresponding ImageButton
    int sq1 = 0;
    int sq2 = 0;
    int sq3 = 0;
    int sq4 = 0;
    int sq5 = 0;
    int sq6 = 0;
    int sq7 = 0;
    int sq8 = 0;
    int sq9 = 0;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numerical_tic_tac_toe);

        TextView textView = findViewById(R.id.textView);

        ImageButton ib1 = findViewById(R.id.imageButton1a);
        ImageButton ib2 = findViewById(R.id.imageButton2a);
        ImageButton ib3 = findViewById(R.id.imageButton3);
        ImageButton ib4 = findViewById(R.id.imageButton4);
        ImageButton ib5 = findViewById(R.id.imageButton5);
        ImageButton ib6 = findViewById(R.id.imageButton6);
        ImageButton ib7 = findViewById(R.id.imageButton7);
        ImageButton ib8 = findViewById(R.id.imageButton8);
        ImageButton ib9 = findViewById(R.id.imageButton9);

        Button play = findViewById(R.id.buttonPlay);
        Button menu = findViewById(R.id.buttonMenu);
        Button instructions = findViewById(R.id.buttonInstruction);

        RadioGroup rg = findViewById(R.id.radioGroup);

        rg.setOnCheckedChangeListener(this);

        ib1.setOnClickListener(this);
        ib2.setOnClickListener(this);
        ib3.setOnClickListener(this);
        ib4.setOnClickListener(this);
        ib5.setOnClickListener(this);
        ib6.setOnClickListener(this);
        ib7.setOnClickListener(this);
        ib8.setOnClickListener(this);
        ib9.setOnClickListener(this);
        play.setOnClickListener(this);
        menu.setOnClickListener(this);
        instructions.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
    }

    @Override
    public void onClick(View view) {

        TextView tv = findViewById(R.id.textView);
        Button play = findViewById(R.id.buttonPlay);
        Button menu = findViewById(R.id.buttonMenu);
        RadioButton rb1 = findViewById(R.id.radioButton1);
        RadioButton rb2 = findViewById(R.id.radioButton2);
        RadioButton rb3 = findViewById(R.id.radioButton3);
        RadioButton rb4 = findViewById(R.id.radioButton4);
        RadioButton rb5 = findViewById(R.id.radioButton5);
        RadioButton rb6 = findViewById(R.id.radioButton6);
        RadioButton rb7 = findViewById(R.id.radioButton7);
        RadioButton rb8 = findViewById(R.id.radioButton8);
        RadioButton rb9 = findViewById(R.id.radioButton9);

        ImageButton ib1 = findViewById(R.id.imageButton1a);
        ImageButton ib2 = findViewById(R.id.imageButton2a);
        ImageButton ib3 = findViewById(R.id.imageButton3);
        ImageButton ib4 = findViewById(R.id.imageButton4);
        ImageButton ib5 = findViewById(R.id.imageButton5);
        ImageButton ib6 = findViewById(R.id.imageButton6);
        ImageButton ib7 = findViewById(R.id.imageButton7);
        ImageButton ib8 = findViewById(R.id.imageButton8);
        ImageButton ib9 = findViewById(R.id.imageButton9);

        RadioGroup rg = findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(this);


        //Listener for ImageButtons
        if (view.getClass().getName().equalsIgnoreCase("androidx.appcompat.widget.AppCompatImageButton")){
            int temp = -1;
            temp = setNumber(view);
            if(temp == -1)
                return;
            setScore(view, temp);
            testWin();
        }

        else if (view.getId()==R.id.buttonMenu){
            Intent intent = new Intent(this, MainActivity.class);
            finish();
            startActivity(intent);
        }

        else if (view.getId()==R.id.buttonPlay){
            Intent intent = getIntent();
            SharedPreferences pref = getSharedPreferences("MyPref", 0);
            pref.edit().clear().apply();

            tv.setText("Odd's turn!");
            play.setVisibility(View.INVISIBLE);
            menu.setVisibility(View.INVISIBLE);

            rb1.setVisibility(View.VISIBLE);
            rb2.setVisibility(View.VISIBLE);
            rb3.setVisibility(View.VISIBLE);
            rb4.setVisibility(View.VISIBLE);
            rb5.setVisibility(View.VISIBLE);
            rb6.setVisibility(View.VISIBLE);
            rb7.setVisibility(View.VISIBLE);
            rb8.setVisibility(View.VISIBLE);
            rb9.setVisibility(View.VISIBLE);

            ib1.setVisibility(View.INVISIBLE);
            ib1.setTag(-1);
            ib2.setVisibility(View.INVISIBLE);
            ib2.setTag(-1);
            ib3.setVisibility(View.INVISIBLE);
            ib3.setTag(-1);
            ib4.setVisibility(View.INVISIBLE);
            ib4.setTag(-1);
            ib5.setVisibility(View.INVISIBLE);
            ib5.setTag(-1);
            ib6.setVisibility(View.INVISIBLE);
            ib6.setTag(-1);
            ib7.setVisibility(View.INVISIBLE);
            ib7.setTag(-1);
            ib8.setVisibility(View.INVISIBLE);
            ib8.setTag(-1);
            ib9.setVisibility(View.INVISIBLE);
            ib9.setTag(-1);

            sq1 = 0;
            sq2 = 0;
            sq3 = 0;
            sq4 = 0;
            sq5 = 0;
            sq6 = 0;
            sq7 = 0;
            sq8 = 0;
            sq9 = 0;

            finish();
            startActivity(intent);
        }

        else if (view.getId()==R.id.buttonInstruction){
            Intent intent = new Intent (this, NumericalInstructionsActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onPause(){
        super.onPause();

        TextView tv = findViewById(R.id.textView);

        ImageButton ib1 = findViewById(R.id.imageButton1a);
        ImageButton ib2 = findViewById(R.id.imageButton2a);
        ImageButton ib3 = findViewById(R.id.imageButton3);
        ImageButton ib4 = findViewById(R.id.imageButton4);
        ImageButton ib5 = findViewById(R.id.imageButton5);
        ImageButton ib6 = findViewById(R.id.imageButton6);
        ImageButton ib7 = findViewById(R.id.imageButton7);
        ImageButton ib8 = findViewById(R.id.imageButton8);
        ImageButton ib9 = findViewById(R.id.imageButton9);

        Button play = findViewById(R.id.buttonPlay);
        Button menu = findViewById(R.id.buttonMenu);
        Button instructions = findViewById(R.id.buttonInstruction);

        RadioButton rb1 = findViewById(R.id.radioButton1);
        RadioButton rb2 = findViewById(R.id.radioButton2);
        RadioButton rb3 = findViewById(R.id.radioButton3);
        RadioButton rb4 = findViewById(R.id.radioButton4);
        RadioButton rb5 = findViewById(R.id.radioButton5);
        RadioButton rb6 = findViewById(R.id.radioButton6);
        RadioButton rb7 = findViewById(R.id.radioButton7);
        RadioButton rb8 = findViewById(R.id.radioButton8);
        RadioButton rb9 = findViewById(R.id.radioButton9);


        SharedPreferences sp = getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sp.edit();

        if((parseInt(ib1.getTag().toString()) != -1)) {editor.putInt("ib1", parseInt(ib1.getTag().toString()));}
        if((parseInt(ib2.getTag().toString()) != -1)) {editor.putInt("ib2", parseInt(ib2.getTag().toString()));}
        if((parseInt(ib3.getTag().toString()) != -1)) {editor.putInt("ib3", parseInt(ib3.getTag().toString()));}
        if((parseInt(ib4.getTag().toString()) != -1)) {editor.putInt("ib4", parseInt(ib4.getTag().toString()));}
        if((parseInt(ib5.getTag().toString()) != -1)) {editor.putInt("ib5", parseInt(ib5.getTag().toString()));}
        if((parseInt(ib6.getTag().toString()) != -1)) {editor.putInt("ib6", parseInt(ib6.getTag().toString()));}
        if((parseInt(ib7.getTag().toString()) != -1)) {editor.putInt("ib7", parseInt(ib7.getTag().toString()));}
        if((parseInt(ib8.getTag().toString()) != -1)) {editor.putInt("ib8", parseInt(ib8.getTag().toString()));}
        if((parseInt(ib9.getTag().toString()) != -1)) {editor.putInt("ib9", parseInt(ib9.getTag().toString()));}

        editor.putInt("menu", menu.getVisibility());
        editor.putInt("play", play.getVisibility());
        editor.putInt("instructions",instructions.getVisibility());

        editor.putInt("rb1", rb1.getVisibility());
        editor.putInt("rb2", rb2.getVisibility());
        editor.putInt("rb3", rb3.getVisibility());
        editor.putInt("rb4", rb4.getVisibility());
        editor.putInt("rb5", rb5.getVisibility());
        editor.putInt("rb6", rb6.getVisibility());
        editor.putInt("rb7", rb7.getVisibility());
        editor.putInt("rb8", rb8.getVisibility());
        editor.putInt("rb9", rb9.getVisibility());

        editor.putInt("sq1", sq1);
        editor.putInt("sq2", sq2);
        editor.putInt("sq3", sq3);
        editor.putInt("sq4", sq4);
        editor.putInt("sq5", sq5);
        editor.putInt("sq6", sq6);
        editor.putInt("sq7", sq7);
        editor.putInt("sq8", sq8);
        editor.putInt("sq9", sq9);

        editor.putString("tv", tv.getText().toString());

        editor.commit();

        Log.i("Here!!!", "The value ib1 is " + sp.getInt("ib1", -1));
        Log.i("Here!!!", "The value ib2 is " + sp.getInt("ib2", -1));
        Log.i("Here!!!", "The value ib3 is " + sp.getInt("ib3", -1));
        Log.i("Here!!!", "The value ib4 is " + sp.getInt("ib4", -1));
        Log.i("Here!!!", "The value ib5 is " + sp.getInt("ib5", -1));
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView tv = findViewById(R.id.textView);

        ImageButton ib1 = findViewById(R.id.imageButton1a);
        ImageButton ib2 = findViewById(R.id.imageButton2a);
        ImageButton ib3 = findViewById(R.id.imageButton3);
        ImageButton ib4 = findViewById(R.id.imageButton4);
        ImageButton ib5 = findViewById(R.id.imageButton5);
        ImageButton ib6 = findViewById(R.id.imageButton6);
        ImageButton ib7 = findViewById(R.id.imageButton7);
        ImageButton ib8 = findViewById(R.id.imageButton8);
        ImageButton ib9 = findViewById(R.id.imageButton9);

        Button play = findViewById(R.id.buttonPlay);
        Button menu = findViewById(R.id.buttonMenu);
        Button instructions = findViewById(R.id.buttonInstruction);

        RadioButton rb1 = findViewById(R.id.radioButton1);
        RadioButton rb2 = findViewById(R.id.radioButton2);
        RadioButton rb3 = findViewById(R.id.radioButton3);
        RadioButton rb4 = findViewById(R.id.radioButton4);
        RadioButton rb5 = findViewById(R.id.radioButton5);
        RadioButton rb6 = findViewById(R.id.radioButton6);
        RadioButton rb7 = findViewById(R.id.radioButton7);
        RadioButton rb8 = findViewById(R.id.radioButton8);
        RadioButton rb9 = findViewById(R.id.radioButton9);

        SharedPreferences sp = getSharedPreferences("MyPref", 0);

        if((sp.getInt("ib1", -1) != -1)) {ib1.setImageResource(sp.getInt("ib1", parseInt(ib1.getTag().toString())));}
        if((sp.getInt("ib2", -1) != -1)) {ib2.setImageResource(sp.getInt("ib2", parseInt(ib2.getTag().toString())));}
        if((sp.getInt("ib3", -1) != -1)) {ib3.setImageResource(sp.getInt("ib3", parseInt(ib3.getTag().toString())));}
        if((sp.getInt("ib4", -1) != -1)) {ib4.setImageResource(sp.getInt("ib4", parseInt(ib4.getTag().toString())));}
        if((sp.getInt("ib5", -1) != -1)) {ib5.setImageResource(sp.getInt("ib5", parseInt(ib5.getTag().toString())));}
        if((sp.getInt("ib6", -1) != -1)) {ib6.setImageResource(sp.getInt("ib6", parseInt(ib6.getTag().toString())));}
        if((sp.getInt("ib7", -1) != -1)) {ib7.setImageResource(sp.getInt("ib7", parseInt(ib7.getTag().toString())));}
        if((sp.getInt("ib8", -1) != -1)) {ib8.setImageResource(sp.getInt("ib8", parseInt(ib8.getTag().toString())));}
        if((sp.getInt("ib9", -1) != -1)) {ib9.setImageResource(sp.getInt("ib9", parseInt(ib9.getTag().toString())));}

        rb1.setVisibility(sp.getInt("rb1", View.VISIBLE));
        rb2.setVisibility(sp.getInt("rb2", View.VISIBLE));
        rb3.setVisibility(sp.getInt("rb3", View.VISIBLE));
        rb4.setVisibility(sp.getInt("rb4", View.VISIBLE));
        rb5.setVisibility(sp.getInt("rb5", View.VISIBLE));
        rb6.setVisibility(sp.getInt("rb6", View.VISIBLE));
        rb7.setVisibility(sp.getInt("rb7", View.VISIBLE));
        rb8.setVisibility(sp.getInt("rb8", View.VISIBLE));
        rb9.setVisibility(sp.getInt("rb9", View.VISIBLE));

        play.setVisibility(sp.getInt("play", View.INVISIBLE));
        menu.setVisibility(sp.getInt("menu", View.INVISIBLE));
        instructions.setVisibility(sp.getInt("instructions", View.VISIBLE));

        sq1 = sp.getInt("sq1", 0);
        sq2 = sp.getInt("sq2", 0);
        sq3 = sp.getInt("sq3", 0);
        sq4 = sp.getInt("sq4", 0);
        sq5 = sp.getInt("sq5", 0);
        sq6 = sp.getInt("sq6", 0);
        sq7 = sp.getInt("sq7", 0);
        sq8 = sp.getInt("sq8", 0);
        sq9 = sp.getInt("sq9", 0);

        tv.setText(sp.getString("tv", tv.getText().toString()));
    }

    //Tests for a winner; Sets menu/play button visible, if winner
    private void testWin(){
        Button play = findViewById(R.id.buttonPlay);
        Button menu = findViewById(R.id.buttonMenu);
        Button instructions = findViewById(R.id.buttonInstruction);
        TextView tv = findViewById(R.id.textView);
        if((sq1+sq2+sq3==15)&&(tv.getText().equals("Odd's turn!"))){
            tv.setText("Even has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if((sq4+sq5+sq6==15)&&(tv.getText().equals("Odd's turn!"))){
            tv.setText("Even has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if((sq7+sq8+sq9==15)&&(tv.getText().equals("Odd's turn!"))){
            tv.setText("Even has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if((sq1+sq4+sq7==15)&&(tv.getText().equals("Odd's turn!"))){
            tv.setText("Even has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if((sq2+sq5+sq8==15)&&(tv.getText().equals("Odd's turn!"))){
            tv.setText("Even has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if((sq3+sq6+sq9==15)&&(tv.getText().equals("Odd's turn!"))){
            tv.setText("Even has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if((sq1+sq5+sq9==15)&&(tv.getText().equals("Odd's turn!"))){
            tv.setText("Even has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if((sq7+sq5+sq3==15)&&(tv.getText().equals("Odd's turn!"))){
            tv.setText("Even has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if((sq1+sq2+sq3==15)&&(tv.getText().equals("Even's turn!"))){
            tv.setText("Odd has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if((sq4+sq5+sq6==15)&&(tv.getText().equals("Even's turn!"))){
            tv.setText("Odd has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if((sq7+sq8+sq9==15)&&(tv.getText().equals("Even's turn!"))){
            tv.setText("Odd has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if((sq1+sq4+sq7==15)&&(tv.getText().equals("Even's turn!"))){
            tv.setText("Odd has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if((sq2+sq5+sq8==15)&&(tv.getText().equals("Even's turn!"))){
            tv.setText("Odd has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if((sq3+sq6+sq9==15)&&(tv.getText().equals("Even's turn!"))){
            tv.setText("Odd has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if((sq1+sq5+sq9==15)&&(tv.getText().equals("Even's turn!"))){
            tv.setText("Odd has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if((sq7+sq5+sq3==15)&&(tv.getText().equals("Even's turn!"))){
            tv.setText("Odd has won!!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
        else if(sq1!=0&&sq2!=0&&sq3!=0&&sq4!=0&&sq5!=0&&sq6!=0&&sq7!=0&&sq8!=0&&sq9!=0){
            tv.setText("It's a tie!");
            play.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);
        }
    }

    //This method sets the ImageButton clicked to the corresponding number selected in the RadioGroup
    //An integer value is returned to be passed to the setScore method
    private int setNumber(View view){
        int value = -1;

        RadioButton rb1 = findViewById(R.id.radioButton1);
        RadioButton rb2 = findViewById(R.id.radioButton2);
        RadioButton rb3 = findViewById(R.id.radioButton3);
        RadioButton rb4 = findViewById(R.id.radioButton4);
        RadioButton rb5 = findViewById(R.id.radioButton5);
        RadioButton rb6 = findViewById(R.id.radioButton6);
        RadioButton rb7 = findViewById(R.id.radioButton7);
        RadioButton rb8 = findViewById(R.id.radioButton8);
        RadioButton rb9 = findViewById(R.id.radioButton9);

        ImageButton ib1 = findViewById(R.id.imageButton1a);
        ImageButton ib2 = findViewById(R.id.imageButton2a);
        ImageButton ib3 = findViewById(R.id.imageButton3);
        ImageButton ib4 = findViewById(R.id.imageButton4);
        ImageButton ib5 = findViewById(R.id.imageButton5);
        ImageButton ib6 = findViewById(R.id.imageButton6);
        ImageButton ib7 = findViewById(R.id.imageButton7);
        ImageButton ib8 = findViewById(R.id.imageButton8);
        ImageButton ib9 = findViewById(R.id.imageButton9);


        TextView tv = findViewById(R.id.textView);

        //Does not execute if a player has already won
        if (tv.getText().equals("Even has won!!")||tv.getText().equals("Odd has won!!")||tv.getText().equals("It's a tie!")){
            return -1;
        }
        else if(rb1.isChecked() && tv.getText().equals("Odd's turn!") && parseInt(view.getTag().toString()) == -1){
            ((ImageButton) view).setImageResource(R.drawable.n1);
            view.setTag(R.drawable.n1);
            Log.i("Look!", "The tag was set to " + R.drawable.n1);
            value = 1;
            tv.setText("Even's turn!");
            rb1.toggle();
            rb1.setVisibility(View.INVISIBLE);
        }
        else if(rb3.isChecked() && tv.getText().equals("Odd's turn!") && parseInt(view.getTag().toString()) == -1){
            ((ImageButton) view).setImageResource(R.drawable.n3);
            view.setTag(R.drawable.n3);
            value = 3;
            tv.setText("Even's turn!");
            rb3.toggle();
            rb3.setVisibility(View.INVISIBLE);
        }
        else if(rb5.isChecked() && tv.getText().equals("Odd's turn!") && parseInt(view.getTag().toString()) == -1){
            ((ImageButton) view).setImageResource(R.drawable.n5);
            view.setTag(R.drawable.n5);
            value = 5;
            tv.setText("Even's turn!");
            rb5.toggle();
            rb5.setVisibility(View.INVISIBLE);
        }
        else if(rb7.isChecked() && tv.getText().equals("Odd's turn!") && parseInt(view.getTag().toString()) == -1){
            ((ImageButton) view).setImageResource(R.drawable.n7);
            view.setTag(R.drawable.n7);
            value = 7;
            tv.setText("Even's turn!");
            rb7.toggle();
            rb7.setVisibility(View.INVISIBLE);
        }
        else if(rb9.isChecked() && tv.getText().equals("Odd's turn!") && parseInt(view.getTag().toString()) == -1){
            ((ImageButton) view).setImageResource(R.drawable.n9);
            view.setTag(R.drawable.n9);
            value = 9;
            tv.setText("Even's turn!");
            rb9.toggle();
            rb9.setVisibility(View.INVISIBLE);
        }
        else if(rb2.isChecked() && tv.getText().equals("Even's turn!") && parseInt(view.getTag().toString()) == -1){
            ((ImageButton) view).setImageResource(R.drawable.n2);
            view.setTag(R.drawable.n2);
            value = 2;
            tv.setText("Odd's turn!");
            rb2.toggle();
            rb2.setVisibility(View.INVISIBLE);
        }
        else if(rb4.isChecked() && tv.getText().equals("Even's turn!") && parseInt(view.getTag().toString()) == -1){
            ((ImageButton) view).setImageResource(R.drawable.n4);
            view.setTag(R.drawable.n4);
            value = 4;
            tv.setText("Odd's turn!");
            rb4.toggle();
            rb4.setVisibility(View.INVISIBLE);
        }
        else if(rb6.isChecked() && tv.getText().equals("Even's turn!") && parseInt(view.getTag().toString()) == -1){
            ((ImageButton) view).setImageResource(R.drawable.n6);
            view.setTag(R.drawable.n6);
            value = 6;
            tv.setText("Odd's turn!");
            rb6.toggle();
            rb6.setVisibility(View.INVISIBLE);
        }
        else if(rb8.isChecked() && tv.getText().equals("Even's turn!") && parseInt(view.getTag().toString()) == -1){
            ((ImageButton) view).setImageResource(R.drawable.n8);
            view.setTag(R.drawable.n8);
            value = 8;
            tv.setText("Odd's turn!");
            rb8.toggle();
            rb8.setVisibility(View.INVISIBLE);
        }

        //Error Messages; Makes toast if wrong number/no number selected
        else if(rb1.isChecked() && tv.getText().equals("Even's turn!")){
            Toast errorToast = Toast.makeText(this,"Choose an even number!", Toast.LENGTH_LONG);
            errorToast.show();
        }
        else if(rb3.isChecked() && tv.getText().equals("Even's turn!")){
            Toast errorToast = Toast.makeText(this,"Choose an even number!", Toast.LENGTH_LONG);
            errorToast.show();
        }
        else if(rb5.isChecked() && tv.getText().equals("Even's turn!")){
            Toast errorToast = Toast.makeText(this,"Choose an even number!", Toast.LENGTH_LONG);
            errorToast.show();
        }
        else if(rb7.isChecked() && tv.getText().equals("Even's turn!")){
            Toast errorToast = Toast.makeText(this,"Choose an even number!", Toast.LENGTH_LONG);
            errorToast.show();
        }
        else if(rb9.isChecked() && tv.getText().equals("Even's turn!")){
            Toast errorToast = Toast.makeText(this,"Choose an even number!", Toast.LENGTH_LONG);
            errorToast.show();
        }
        else if(rb2.isChecked() && tv.getText().equals("Odd's turn!")){
            Toast errorToast = Toast.makeText(this,"Choose an odd number!", Toast.LENGTH_LONG);
            errorToast.show();
        }
        else if(rb4.isChecked() && tv.getText().equals("Odd's turn!")){
            Toast errorToast = Toast.makeText(this,"Choose an odd number!", Toast.LENGTH_LONG);
            errorToast.show();
        }
        else if(rb6.isChecked() && tv.getText().equals("Odd's turn!")){
            Toast errorToast = Toast.makeText(this,"Choose an odd number!", Toast.LENGTH_LONG);
            errorToast.show();
        }
        else if(rb8.isChecked() && tv.getText().equals("Odd's turn!")){
            Toast errorToast = Toast.makeText(this,"Choose an odd number!", Toast.LENGTH_LONG);
            errorToast.show();
        }
        else if(parseInt(view.getTag().toString()) != -1){
            Toast errorToast = Toast.makeText(this,"Choose an empty spot", Toast.LENGTH_LONG);
            errorToast.show();
        }
        else{
            Toast errorToast = Toast.makeText(this,"Choose a number!", Toast.LENGTH_LONG);
            errorToast.show();
        }
        return value;
    }

    //This method is to record an integer value for each ImageButton
    private void setScore(View view, int number){
        if(view.getId()==(R.id.imageButton1a))
            sq1 = number;
        else if(view.getId()==(R.id.imageButton2a))
            sq2 = number;
        else if(view.getId()==(R.id.imageButton3))
            sq3 = number;
        else if(view.getId()==(R.id.imageButton4))
            sq4 = number;
        else if(view.getId()==(R.id.imageButton5))
            sq5 = number;
        else if(view.getId()==(R.id.imageButton6))
            sq6 = number;
        else if(view.getId()==(R.id.imageButton7))
            sq7 = number;
        else if(view.getId()==(R.id.imageButton8))
            sq8 = number;
        else if(view.getId()==(R.id.imageButton9))
            sq9 = number;
    }

}

