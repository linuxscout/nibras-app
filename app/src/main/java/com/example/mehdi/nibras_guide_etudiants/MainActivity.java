package com.example.mehdi.nibras_guide_etudiants;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Locale;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {
    private Locale myLocale = null;
    private Button btn_lang_ar, btn_lang_fr, btn_dico, btn_moyenne, btn_info, btn_apropos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_lang_ar = (Button) findViewById(R.id.btn_langage_arabic);
        btn_lang_fr = (Button) findViewById(R.id.btn_langage_franch);
        btn_dico = (Button) findViewById(R.id.btn_dictionnaire);
        btn_moyenne = (Button) findViewById(R.id.btn_calcule_moyenne);
        btn_info = (Button) findViewById(R.id.btn_information);
        btn_apropos = (Button) findViewById(R.id.btn_apropos);

    //    loadLocale();
    }

    public void lancerDiconnaire(View v) {
        Intent intent = new Intent(this, Diconnaire.class);
        startActivity(intent);
    }

 public void lancerLmd(View v) {
        Intent intent = new Intent(this, Filiere.class);
        startActivity(intent);
    }
    public void lancerInformation(View v) {
        Intent intent = new Intent(this, Information.class);
        startActivity(intent);
    }

    public void lancerApropos(View v) {
        Intent intent = new Intent(this, Apropos.class);
        startActivity(intent);
    }


    public void changeLang(String lang) {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);
        saveLocale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        updateTexts();
    }

    public void saveLocale(String lang) {
        String langPref = "Language";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(langPref, lang);
        editor.commit();
    }

    public void loadLocale() {
        String langPref = "Language";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        String language = prefs.getString(langPref, "");
        changeLang(language);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    //cette ligne est faite pour la fonction getDrawable le probleme c'etais une question de version
    private void updateTexts() {
        btn_dico.setText(R.string.btn_diconnaire);
        btn_moyenne.setText(R.string.btn_calcule_moyenne);



    }

    public void langueeAr(View v) {
        setLocale("ar");

    }
    public void langueeFr(View v) {
        setLocale("fr");
    }

    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    //    this.finish();

        updateTexts();

        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);


    }
}