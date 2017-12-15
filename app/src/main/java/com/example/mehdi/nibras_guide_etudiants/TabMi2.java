package com.example.mehdi.nibras_guide_etudiants;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mehdi on 09/08/16.
 */
public class TabMi2  extends Fragment {
    public EditText e1,e2,e3,e4,e5,e6,e7,e8;
    public TextView t1,t2,t3,t4;


    public Button calc,eff ;
    Moyenne m = new Moyenne();

    public  double tabNote[];
    public  double tabNoteUF[];
    public  double tabNoteUM[];
    public  double tabNoteUD[];
    public  double tabNoteUT[];
    public int tabCoeff[] = {2,2,1,3,2,2,1,2};
    public int tabCoeffUF[]= {2,2,1};
    public int tabCoeffUM[]= {3,2};
    public int tabCoeffUD[]= {2,1};
    public int tabCoeffUT[]= {2};
    public int totaleCoeff = 15;
    public int totaleCoeffUF = 5;
    public int totaleCoeffUM = 5;
    public int totaleCoeffUD = 3;
    public int totaleCoeffUT = 2;
    public int id[] = {R.id.editText1,R.id.editText2,R.id.editText3,R.id.editText4,R.id.editText5,R.id.editText6,R.id.editText7,R.id.editText8};

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.mi_semestre2, container, false);

        calc = (Button) v.findViewById(R.id.btn_calcule);
        eff = (Button) v.findViewById(R.id.btn_efface);


        t1 = (TextView) v.findViewById(R.id.txtResultat1);
        t2 = (TextView) v.findViewById(R.id.txtResultat2);
        t3 = (TextView) v.findViewById(R.id.txtResultat3);
        t4 = (TextView) v.findViewById(R.id.txtResultat4);


        e1 = (EditText) v.findViewById(R.id.editText1);
        e2 = (EditText) v.findViewById(R.id.editText2);
        e3 = (EditText) v.findViewById(R.id.editText3);
        e4 = (EditText) v.findViewById(R.id.editText4);
        e5 = (EditText) v.findViewById(R.id.editText5);
        e6 = (EditText) v.findViewById(R.id.editText6);
        e7 = (EditText) v.findViewById(R.id.editText7);
        e8 = (EditText) v.findViewById(R.id.editText8);

        tabNote = new double[8];
        tabNoteUF = new double[3];
        tabNoteUM = new double[2];
        tabNoteUD = new double[2];
        tabNoteUT = new double[1];

        calc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                afficher(v);
            }
        });

        eff.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                effacer(v);
            }
        });
        return v;
    }
    public double calcule(){
        double r = 0.0;
        if(e1.getText().toString().equals("")){
            e1.setText("0");
            tabNote[0]=0.0;
        }else{
            tabNote[0] = Double.parseDouble(e1.getText().toString());

        }

        if(e2.getText().toString().equals("")){
            e2.setText("0");
            tabNote[1]=0.0;
        }else{
            tabNote[1] = Double.parseDouble(e2.getText().toString());

        }

        if(e3.getText().toString().equals("")){
            e3.setText("0");
            tabNote[2]=0.0;
        }else{
            tabNote[2] = Double.parseDouble(e3.getText().toString());

        }

        if(e4.getText().toString().equals("")){
            e4.setText("0");
            tabNote[3]=0.0;
        }else{
            tabNote[3] = Double.parseDouble(e4.getText().toString());

        }

        if(e5.getText().toString().equals("")){
            e5.setText("0");
            tabNote[4]=0.0;
        }else{
            tabNote[4] = Double.parseDouble(e5.getText().toString());

        }

        if(e6.getText().toString().equals("")){
            e6.setText("0");
            tabNote[5]=0.0;
        }else{
            tabNote[5] = Double.parseDouble(e6.getText().toString());

        }

        if(e7.getText().toString().equals("")){
            e7.setText("0");
            tabNote[6]=0.0;
        }else{
            tabNote[6] = Double.parseDouble(e7.getText().toString());

        }

        if(e8.getText().toString().equals("")){
            e8.setText("0");
            tabNote[7]=0.0;
        }else{
            tabNote[7] = Double.parseDouble(e8.getText().toString());

        }



        r = m.calculeMoyenne(tabNote,tabCoeff,totaleCoeff);
        return r;
    }


    public double calculeUF(){
        double r = 0.0;
        if(e1.getText().toString().equals("")){
            e1.setText("0");
            tabNoteUF[0]=0.0;
        }else{
            tabNoteUF[0] = Double.parseDouble(e1.getText().toString());
        }

        if(e2.getText().toString().equals("")){
            e2.setText("0");
            tabNoteUF[1]=0.0;
        }else{
            tabNoteUF[1] = Double.parseDouble(e2.getText().toString());
        }

        if(e3.getText().toString().equals("")){
            e3.setText("0");
            tabNoteUF[2]=0.0;
        }else{
            tabNoteUF[2] = Double.parseDouble(e3.getText().toString());
        }

        r = m.calculeMoyenneUF(tabNoteUF, tabCoeffUF, totaleCoeffUF);
        return r;
    }

    public double calculeUM(){
        double r = 0.0;

        if(e4.getText().toString().equals("")){
            e4.setText("0");
            tabNoteUM[0]=0.0;
        }else{
            tabNoteUM[0] = Double.parseDouble(e4.getText().toString());
        }

        if(e5.getText().toString().equals("")){
            e5.setText("0");
            tabNoteUM[1]=0.0;
        }else{
            tabNoteUM[1] = Double.parseDouble(e5.getText().toString());
        }

        r = m.calculeMoyenneUM(tabNoteUM, tabCoeffUM, totaleCoeffUM);
        return r;
    }

    public double calculeUD(){
        double r = 0.0;

        if(e6.getText().toString().equals("")){
            e6.setText("0");
            tabNoteUD[0]=0.0;
        }else{
            tabNoteUD[0] = Double.parseDouble(e6.getText().toString());
        }

        if(e7.getText().toString().equals("")){
            e7.setText("0");
            tabNoteUD[1]=0.0;
        }else{

            tabNoteUD[1] = Double.parseDouble(e7.getText().toString());
        }

        r = m.calculeMoyenneUD(tabNoteUD, tabCoeffUD, totaleCoeffUD);
        return r;
    }

    public double calculeUT(){
        double r = 0.0;

        if(e8.getText().toString().equals("")){
            e8.setText("0");
            tabNoteUT[0]=0.0;
        }else{
            tabNoteUT[0] = Double.parseDouble(e8.getText().toString());
        }

        r = m.calculeMoyenneUT(tabNoteUT, tabCoeffUT, totaleCoeffUT);
        return r;
    }

    public void afficher(View v){
        java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
        double resultat = 0.0,resultatUF = 0.0,resultatUM = 0.0,resultatUD = 0.0,resultatUT = 0.0;

        resultat = calcule();
        resultatUF = calculeUF();
        resultatUM = calculeUM();
        resultatUD = calculeUD();
        resultatUT = calculeUT();

        String str1 = "-Moyenne UF est: "+df.format(resultatUF)+"\n";
        String str2 = "-Moyenne UM est: "+df.format(resultatUM)+"\n";
        String str3 = "-Moyenne UD est: "+df.format(resultatUD)+"\n";
        String str4 = "-Moyenne UT est: " + df.format(resultatUT)+"\n";
        String str5 = "-Moyenne generale est: "+df.format(resultat) + "\n";

        acquisOrNot(resultatUF, resultatUM, resultatUD, resultatUT);

        MonDialogue dialogue = new MonDialogue();
        dialogue.setStr(""+str1+str2+str3+str4+str5+ratrapageOrNot(resultat)+"\n");
        Log.d("aaaaaaaaaaaa", "aaaaaaaaaaaa");
        dialogue.show(getActivity().getFragmentManager(),"Dialogue");

    }
    public void effacer(View v){
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
        e6.setText("");
        e7.setText("");
        e8.setText("");
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");

    }
    public void acquisOrNot(double resultatUF ,double resultatUM,double resultatUD,double resultatUT){
        if(resultatUF >= 10){
            t1.setText(getResources().getString(R.string.uef_acuise));
            t1.setTextColor(getResources().getColor(R.color.aquis));
        }

        else{
            t1.setText(getResources().getString(R.string.uef_non_acuise));
            t1.setTextColor(getResources().getColor(R.color.non_aquis));
        }

        if(resultatUM >= 10){
            t2.setText(getResources().getString(R.string.uem_acuise));
            t2.setTextColor(getResources().getColor(R.color.aquis));
        }

        else{
            t2.setText(getResources().getString(R.string.uem_non_acuise));
            t2.setTextColor(getResources().getColor(R.color.non_aquis));
        }


        if(resultatUD >= 10){
            t3.setText(getResources().getString(R.string.ued_acuise));
            t3.setTextColor(getResources().getColor(R.color.aquis));
        }

        else{
            t3.setText(getResources().getString(R.string.ued_non_acuise));
            t3.setTextColor(getResources().getColor(R.color.non_aquis));
        }


        if(resultatUT >= 10){
            t4.setText(getResources().getString(R.string.uet_acuise));
            t4.setTextColor(getResources().getColor(R.color.aquis));
        }

        else{
            t4.setText(getResources().getString(R.string.uet_non_acuise));
            t4.setTextColor(getResources().getColor(R.color.non_aquis));
        }

    }

    public String ratrapageOrNot(double resultat){
        String str,module1 ="",module2="",module3="",module4="",module5="",module6="",module7="",module8="";
        String allModule;
        if(Double.parseDouble(e1.getText().toString())<10)
        {
            module1 = " -"+getResources().getString(R.string.analyse2)+"\n";
            //module1 = "-Analyse2\n" ;
        }
        if(Double.parseDouble(e2.getText().toString())<10)
        {
            module2 = " -"+getResources().getString(R.string.algebre2)+"\n";
            //module2 = "-Algebre2\n" ;
        }
        if(Double.parseDouble(e3.getText().toString())<10)
        {
            module3 = " -"+getResources().getString(R.string.proba_stat)+"\n";
            //module3 = "-Algorithme\n" ;
        }
        if(Double.parseDouble(e4.getText().toString())<10)
        {
            module4 = " -"+getResources().getString(R.string.prog_struc_donnee)+"\n";
            //module4 = "-Bureautique\n" ;
        }
        if(Double.parseDouble(e5.getText().toString())<10)
        {
            module5 = " -"+getResources().getString(R.string.Structure_machine)+"\n";
            //module5 = "-Français\n" ;
        }
        if(Double.parseDouble(e6.getText().toString())<10)
        {
            module6 = " -"+getResources().getString(R.string.tic)+"\n";
            //module6 = "-Codage\n" ;
        }
        if(Double.parseDouble(e7.getText().toString())<10)
        {
            module7 = " -"+getResources().getString(R.string.POO)+"\n";
            //module7 = "-Economie\n" ;
        }
        if(Double.parseDouble(e8.getText().toString())<10)
        {
            module8 = " -"+getResources().getString(R.string.electricite)+"\n";
            //module8 = "-Anglais\n" ;
        }

        allModule = module1+module2+module3+module4+module5+module6+module7+module8;
        if (resultat>=10){
            str = "Vous avez eu votre semestre";
        }
        else
            str = "Vous pouvais rattraper dans les module suivant : \n"+allModule;

        return str;
    }
}