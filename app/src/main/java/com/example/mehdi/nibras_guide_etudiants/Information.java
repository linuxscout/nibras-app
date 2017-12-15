package com.example.mehdi.nibras_guide_etudiants;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by mehdi on 06/04/16.
 */
public class Information extends Activity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv4 = (TextView) findViewById(R.id.textView);
        tv5 = (TextView) findViewById(R.id.textView2);
        tv6 = (TextView) findViewById(R.id.textView3);
        tv7 = (TextView) findViewById(R.id.textView3);

       // Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/LearningCurve.ttf");
      //  tv1.setTypeface(tf);

    }
    public void montrer1(View v){
      //  Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/LearningCurve.ttf");
        // afficher notre dialogue
        MonDialogue dialogue = new MonDialogue();
    //    dialogue.setTf(tf);

        dialogue.setStr(getString(R.string.textLmd1));
        dialogue.show(getFragmentManager(), "Dialogue");

    }
    public void montrer2(View v){

        // afficher notre dialogue
        MonDialogue dialogue = new MonDialogue();
        dialogue.setStr(getString(R.string.textLmd2));
        dialogue.show(getFragmentManager(), "Dialogue");

    }
    public void montrer3(View v){

        // afficher notre dialogue
        MonDialogue dialogue = new MonDialogue();
        dialogue.setStr(getString(R.string.textLmd3));
        dialogue.show(getFragmentManager(), "Dialogue");

    }
    public void montrer4(View v){

        // afficher notre dialogue
        MonDialogue dialogue = new MonDialogue();
        dialogue.setStr(getString(R.string.text4Lmd));
        dialogue.show(getFragmentManager(), "Dialogue");

    }
    public void montrer5(View v){

        // afficher notre dialogue
        MonDialogue dialogue = new MonDialogue();
        dialogue.setStr(getString(R.string.text5Lmd));
        dialogue.show(getFragmentManager(), "Dialogue");

    }
    public void montrer6(View v){

        // afficher notre dialogue
        MonDialogue dialogue = new MonDialogue();
        dialogue.setStr(getString(R.string.text6Lmd));
        dialogue.show(getFragmentManager(), "Dialogue");

    }
    public void montrer7(View v){

        // afficher notre dialogue
        MonDialogue dialogue = new MonDialogue();
        dialogue.setStr(getString(R.string.text7Lmd));
        dialogue.show(getFragmentManager(), "Dialogue");

    }

}
