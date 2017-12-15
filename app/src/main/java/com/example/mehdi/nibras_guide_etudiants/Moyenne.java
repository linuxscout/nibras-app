package com.example.mehdi.nibras_guide_etudiants;

/**
 * Created by mehdi on 07/04/16.
 */
public class Moyenne {
    int tabNote[];
    int tabNoteUF[];
    int tabNoteUM[];
    int tabNoteUD[];
    int tabNoteUT[];
    int tabCoeff[];
    int tabCoeffUniteFondamentale[];
    int tabCoeffUniteMethodologique[];
    int tabCoeffUniteDecouverte[];
    int tabCoeffUniteTransversal[];
    int totaleCoeff;
    int totaleCoeffUF;
    int totaleCoeffUM;
    int totaleCoeffUD;
    int totaleCoeffUT;
    public Moyenne(){}

   // calculer la moyenne complete du semestre
    public double calculeMoyenne(double tabNote[],int tabCoeff[], int totaleCoeff){
        double resultat = 0.0;

    for(int i=0; i < tabNote.length; i++){
        resultat = resultat + (tabNote[i] * tabCoeff[i]);
    }
        resultat = resultat / totaleCoeff;
        return resultat;
    }
   //calcule la moyenne des unités fondamental
    public double calculeMoyenneUF(double tabNoteUF[],int tabCoeffUniteFondamentale[], int totaleCoeffUF){
        double resultat = 0.0;

        for(int i=0; i < tabNoteUF.length; i++){
            resultat = resultat + (tabNoteUF[i] * tabCoeffUniteFondamentale[i]);
        }
        resultat = resultat / totaleCoeffUF;
        return resultat;
    }
    //calcule la moyenne des unités methodologique
    public double calculeMoyenneUM(double tabNoteUM[],int tabCoeffUniteMethodologique[], int totaleCoeffUM){
        double resultat = 0.0;

        for(int i=0; i < tabNoteUM.length; i++){
            resultat = resultat + (tabNoteUM[i] * tabCoeffUniteMethodologique[i]);
        }
        resultat = resultat / totaleCoeffUM;
        return resultat;
    }

    //calcule la moyenne des unités decouverte
    public double calculeMoyenneUD(double tabNoteUD[],int tabCoeffUniteDecouverte[], int totaleCoeffUD){
        double resultat = 0.0;

        for(int i=0; i < tabNoteUD.length; i++){
            resultat = resultat + (tabNoteUD[i] * tabCoeffUniteDecouverte[i]);
        }
        resultat = resultat / totaleCoeffUD;
        return resultat;
    }

    //calcule la moyenne des unités transversal
    public double calculeMoyenneUT(double tabNoteUT[],int tabCoeffUniteTransversal[], int totaleCoeffUT){
        double resultat = 0.0;

        for(int i=0; i < tabNoteUT.length; i++){
            resultat = resultat + (tabNoteUT[i] * tabCoeffUniteTransversal[i]);
        }
        resultat = resultat / totaleCoeffUT;
        return resultat;
    }

}

