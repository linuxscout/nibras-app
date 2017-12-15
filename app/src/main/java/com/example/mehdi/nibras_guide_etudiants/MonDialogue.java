package com.example.mehdi.nibras_guide_etudiants;

import android.app.DialogFragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mehdi on 19/05/16.
 */
public class MonDialogue extends DialogFragment {
    TextView tv;
    int id;
    String str;
    Typeface tf;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/LearningCurve.ttf");
        //  tv1.setTypeface(tf);

        final View v = inflater.inflate(R.layout.dialogue, container, false);

        // recupere l'objet bouton pour reagir au clic

        tv = (TextView) v.findViewById(R.id.textView5);

//tv.setTypeface(getTf());
     //   tv.setText(getIds());

        tv.setText(getStr());

        return v;

    }
    public void setIds(int id){
        this.id = id;
    }
    public int getIds(){
        return id;
    }
    public void setStr(String str){
        this.str = str;
    }
    public String getStr(){
        return str;
    }
    public void setTf(Typeface tf){
        this.tf = tf;
    }
    public Typeface getTf(){
        return tf;
    }
}

