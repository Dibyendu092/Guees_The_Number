package com.example.gueesthenumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Gameactivity extends AppCompatActivity {

    private TextView t1,t2,t3;
    private Button lb;
    private EditText et;

    boolean twodigit, threedigit, fourdigit, fivedigit;

    Random r = new Random();//no of digit chosen by the user  generated randomly.so to do that create a random object
    int random;
    int chance=10;

    ArrayList<Integer> glist = new ArrayList<>();//store the number i put
    int attempt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameactivity);

        t1 = findViewById(R.id.txt1);
        t2 = findViewById(R.id.txt2);
        t3 = findViewById(R.id.txt3);
        et = findViewById(R.id.no1);
        lb = findViewById(R.id.bt11);



        twodigit = getIntent().getBooleanExtra("two",false);
        threedigit = getIntent().getBooleanExtra("three",false);
        fourdigit = getIntent().getBooleanExtra("four",false);
        fivedigit = getIntent().getBooleanExtra("five",false);

        if(twodigit)
        {
            random = r.nextInt(90)+10;//if the no started from o then it transferd to 10 digit same for 99
        }
        if(threedigit)
        {
            random = r.nextInt(900)+100;//same
        }
        if(fourdigit)
        {
            random = r.nextInt(9000)+1000;//same
        }
        if(fivedigit)
        {
            random = r.nextInt(90000)+10000;//same
        }
        //clicking the button
        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String guess = et.getText().toString();
              if(guess.equals(""))
              {
                  Toast.makeText(Gameactivity.this, "PLEASE ENTTER A NO",Toast.LENGTH_LONG).show();//check the enter no slot is empty or not
              }
              else
              {
                  t1.setVisibility(View.VISIBLE);//set visible text component
                  t2.setVisibility(View.VISIBLE);
                  t3.setVisibility(View.VISIBLE);

                  attempt++;//count attempt no
                  chance--;//count chances remaining

                  int ugues = Integer.parseInt(guess);
                  glist.add(ugues);//adding input of mine
                  t3.setText("YOUR LAST GUESS:"+guess);//show the guess
                  t2.setText("YOUR CHANCES REMAINING:"+chance);//show the chances remaining

                  if(random == ugues)//if user no and sysytem no are matched
                  {
                      //this whole code for creating alertdialog box
                      AlertDialog.Builder builder = new AlertDialog.Builder(Gameactivity.this);
                      builder.setTitle("NUMBER GUESSING GAME");
                      builder.setCancelable(false);
                      builder.setMessage("YOUR GUESS IS CORRECT:"+random+"\n\n YOU WIN THE GAME"+"\n\n YOUR GUESSES ARE :"+glist+"\n\nATTEMPT NO:"+attempt+"\n\n WOULD YOU LIKE TO PLAY AGAIN:");
                      builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialogInterface, int i) {

                              Intent ip = new Intent(Gameactivity.this, MainActivity.class);
                              startActivity(ip);
                              finish();
                          }
                      });
                      builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialogInterface, int i) {
                             moveTaskToBack(true);
                             android.os.Process.killProcess(android.os.Process.myPid());
                             System.exit(1);
                          }
                      });
                      builder.create().show();
                  }
                  if(random < ugues)//if the no is greater
                  {
                      t1.setText("PLEASE DECREASE NO");
                  }
                  if(random > ugues)//if the no is lesser
                  {
                      t1.setText("PLEASE INCREASE NO");
                  }
                  if(chance == 0)//if the user losese game
                  {

                      AlertDialog.Builder builder = new AlertDialog.Builder(Gameactivity.this);
                      builder.setTitle("NUMBER GUESSING GAME");
                      builder.setCancelable(false);
                      builder.setMessage("YOUR LOSE THE GAME:"+random+"\n\n YOUR GUESSES ARE :"+glist+"\n\nATTEMPT NO:"+attempt+"\n\n WOULD YOU LIKE TO PLAY AGAIN:");
                      builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialogInterface, int i) {

                              Intent ip = new Intent(Gameactivity.this, MainActivity.class);
                              startActivity(ip);
                              finish();
                          }
                      });
                      builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialogInterface, int i) {
                              moveTaskToBack(true);
                              android.os.Process.killProcess(android.os.Process.myPid());
                              System.exit(1);
                          }
                      });
                      builder.create().show();
                  }
                  et.setText("");//clear
              }
            }
        });


    }
}