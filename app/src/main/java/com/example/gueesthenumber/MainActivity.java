package com.example.gueesthenumber;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button startbt;
    private RadioButton r2,r3,r4,r5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startbt = findViewById(R.id.bt1);
        r2 = findViewById(R.id.radio2);
        r3 = findViewById(R.id.radio3);
        r4 = findViewById(R.id.radio4);
        r5 = findViewById(R.id.radio5);
        getSupportActionBar().hide();

        startbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Gameactivity.class);

                if(!r2.isChecked() && !r3.isChecked() && !r4.isChecked() && !r5.isChecked())//radio button checked if not checked then snakbar
                {
                    Snackbar.make(view, "PLEASE SELECT A CHOICE",Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    if(r2.isChecked())
                    {
                        intent.putExtra("two", true);
                    }
                    if(r3.isChecked())
                    {
                        intent.putExtra("two", true);
                    }
                    if(r4.isChecked())
                    {
                        intent.putExtra("two", true);
                    }
                    if(r5.isChecked())
                    {
                        intent.putExtra("two", true);
                    }
                    startActivity(intent);
                }
            }
        });
    }
}