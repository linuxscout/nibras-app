package com.example.mehdi.nibras_guide_etudiants;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

/**
 * Created by mehdi on 20/11/16.
 */
public class Filiere extends AppCompatActivity {
    private Locale myLocale = null;
    private Button btn_mi,btn_st,btn_sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filiere);

        btn_mi = (Button) findViewById(R.id.btn_mi);
        btn_st = (Button) findViewById(R.id.btn_st);
        btn_sm = (Button) findViewById(R.id.btn_sm);



    }

    public void lancerMi(View v) {
        Intent intent = new Intent(this, Tab_MI.class);
        startActivity(intent);
    }

    public void lancerSt(View v) {
        Intent intent = new Intent(this, Tab_ST.class);
        startActivity(intent);
    }

    public void lancerSm(View v) {
        Intent intent = new Intent(this, Tab_SM.class);
        startActivity(intent);
    }




}