package com.example.findcityname;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class GamePlay extends AppCompatActivity implements Cities {

    //==============================================================================================
    private TextView textVNlet,textVPassword,txtVPoint,txtTotPoint;
    private EditText editTxtInput;
    private Random rndIl,rndNum;
    private int rnd1,rnd2;
    private String randomCity,dollar;
    char[] c,c1,c2;
    ArrayList<Integer> arr1 = new ArrayList<>();
    ArrayList<Integer> arr2 = new ArrayList<>();
    private int point,totalpoint=0;

    //==============================================================================================
    //first char c is the letters of the name of the city
    //second char c2 is the dollars
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
        textVNlet = (TextView) findViewById(R.id.textVNlet);
        textVPassword = (TextView) findViewById(R.id.textVPassword);
        txtVPoint = (TextView) findViewById(R.id.txtVPoint);
        txtTotPoint = (TextView) findViewById(R.id.txtTotPoint);
        editTxtInput = (EditText)findViewById(R.id.editTxtInput);
        playGame();

    }

    public void playGame(){

        //rnd is used to choose the city name from the array
        rndIl = new Random();
        rnd1 = rndIl.nextInt(cities.length);

        //here we check not to choose the same word twice
        if(!arr2.contains(rnd1)) {

            point = 100;
            txtVPoint.setText("Xal: "+String.valueOf(point));

            //==============================================
            arr2.add(rnd1);
            randomCity = cities[rnd1];
            c = randomCity.toCharArray();
            //==============================================

            //we clear the arraylist we used for help letter
            arr1.clear();
            //==============================================

            // for the first textview=======================
            textVNlet.setText(String.valueOf(c.length) + " Hərfli Şəhər");
            dollar = "";
            for (int i = 0; i < c.length; i++) {
                dollar += "$";
            }

            textVPassword.setText(dollar);
            c2 = dollar.toCharArray();
            //==============================================
        }
    }


    public void check(View view) {

        //checking whether the answer is true or not
        if(editTxtInput.getText().toString().equals(randomCity)) {
            System.out.println("Dogrudur");
            editTxtInput.setText("");


            // when the answer is true we add the current point to the total one
            totalpoint += point;
            txtTotPoint.setText("Ümumi Xal: "+String.valueOf(totalpoint));

            //when answer is true the game passes to the next word by calling this function
            playGame();

        }else {
            openDialog();
            editTxtInput.setText("");
        }
    }


    //open dialog function when giving the wrong answer to the question
    public void openDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Yanlış Cavab")
                .setMessage("Yenidən cəhd edin")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();
    }


    public void helpLet(View view) {

        int i = 30;

        while(i>0) {

            rndNum = new Random();
            rnd2 = rndNum.nextInt(c.length);
            // here we are checking not to have the same letter from letter help function
            if (!arr1.contains(rnd2)) {
                c2[rnd2] = c[rnd2];
                String str = new String(c2);
                textVPassword.setText(str);
                arr1.add(rnd2);
            //============================================================================

                // here we subtract the point for every letter that the user gets
                int dif = 100 / c.length;
                point -= dif;
                txtVPoint.setText("Xal: "+ String.valueOf(point));
                //===============================================================
                break;

            }else{
                i-=1;
                continue;
            }
        }
    }

    public void exittheGame(View view) {
        finish();
        System.exit(0);
    }
}